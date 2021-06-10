package fr.encheres.dal.factory;

import fr.encheres.dal.DaoUserImp;
import fr.encheres.dal.interfaces.IUserDao;

public abstract class DAOUserFactory {
	
	public static IUserDao getUserDAO()
	{
		return new DaoUserImp();
	}
}
	