package fr.encheres.bll.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bll.BllException;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

public interface IUserManager {
	public void insertUser(User user) throws DalException, BllException;
	public void suprimerUser(int id) throws DalException;
	public void majUser(int idUser, User user) throws DalException;
	public List<User> selectAllUsers() throws DalException;
	public User selectUserId(int idUser) throws DalException;
	public User selectUserAutentification(Autentification autentification ) throws BllException, SQLException, DalException;
	public void activeUser(User user) throws DalException;
	public  void setCredit(int credit, int idArticle) throws DalException ;
	
}
