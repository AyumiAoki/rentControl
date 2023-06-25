package br.com.rent_control.model;

import java.sql.*;

/**
 * Class ConnectionDB - Represents the connection to the database in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class ConnectionDB {

	private static String url = "jdbc:mysql://localhost:3306/rent_control";
	private static String user = "root";
	private static String pass = "root";
	protected static Connection conexao = null;

	/**
	 * Parameterless class constructor.
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("Falha ao conectar ao banco de dados: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Method to close database connection
	 * 
	 * @param conexao
	 */
	public static void closeConnection(Connection conexao) {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
		}
	}
}