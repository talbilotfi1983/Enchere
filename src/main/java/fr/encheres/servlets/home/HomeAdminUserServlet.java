package fr.encheres.servlets.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.ArticleManagerImp;
import fr.encheres.bll.CategoryManagerImp;
import fr.encheres.bll.interfaces.IArticleManager;
import fr.encheres.bll.interfaces.ICategoryManager;
import fr.encheres.bo.Article;
import fr.encheres.bo.Category;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

@WebServlet("/homeAdminUserServlet")
public class HomeAdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArticleManager articleManager;
	private ICategoryManager categoryManager;

	public HomeAdminUserServlet() {
		articleManager = ArticleManagerImp.getInstance();
		categoryManager = CategoryManagerImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Article> articles;
		List<Category> categories;
		try {
			categories = categoryManager.selectAllCategory();
			articles = articleManager.selectAllArticles(0, 0, null, null);
			request.setAttribute("articlesCourants", articles);
			session.setAttribute("categories", categories);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("skeleton?body=2").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("selectArticle") != null) {
			int idArticle = Integer.parseInt(request.getParameter("selectArticle"));
			try {
				System.out.println(idArticle);
				Article article = articleManager.selectArticleId(idArticle);
				request.setAttribute("articleEncours", article);
				request.getRequestDispatcher("skeleton?body=12").forward(request, response);
				System.out.println(article);
			} catch (DalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		
		String key = null;
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}

		int idCategory = 0;
		if (request.getParameter("idCategory") != null) {
			idCategory = Integer.parseInt(request.getParameter("idCategory"));
		}

		String venteParam = request.getParameter("vente");
		HttpSession session = request.getSession();
		int idUser = 0;
		if (session.getAttribute("userSuccess") != null) {
			idUser = ((User) session.getAttribute("userSuccess")).getIdUser();
		}

		// String achat = request.getParameter("achat");
		List<Article> articles;
		try {
			articles = articleManager.selectAllArticles(idUser, idCategory, key, venteParam);
			request.setAttribute("articlesCourants", articles);
			request.getRequestDispatcher("skeleton?body=2").forward(request, response);
		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}

		

	}}

}