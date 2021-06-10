package fr.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource dataSource;
	static {
	try {
		Context context = new InitialContext();
		dataSource =  (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		System.out.println("connexion etablie");
	} catch (NamingException e) {
		e.printStackTrace();
		throw new RuntimeException("Impossible de se connecter a la base de donnees");
	}	
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
