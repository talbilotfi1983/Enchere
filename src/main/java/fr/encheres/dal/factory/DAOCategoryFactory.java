package fr.encheres.dal.factory;

import fr.encheres.dal.DaoCategoryImp;
import fr.encheres.dal.interfaces.ICategoryDao;

public abstract class DAOCategoryFactory {
	
	public static ICategoryDao getCategoryDAO()
	{
		return new DaoCategoryImp();
	}
}
	