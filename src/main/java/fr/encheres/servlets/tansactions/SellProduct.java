package fr.encheres.servlets.tansactions;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.encheres.bll.ArticleManagerImp;
import fr.encheres.bll.BllException;
import fr.encheres.bll.CategoryManagerImp;
import fr.encheres.bll.interfaces.IArticleManager;
import fr.encheres.bll.interfaces.ICategoryManager;
import fr.encheres.bo.Adresse;
import fr.encheres.bo.Article;
import fr.encheres.bo.Category;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;
import javax.servlet.http.HttpSession;

import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class SellProduct
 */
@WebServlet("/sellProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class SellProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICategoryManager categoryManager;
	private IArticleManager articleManager;
	public static int index;
	public static String fullPath;

	public SellProduct() {
		super();
		categoryManager = CategoryManagerImp.getInstance();
		articleManager = ArticleManagerImp.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Category> categories = categoryManager.selectAllCategory();
			request.setAttribute("categories", categories);
		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
		request.getRequestDispatcher("skeleton?body=10").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSuccess");
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		int mise_a_prix = Integer.parseInt(request.getParameter("mise_a_prix"));
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		int idUser = user.getIdUser();
		
		

		StringBuilder dateHeureDebutEnchere = new StringBuilder(request.getParameter("date_debut_enchere") + " ");
		dateHeureDebutEnchere.append(request.getParameter("heure_debut_enchere"));
		dateHeureDebutEnchere.append(":00");

		Timestamp debutEnchere = Timestamp.valueOf(dateHeureDebutEnchere.toString());
		StringBuilder dateHeurefinEnchere = new StringBuilder(request.getParameter("date_fin_enchere") + " ");
		dateHeurefinEnchere.append(request.getParameter("heure_fin_enchere"));
		dateHeurefinEnchere.append(":00");

		Timestamp finEnchere = Timestamp.valueOf(dateHeurefinEnchere.toString());
		Article article = new Article(nom_article, description, debutEnchere, finEnchere, mise_a_prix, mise_a_prix,
				idCategorie, idUser);
		String numero = request.getParameter("numero");
		String adress = request.getParameter("adresse");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		Adresse adresse = new Adresse(numero+" "+adress,ville,codePostal);
		try {
			articleManager.insertArticle(article,adresse);
		} catch (DalException | BllException e) {
			throw new ServletException(e.getMessage(), e);
		}

		String extention = null;
		String uploadPath =  System.getProperty("user.home") + "\\imageEncheres\\";
		for (Part part : request.getParts()) {
			extention = getExtention(part);
			if (extention!=null) {
				String fullPath = uploadPath +article.getIdArticle() + extention;
				part.write(fullPath);

				break;
			}

		}
		if (extention!=null)
			try {
				articleManager.setPicture(extention, article.getIdArticle());
			} catch (DalException e) {
				throw new ServletException(e.getMessage(), e);
			}
		request.getRequestDispatcher("homeAdminUserServlet").forward(request, response);
	}

	private String getExtention(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return "." + content.substring(content.indexOf(".") + 1, content.length() - 1);
			}

		}
		return null;

	}
	
}
