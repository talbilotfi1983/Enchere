package fr.encheres.dal.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bo.Category;
import fr.encheres.dal.DalException;

public interface ICategoryDao {
	public List<Category> selectAllCategory() throws DalException;
	public void deleteCategory(int idCategory) throws DalException;
	public void updateCategory(int idCategory, String libelle) throws DalException;
	public Category insertCategory(String libelle) throws DalException, SQLException;

}
