package fr.encheres.servlets.profil;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.encheres.bll.UserManagerImp;
import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;


@WebServlet("/updateProfilServlet")
public class UpdateProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;

	@Override
	public void init() throws ServletException {
		userManager = new UserManagerImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("skeleton?body=7").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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
		user.setMotDePasse(request.getParameter("motDePasse"));
		HttpSession session =request.getSession();
		User lastUser =  (User) session.getAttribute("userSuccess");
		user.setAdmin(lastUser.isAdmin());
		user.setCredit(lastUser.getCredit());
		user.setIdUser(lastUser.getIdUser());
		
		try {
			session.setAttribute("userSuccess", user);

			userManager.majUser(user.getIdUser(), user);
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("pseudo")) {
					cookie.setValue(user.getPseudo());
				}
				if (cookie.getName().equals("password")) {
					
					cookie.setValue(user.getMotDePasse());
				}

			}
			
			request.getRequestDispatcher("skeleton?body=6").forward(request, response);
		} catch (DalException | ServletException e) {
			throw new ServletException(e.getMessage(), e);

		}

	}

}
