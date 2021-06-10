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

/**
 * Servlet implementation class Profil
 */
@WebServlet("/profilServlet")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserManager userManager;

	@Override
	public void init() throws ServletException {
		userManager = new UserManagerImp();
	}
       
    public Profil() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("skeleton?body=6").forward(request, response);
	}


}
