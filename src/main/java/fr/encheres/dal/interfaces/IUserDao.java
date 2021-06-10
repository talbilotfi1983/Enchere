package fr.encheres.dal.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

public interface IUserDao {
	public void insertUser(User user) throws DalException, SQLException;
	public void suprimerUser(int id) throws DalException;
	public void majUser(int idUser, User user) throws DalException;
	public List<User> selectAllUsers() throws DalException;
	public User selectUserId(int idUser) throws DalException;
	public User selectUserAutentification(Autentification autentification) throws SQLException, DalException;
	public void activeUser(User idUser) throws DalException;
	public  void setCredit(int credit, int idUser) throws DalException ;
	
}
