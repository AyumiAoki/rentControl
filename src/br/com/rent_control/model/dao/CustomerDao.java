package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.*;
import br.com.rent_control.model.*;
import br.com.rent_control.model.vo.Customer;

/**
 * Class CustomerDao - Represents the dao of the user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class CustomerDao extends ConnectionDB {

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

	public boolean updateCustomer(Customer customer) {
		String sql = "update customer set name = ?, cpf = ?, dateOfBirth = ? where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getCpf());
			preparedStatement.setString(3, customer.getDateOfBirth());
			preparedStatement.setString(4, customer.getCpf());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar cliente: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteCustomer(Customer customer) {
		String sql = "delete from customer where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, customer.getCpf());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao deletar cliente: " + e.getMessage());
			return false;
		}
	}

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