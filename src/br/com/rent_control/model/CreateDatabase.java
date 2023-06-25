package br.com.rent_control.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * Class CreateDatabase - Used to create the database and tables application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CreateDatabase {

	private String url = "jdbc:mysql://localhost:3306/";
	private String username = "root";
	private String password = "root";
	private String databaseName = "rent_control";
	private String scriptPath = "src/br/com/rent_control/model/schema.sql";

	/**
	 * Parameterless class constructor.
	 */
	public CreateDatabase() {
	}

	/**
	 * Method that creates the database and tables.
	 */
	public void createDbTables() {
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {

			// Check if the database already exists
			ResultSet resultSet = connection.getMetaData().getCatalogs();
			boolean databaseExists = false;

			while (resultSet.next()) {
				String existingDatabase = resultSet.getString(1);

				if (existingDatabase.equalsIgnoreCase(databaseName)) {
					databaseExists = true;
					break;
				}
			}

			resultSet.close();

			// Create the database if it doesn't exist
			if (!databaseExists) {
				String createDatabaseQuery = "CREATE DATABASE " + databaseName;
				statement.executeUpdate(createDatabaseQuery);

				System.out.println("Banco de dados criado com sucesso.");

				try {
					// Run the SQL script to create the tables
					BufferedReader reader = new BufferedReader(new FileReader(scriptPath));
					String line;
					StringBuilder script = new StringBuilder();

					while ((line = reader.readLine()) != null) {
						script.append(line);
						if (line.endsWith(";")) {
							statement.execute(script.toString());
							script.setLength(0);
						}
					}
					reader.close();
					System.out.println("Tabelas criadas com sucesso.");
				} catch (Exception e) {
					System.err.println("Erro ao criar tabelas: " + e.getMessage());
				}
			}
		} catch (Exception e) {
			System.err.println("Erro ao criar o banco de dados: " + e.getMessage());
		}
	}
}