package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import fr.encheres.bo.Adresse;
import fr.encheres.bo.Article;
import fr.encheres.bo.User;
import fr.encheres.dal.interfaces.IArticleDao;

public class DaoArticleImp implements IArticleDao {

	@Override
	public void insertArticle(Article article, Adresse adresse) throws DalException, SQLException {
		String query = "insert into article_vendu(nom_article,description,"
				+ "date_debut_encheres,date_fin_encheres,mise_a_prix,idCategorie,idVendeur,etat_vente) values (?,?,?,?,?,?,?,?)";
		Connection connection = null;
		String query2 = "insert into RETRAIT(adresse,codePostal,ville,idArticle) values (?,?,?,?)";

		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement;
			ResultSet resultSet;
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, article.getNomArticle());
			preparedStatement.setString(2, article.getDescription());
			preparedStatement.setObject(3, article.getDebuEnchere());
			preparedStatement.setObject(4, article.getFinEnchere());
			preparedStatement.setInt(5, article.getMise_a_prix());
			preparedStatement.setInt(6, article.getIdCategorie());
			preparedStatement.setInt(7, article.getIdVendeur());
			preparedStatement.setBoolean(8, false);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				article.setIdArticle(resultSet.getInt(1));
			}

			preparedStatement = connection.prepareStatement(query2, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, adresse.getAdresse());
			preparedStatement.setString(2, adresse.getCodePostal());
			preparedStatement.setString(3, adresse.getVille());
			preparedStatement.setInt(4, article.getIdArticle());
			preparedStatement.executeUpdate();

			resultSet.close();
			preparedStatement.close();
			connection.commit();

		} catch (SQLException e) {
			connection.rollback();
			throw new DalException(e.getMessage(), e);
		} finally {
			connection.close();
		}

	}

	@Override
	public void setPicture(String extention, int idArticle) throws DalException {
		final String query = "update article_vendu set image=? where idArticle=?";

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, idArticle + extention);
			preparedStatement.setInt(2, idArticle);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}

	}

	@Override
	public List<Article> selectAllArticles(int idUser, int idCategory, String mc, String venteParam)
			throws DalException {
		StringBuilder query = new StringBuilder(
				"select idArticle, nom_article,description,date_fin_encheres,prix_vente,idCategorie,u.pseudo,image from article_vendu, users u where u.idUser = idVendeur");
		if (idCategory != 0)
			query.append(" and idCategorie = ?");
		if (idUser != 0)
			query.append(" and idVendeur = ?");
		if (mc != null)
			query.append(" and nom_article like ?");
		if (venteParam != null) {
			if (venteParam.equals("nondebutes"))
				query.append(" and getDate()< date_debut_encheres");
			else if (venteParam.equals("encours"))
				query.append(" and getDate()> date_debut_encheres and getDate()<= date_fin_encheres");
			else if (venteParam.equals("termines"))
				query.append(" and getDate()> date_fin_encheres");
		}

		List<Article> articles = new ArrayList<Article>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

			if (idCategory != 0) {
				preparedStatement.setInt(1, idCategory);
				if (mc != null && mc!=" ") {
					preparedStatement.setString(2, '%' + mc + '%');
					if (idUser != 0)
						preparedStatement.setInt(3, idUser);
				}
				if (idUser != 0)
					preparedStatement.setInt(2, idUser);

			} else {
				if (mc != null && mc!=" ") {
					preparedStatement.setString(1, '%' + mc + '%');
					if (idUser != 0)
						preparedStatement.setInt(2, idUser);
				} else {
					if (idUser != 0)
						preparedStatement.setInt(1, idUser);

				}
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				Article article = new Article();
				article.setNomArticle(rs.getString("nom_article")); 
				article.setDescription(rs.getString("description"));
				article.setFinEnchere((Timestamp) rs.getObject("date_fin_encheres"));
				article.setPrix_de_vente(rs.getInt("prix_vente"));
				article.setIdCategorie(rs.getInt("idCategorie")); 
				article.setPseudo(rs.getString("pseudo")); 
				article.setImage(rs.getString("image"));
				article.setIdArticle(rs.getInt("idArticle"));

				articles.add(article);
			}
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}
		return articles;
	}

	@Override
	public Article selectArticleId(int idArticle) throws DalException {
		String query = "select idArticle, nom_article,description,date_fin_encheres,prix_vente,idCategorie,u.pseudo,image from article_vendu, users u where u.idUser = idVendeur and idArticle=?";
		Article article = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idArticle);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				article = new Article(rs.getString("nom_article"), rs.getString("description"),
						(Timestamp) rs.getObject("date_fin_encheres"), rs.getInt("prix_vente"),
						rs.getInt("idCategorie"), rs.getString("pseudo"), rs.getString("image"));
				article.setIdArticle(rs.getInt("idArticle"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DalException(e.getMessage(), e);
		}
		return article;
	}

}
