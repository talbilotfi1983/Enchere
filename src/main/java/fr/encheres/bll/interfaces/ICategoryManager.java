package fr.encheres.bll.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bll.BllException;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.Category;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

public interface ICategoryManager {
		public List<Category> selectAllCategory() throws DalException;
		public void deleteCategory(int idCategory) throws DalException;
		public void updateCategory(int idCategory, String libelle) throws DalException;
		public Category insertCategory(String libelle) throws BllException;

}
