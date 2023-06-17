package br.com.rent_control.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Employee;

/**
 * Class EmployeeDao - Represents the dao of the employee in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class EmployeeDao {

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

	public List<Employee> listUsers() {
		List<Employee> employees = new ArrayList<Employee>();

		String sql = "SELECT * FROM employee";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Employee employee = new Employee();

				employee.setName(rs.getString(Employee.COLUMN_NAME));
				employee.setCpf(rs.getString(Employee.COLUMN_CPF));
				employee.setNickname(rs.getString(Employee.COLUMN_NICKNAME));
				employee.setPassword(rs.getString(Employee.COLUMN_PASS));
				employees.add(employee);
			}
			return employees;
		} catch (SQLException e) {
			System.err.println("Erro ao listar funcionários: " + e.getMessage());
		}
		return null;
	}

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