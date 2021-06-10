package fr.encheres.servlets.manage;

import java.io.IOException;
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

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserManager manager;

	public DeleteUser() {
		manager = UserManagerImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idRemove =Integer.parseInt(request.getParameter("delete"));
		int idUserSuccess = ((User) session.getAttribute("userSuccess")).getIdUser();
		
		try {
			manager.suprimerUser(idRemove);
			
			if (idRemove == idUserSuccess) {
			
			session.removeAttribute("userSuccess");

			request.getRequestDispatcher("homeVisitorServlet").forward(request, response);
		}else {
			
			response.sendRedirect("manageUsersServlet");
		}

		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}

	}

}
