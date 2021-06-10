package fr.encheres.servlets.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.encheres.bll.UserManagerImp;
import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;
import javax.servlet.http.HttpSession;

@WebServlet("/manageUsersServlet")
public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;
	public ManageUsers() {
		userManager = UserManagerImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
	
			try {
				users = userManager.selectAllUsers();
				HttpSession session = request.getSession();
				session.setAttribute("users", users);
			} catch (DalException e) {
				throw new ServletException(e.getMessage(), e);
			}
			request.getRequestDispatcher("skeleton?body=8").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
