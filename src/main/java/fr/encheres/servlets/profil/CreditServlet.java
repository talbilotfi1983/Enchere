package fr.encheres.servlets.profil;

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

@WebServlet("/creditServlet")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;

	public CreditServlet() {
		userManager = UserManagerImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("skeleton?body=11");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userSuccess");
		int credit = Integer.parseInt((String)request.getParameter("credit"));
		try {
			credit+=user.getCredit();
			userManager.setCredit(credit,user.getIdUser());
			user.setCredit(credit);
			session.setAttribute("userSuccess", user);
		} catch (DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
		response.sendRedirect("profilServlet");
	}
	
}
