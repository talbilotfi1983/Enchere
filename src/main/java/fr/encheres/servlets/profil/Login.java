package fr.encheres.servlets.profil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.BllException;
import fr.encheres.bll.UserManagerImp;
import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.Category;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

@WebServlet("/loginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;
	private Autentification autentification;

	@Override
	public void init() throws ServletException {
		userManager = UserManagerImp.getInstance();
		autentification = new Autentification();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		String pseudo = null;
		String password = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				pseudo = cookie.getName().equals("pseudo") ? cookie.getValue() : null;
				password = cookie.getName().equals("password") ? cookie.getValue() : null;
			}
		}
		if (pseudo != null && password != null) {
			HttpSession session = req.getSession();
			try {
				User user = userManager.selectUserAutentification(new Autentification(pseudo, password));
				session.setAttribute("userSuccess", user);
				req.getRequestDispatcher("homeAdminUserServlet").forward(req, resp);
			} catch (BllException | SQLException | DalException e) {
				throw new ServletException(e.getMessage(), e);
			}

		}
		req.getRequestDispatcher("skeleton?body=3").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		String remember_me = request.getParameter("remember_me");
		final String CONNECT_FAILED = "Connect failed, pseudo or password incorect !";
		final String CONNECT_LOOKED ="You account has been disabled";
		User user = null;
		if (remember_me != null) {
			Cookie pseudoCookie = new Cookie("pseudo", pseudo);
			Cookie passwordCookie = new Cookie("password", password);
			pseudoCookie.setMaxAge(60 * 60 * 24 * 30);
			passwordCookie.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(pseudoCookie);
			response.addCookie(passwordCookie);

		}
		autentification.setPassword(password);
		autentification.setPseudo(pseudo);
		try {
			user = userManager.selectUserAutentification(autentification);
			
			
			if (user == null) {
				request.setAttribute("message", CONNECT_FAILED);
				request.getRequestDispatcher("skeleton?body=3").forward(request, response);
				
			} else {
				 if(!user.isActive()) {
					 
						request.setAttribute("message", CONNECT_LOOKED);
						request.getRequestDispatcher("skeleton?body=3").forward(request, response);
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("userSuccess", user);
						response.sendRedirect("homeAdminUserServlet");

						
							
					}
				
				

			}
			
		} catch (BllException | SQLException | DalException e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

}
