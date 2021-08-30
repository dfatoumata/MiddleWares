package fr.doranco.ecole.model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class EcoleDataSource {

	private EcoleDataSource() {
	}

	public static Connection getConnexion() throws Exception {
		
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/ecole_db";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connexion = DriverManager.getConnection(url, user, password);
		return connexion;
	}
}
