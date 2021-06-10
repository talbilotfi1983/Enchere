package fr.encheres.servlets.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.BllException;
import fr.encheres.bll.UserManagerImp;
import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

/**
 * Servlet implementation class enregistrement
 */
@WebServlet("/registerServlet")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;

	@Override
	public void init() throws ServletException {
		userManager = new UserManagerImp();
	}

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("skeleton?body=4").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setCivilite(request.getParameter("civilite"));
		user.setPseudo(request.getParameter("pseudo"));
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setTelephone(request.getParameter("telephone"));
		user.setEmail(request.getParameter("email"));
		user.setNumero(request.getParameter("numero"));
		user.setAdresse(request.getParameter("adresse"));
		user.setVille(request.getParameter("ville"));
		user.setCodePostal(request.getParameter("codePostal"));
		user.setMotDePasse(request.getParameter("password"));
		
		user.setAdmin(false);
		user.setCredit(0);
		try {
			HttpSession session = request.getSession();
			userManager.insertUser(user);
		} catch (DalException | BllException e) {
			throw new ServletException(e.getMessage(), e);
			
		}
		request.getRequestDispatcher("loginServlet").forward(request, response);;
	}

}
