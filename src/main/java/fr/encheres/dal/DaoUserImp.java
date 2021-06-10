package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import fr.encheres.bo.Autentification;
import fr.encheres.bo.User;
import fr.encheres.dal.interfaces.IUserDao;

public class DaoUserImp implements IUserDao {

	@Override
	public void insertUser(User user) throws DalException, SQLException {
		String query = "insert into USERS(pseudo,nom,prenom,email,telephone,numero,adresse,codePostal,ville,motDePasse,credit,administrateur,civilite,active)values(?,?,?,?,?,?,?,?,?,?,?,?,?,0);";
		Connection connection = null;
		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement;
			ResultSet resultSet;
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getPseudo());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setString(3, user.getPrenom());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getTelephone());
			preparedStatement.setString(6, user.getNumero());
			preparedStatement.setString(7, user.getAdresse());
			preparedStatement.setString(8, user.getCodePostal());
			preparedStatement.setString(9, user.getVille());
			preparedStatement.setString(10, user.getMotDePasse());
			preparedStatement.setInt(11, user.getCredit());
			preparedStatement.setBoolean(12, user.isAdmin());
			preparedStatement.setString(13, user.getCivilite());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				user.setIdUser(resultSet.getInt(1));
			}

			resultSet.close();
			preparedStatement.close();
			connection.commit();

		} catch (SQLException e) {
			connection.rollback();
			throw new DalException(e.getMessage(), e);
		}finally {
			connection.close();
		}

	}

	@Override
	public void suprimerUser(int idUser) throws DalException {
		String query = "delete from USERS where idUser=?";
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idUser);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DalException(e.getMessage(), e);
		}

	}

	@Override
	public void majUser(int idUser, User user) throws DalException {
		String query = "update USERS set pseudo=?,nom=?,prenom=?,email=?,telephone=?,adresse=?,codePostal=?,ville=?,motDePasse=?,credit=?,administrateur=?,civilite=?,numero=? where idUser=?";
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getPseudo());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setString(3, user.getPrenom());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getTelephone());
			preparedStatement.setString(6, user.getAdresse());
			preparedStatement.setString(7, user.getCodePostal());
			preparedStatement.setString(8, user.getVille());
			preparedStatement.setString(9, user.getMotDePasse());
			preparedStatement.setInt(10, user.getCredit());
			preparedStatement.setBoolean(11, user.isAdmin());
			preparedStatement.setString(12, user.getCivilite());
			preparedStatement.setString(13, user.getNumero());
			preparedStatement.setInt(14, idUser);
			preparedStatement.executeUpdate();

			preparedStatement.close();

		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}

	}

	@Override
	public List<User> selectAllUsers() throws DalException {
		String query = "select idUser,pseudo,nom,prenom,email,telephone,adresse,codePostal,ville,motDePasse,credit,administrateur,civilite,numero,active from users";
		List<User> users = new ArrayList<User>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt("idUser"),rs.getString("civilite"),rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),rs.getString("numero"),rs.getString("adresse"),
						rs.getString("codePostal"), rs.getString("ville"), rs.getString("motDePasse"),
						rs.getInt("credit"), rs.getBoolean("administrateur"),rs.getBoolean("active"));
				users.add(user);
			}
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}
		return users;
	}

	@Override
	public User selectUserId(int idUser) throws DalException {
		String query = "select idUser,pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur,civilite,numero from users where idUser=?";
		User user = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idUser);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("idUser"),rs.getString("civilite"),rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),rs.getString("numero"),rs.getString("adresse"),
						rs.getString("codePostal"), rs.getString("ville"), rs.getString("motDePasse"),
						rs.getInt("credit"), rs.getBoolean("administrateur"),rs.getBoolean("active"));

			}
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DalException(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public User selectUserAutentification(Autentification autentification) throws DalException {
		final String query = "select idUser,pseudo,nom,prenom,email,telephone,adresse,codePostal,ville,motDePasse,credit,administrateur,civilite,numero,active from users where pseudo=? and motDePasse=? ";
		User user = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, autentification.getPseudo());
			preparedStatement.setString(2, autentification.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("idUser"),rs.getString("civilite"),rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),rs.getString("numero"),rs.getString("adresse"),
						rs.getString("codePostal"), rs.getString("ville"), rs.getString("motDePasse"),
						rs.getInt("credit"), rs.getBoolean("administrateur"),rs.getBoolean("active"));

			}preparedStatement.close();
		} catch (SQLException e) {
			throw new DalException(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public void activeUser(User user) throws DalException {
		final String query = "update users set active=? where idUser=?";

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setBoolean(1, !user.isActive());
			preparedStatement.setInt(2, user.getIdUser());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}
	}
	@Override
	public void setCredit(int credit, int idUser) throws DalException {
		final String query = "update users set credit=? where idUser=?";

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, credit);
			preparedStatement.setInt(2, idUser);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			throw new DalException(e.getMessage(), e);
		}
		
	}
}
