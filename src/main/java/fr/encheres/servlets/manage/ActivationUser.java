package fr.encheres.servlets.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.UserManagerImp;
import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

/**
 * Servlet implementation class ActivationUser
 */
@WebServlet("/activationUser")
public class ActivationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserManager manager;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivationUser() {
    	manager = UserManagerImp.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<User>users= (List<User>)session.getAttribute("users");
		int indexActive = Integer.parseInt((String)request.getParameter("active"));
		User userActive = null;
		for (User user : users) {
			if (user.getIdUser()==indexActive) {
				userActive=user;
				break;
			}	
		}
		try {
			manager.activeUser(userActive);
			request.getRequestDispatcher("manageUsersServlet").forward(request, response);
		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
