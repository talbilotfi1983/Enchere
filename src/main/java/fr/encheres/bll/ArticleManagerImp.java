package fr.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;

import fr.encheres.bll.interfaces.IArticleManager;
import fr.encheres.bo.Adresse;
import fr.encheres.bo.Article;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;
import fr.encheres.dal.factory.DAOArticleFactory;
import fr.encheres.dal.factory.DAOCategoryFactory;
import fr.encheres.dal.factory.DAOUserFactory;
import fr.encheres.dal.interfaces.IArticleDao;
import fr.encheres.dal.interfaces.ICategoryDao;
import fr.encheres.dal.interfaces.IUserDao;

import javax.servlet.http.HttpSession;

public class ArticleManagerImp implements IArticleManager {
	private IArticleDao articleDao;
	private static IArticleManager instance;

	public ArticleManagerImp() {
		this.articleDao = DAOArticleFactory.getArticleDAO();
	}

	public static IArticleManager getInstance() {
		if (instance == null) {
			return new ArticleManagerImp();
		}
		return instance;
	}

	@Override
	public void insertArticle(Article article, Adresse adresse) throws BllException {
		try {
			this.articleDao.insertArticle(article,adresse);
		} catch (DalException | SQLException e) {
			throw new BllException(e.getMessage(), e);
		}
	}

	@Override
	public void setPicture(String extention, int idArticle) throws DalException {

		try {
			articleDao.setPicture(extention, idArticle);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	public List<Article> selectAllArticles(int idUser, int idCategory, String mc, String venteParam)
			throws DalException {
		List<Article> articles = null;
		try {
			articles = articleDao.selectAllArticles(idUser, idCategory, mc, venteParam);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}

		return articles;
	}

	@Override
	public Article selectArticleId(int idArticle) throws DalException {
		try {
			return articleDao.selectArticleId(idArticle);
		} catch (DalException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

}
