package fr.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bll.interfaces.ICategoryManager;
import fr.encheres.bo.Category;
import fr.encheres.dal.DalException;
import fr.encheres.dal.factory.DAOCategoryFactory;
import fr.encheres.dal.interfaces.ICategoryDao;

public class CategoryManagerImp implements ICategoryManager {
	private ICategoryDao categoryDao;
	private static ICategoryManager instance;

	public CategoryManagerImp() {
		this.categoryDao = DAOCategoryFactory.getCategoryDAO();
	}

	public static ICategoryManager getInstance() {
		if (instance == null) {
			return new CategoryManagerImp();
		}
		return instance;
	}

	@Override
	public List<Category> selectAllCategory() throws DalException {
		try {
			return categoryDao.selectAllCategory();
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public void deleteCategory(int idCategory) throws DalException  {
		try {
			categoryDao.deleteCategory(idCategory);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public void updateCategory(int idCategory, String libelle) throws DalException  {
		try {
			categoryDao.updateCategory(idCategory, libelle);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public Category insertCategory(String libelle) throws BllException {
		Category category = null;
		try {
			category =  this.categoryDao.insertCategory(libelle);
		} catch (DalException | SQLException e) {
			throw new BllException(e.getMessage(), e);
		}
		return category; 		
	}

}
