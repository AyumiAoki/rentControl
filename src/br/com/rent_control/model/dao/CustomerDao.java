package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.*;
import br.com.rent_control.model.*;
import br.com.rent_control.model.vo.Customer;

/**
 * Class CustomerDao - Represents the dao of the user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CustomerDao extends ConnectionDB {

	/**
	 * Method that adds a customer to a table in the database.
	 * 
	 * @param customer The customer to be added.
	 * @return boolean containing true or false if insertion is successful
	 */
	public boolean addCustomer(Customer customer) {
		String sql = "insert into customer VALUES (?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getCpf());
			preparedStatement.setLong(3, customer.getLicenseNumber());
			preparedStatement.setString(4, customer.getDateOfBirth());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar cliente: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method that returns a list of all customers registered in the database.
	 * 
	 * @return customer list.
	 */
	public List<Customer> listCustomer() {
		List<Customer> customers = new ArrayList<Customer>();

		String sql = "select * from customer";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setCpf(rs.getString(Customer.COLUMN_CPF));
				customer.setName(rs.getString(Customer.COLUMN_NAME));
				customer.setLicenseNumber(Integer.parseInt(rs.getString(Customer.COLUMN_LICENSENUMBER)));
				customer.setDateOfBirth(rs.getString(Customer.COLUMN_DDN));
				customers.add(customer);
			}
			return customers;
		} catch (SQLException e) {
			System.err.println("Erro ao listar clientes: " + e.getMessage());
		}
		return null;
	}

	/**
	 * Method that searches for a customer by cpf.
	 * 
	 * @param cpf The CPF of the customer to be searched for.
	 * @return the customer
	 */
	public Customer getCustomerByCpf(String cpf) {
		String sql = "SELECT * FROM customer WHERE cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, cpf);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					Customer customer = new Customer();
					customer.setCpf(rs.getString(Customer.COLUMN_CPF));
					customer.setName(rs.getString(Customer.COLUMN_NAME));
					customer.setDateOfBirth(rs.getString(Customer.COLUMN_DDN));
					customer.setLicenseNumber(Integer.parseInt(rs.getString(Customer.COLUMN_LICENSENUMBER)));

					return customer;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o cliente: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Method that searches for a customer's name by CPF.
	 *
	 * @param cpf The CPF of the customer to be searched for.
	 * @return The name of the customer, or null if not found.
	 */
	public String getNameCustomerByCpf(String cpf) {
		String sql = "SELECT NAME FROM customer WHERE cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, cpf);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					return rs.getString("NAME");
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o cliente: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Method that updates a customer in the database table.
	 * 
	 * @param customer The customer to be upgraded.
	 * @return boolean true or false if the update was successful.
	 */
	public boolean updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET name = ?, cpf = ?, licenseNumber = ?, dateOfBirth = ? where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getCpf());
			preparedStatement.setLong(3, customer.getLicenseNumber());
			preparedStatement.setString(4, customer.getDateOfBirth());
			preparedStatement.setString(5, customer.getCpf());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar cliente: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method that deletes a customer by CPF.
	 * 
	 * @param cpf The CPF of the customer to be deleted.
	 * @return boolean containing true or false if the car was successfully deleted.
	 */
	public boolean deleteCustomerByCpf(String cpf) {
		String sql = "delete from customer where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, cpf);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao deletar cliente: " + e.getMessage());
			return false;
		}
	}
}