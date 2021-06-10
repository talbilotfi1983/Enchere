package fr.encheres.dal.factory;

import fr.encheres.dal.DaoArticleImp;
import fr.encheres.dal.interfaces.IArticleDao;

public abstract class DAOArticleFactory {
	
	public static IArticleDao getArticleDAO()
	{
		return new DaoArticleImp();
	}
}
	