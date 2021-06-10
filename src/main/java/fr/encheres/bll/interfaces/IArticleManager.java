package fr.encheres.bll.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.encheres.bll.BllException;
import fr.encheres.bo.Adresse;
import fr.encheres.bo.Article;
import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.DalException;

public interface IArticleManager {
	public void insertArticle(Article article, Adresse adresse) throws DalException, BllException;
	public  void setPicture(String extention, int idArticle) throws DalException ;
	public List<Article> selectAllArticles(int idUser,int idCategory, String mc,String dateParam) throws DalException;
	public Article selectArticleId(int idArticle) throws DalException;
}
