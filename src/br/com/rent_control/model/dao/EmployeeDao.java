package br.com.rent_control.model.dao;

import java.sql.*;
import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Employee;

/**
 * Class EmployeeDao - Represents the dao of the employee in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class EmployeeDao {

	/**
	 * Method that adds a employee to a table in the database.
	 * 
	 * @param employee The employee to be added.
	 * @return boolean containing true or false if insertion is successful
	 */
	public boolean addEmployee(Employee employee) {
		String sql = "INSERT INTO employee VALUES (?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getCpf());
			preparedStatement.setString(3, employee.getNickname());
			preparedStatement.setString(4, employee.getPassword());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar funcionário: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method that searches for a employee by nickname.
	 * 
	 * @param nickname The nickname of the employee to be searched for.
	 * @return the employee
	 */
	public Employee getEmployeeByNickname(String nickname) {
		String sql = "SELECT * FROM employee WHERE nickname = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, nickname);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setNickname(rs.getString(Employee.COLUMN_NICKNAME));
					employee.setPassword(rs.getString(Employee.COLUMN_PASS));
					return employee;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar funcionário: " + e.getMessage());
		}

		return null;
	}
}