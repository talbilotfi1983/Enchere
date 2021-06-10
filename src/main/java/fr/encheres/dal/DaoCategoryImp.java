package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import fr.encheres.bo.Autentification;
import fr.encheres.bo.Category;
import fr.encheres.bo.User;
import fr.encheres.dal.interfaces.ICategoryDao;

public class DaoCategoryImp implements ICategoryDao {

	@Override
	public List<Category> selectAllCategory() throws DalException {
		String query = "select idCategorie, libelle from categorie;";
		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Category category = new Category(rs.getInt("idCategorie"), rs.getString("libelle"));
				categories.add(category);
			}
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}
		return categories;
	}

	@Override
	public void deleteCategory(int idCategory) throws DalException {
		String query = "delete from categorie where idCategorie=?;";

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idCategory);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DalException(e.getMessage(), e);
		}
	}

	@Override
	public void updateCategory(int idCategory, String libelle) throws DalException {
		String query = "update categorie set libelle=? where idCategorie=?;";
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, libelle);
			preparedStatement.setInt(2, idCategory);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}

	}

	@Override
	public Category insertCategory(String libele) throws DalException, SQLException {
		String query = "" + "insert into categorie(libelle) values (?)";
		Connection connection = null;
		Category category = new Category();
		category.setLibelle(libele);
		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement;
			ResultSet resultSet;
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, libele);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				category.setIdCategory(resultSet.getInt(1));
			}

			resultSet.close();
			preparedStatement.close();
			connection.commit();

		} catch (SQLException e) {
			connection.rollback();
			throw new DalException(e.getMessage(), e);
		} finally {
			connection.close();
		}
		return category;

	}

}
