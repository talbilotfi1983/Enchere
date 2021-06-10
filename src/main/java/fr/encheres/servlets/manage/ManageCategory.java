package fr.encheres.servlets.manage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.BllException;
import fr.encheres.bll.CategoryManagerImp;
import fr.encheres.bll.interfaces.ICategoryManager;
import fr.encheres.bo.Category;
import fr.encheres.dal.DalException;

/**
 * Servlet implementation class ManageCategoryServlet
 */
@WebServlet("/manageCategoryServlet")
public class ManageCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICategoryManager categoryManager;
	List<Category> categories;
	HttpSession session;

	public ManageCategory() {
		categoryManager = CategoryManagerImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		categories = (List<Category>) session.getAttribute("categories");
		response.sendRedirect("skeleton?body=9");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			if ("update".equals(request.getParameter("submit"))) {
				int idCategory = Integer.parseInt((String) request.getParameter("idCategory"));
				String libelle = request.getParameter("libelle");
				categoryManager.updateCategory(idCategory, libelle);
				Category category = searchCategory(idCategory);
				Category category1 = category;
				category1.setLibelle(libelle);
				Collections.replaceAll(categories, category,category1);
			} else  if("delete".equals(request.getParameter("submit"))){
				int idCategory = Integer.parseInt((String) request.getParameter("idCategory"));
				categoryManager.deleteCategory(idCategory);
				Category category = searchCategory(idCategory);
				categories.remove(category);
				
				
			}else {
				String libelle = request.getParameter("libelle");
				Category category=categoryManager.insertCategory(libelle);
				categories.add(category);
			}
		} catch (DalException | BllException e) {
			new DalException(e.getMessage(), e);
		}
		session.setAttribute("categories", categories);
		response.sendRedirect("skeleton?body=9");
		
	}

	private Category searchCategory(int idCategory) {
		for (Category category_ : categories) {
			if (category_.getIdCategory()==idCategory) {
				return category_;
			}
		}
		return null;
	}
	
}