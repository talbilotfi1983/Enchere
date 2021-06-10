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
import fr.encheres.dal.DalException;
import fr.encheres.dal.interfaces.IArticleDao;

/**
 * Servlet implementation class HomeVisitorServlet
 */
@WebServlet("/homeVisitorServlet")
public class HomeVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArticleManager articleManager;
	private ICategoryManager categoryManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeVisitorServlet() {
		articleManager = ArticleManagerImp.getInstance();
		categoryManager = CategoryManagerImp.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Category> categories = categoryManager.selectAllCategory();
			HttpSession session = request.getSession();
			session.setAttribute("categories", categories);
			List<Article> articles = articleManager.selectAllArticles(0,0, null,null);
			session.setAttribute("articles", articles);
			request.setAttribute("articlesCourants", articles);

		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
		request.getRequestDispatcher("skeleton?body=1").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		int idCategory =0;
		if (request.getParameter("idCategory")!=null) {
			idCategory = Integer.parseInt(request.getParameter("idCategory"));
		}
		
		
		try {
			List<Article> articles = articleManager.selectAllArticles(0,idCategory, key,null);
			request.setAttribute("articlesCourants", articles);
		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
		request.getRequestDispatcher("skeleton?body=1").forward(request, response);
	}

}
