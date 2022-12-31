package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexao {
	
	public Connection getConnetion() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/projetojava?useTimezone=true&serverTimezone=UTC",
					"root", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}


