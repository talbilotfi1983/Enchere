package fr.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;

import fr.encheres.bll.interfaces.IUserManager;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;
import fr.encheres.dal.factory.DAOUserFactory;
import fr.encheres.dal.interfaces.IUserDao;

import javax.servlet.http.HttpSession;

public class UserManagerImp implements IUserManager {
	private  IUserDao userDao;
	private static IUserManager instance;

	public UserManagerImp() {
		this.userDao = DAOUserFactory.getUserDAO();
	}

	public static IUserManager getInstance() {
			if (instance == null) {
				return new UserManagerImp();
			}
			return instance;
	}
	@Override
	public void insertUser(User user) throws BllException {
		try {
			this.userDao.insertUser(user);
		} catch (DalException | SQLException e) {
			throw new BllException(e.getMessage(), e);
		} 
	}

	@Override
	public void suprimerUser(int id) throws DalException {
		try {
			userDao.suprimerUser(id);
		} catch (DalException e) {
			throw new DalException();
		}
	}

	@Override
	public void majUser(int idUser, User user) throws DalException {
		
		try {
			userDao.majUser(idUser, user);
		} catch (DalException e) {
			 throw new DalException();
		}

	}

	@Override
	public List<User> selectAllUsers() throws DalException {
		try {
			return userDao.selectAllUsers();
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public User selectUserId(int idUser) throws DalException {
		try {
			return userDao.selectUserId(idUser);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public User selectUserAutentification(Autentification autentification) throws BllException{
		User user;
		try {
			user = userDao.selectUserAutentification(autentification);
		} catch (SQLException | DalException e) {
			throw new BllException(e.getMessage(), e);
		}
		 return user;
	}

	@Override
	public void activeUser(User user) throws DalException {
		
		try {
			userDao.activeUser(user);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
		
	}

	@Override
	public void setCredit(int credit, int idArticle) throws DalException {
		try {
			userDao.setCredit(credit, idArticle);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

}
