package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.*;
import br.com.rent_control.model.*;
import br.com.rent_control.model.vo.User;

/**
 * Class UserDao - Represents the dao of the user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class UserDao extends ConnectionDB {    

	public boolean addUser(User user) {
		String sql = "insert into user VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getNationality());
			preparedStatement.setString(3, user.getCpf());
			preparedStatement.setLong(4, user.getLicenseNumber());
			preparedStatement.setInt(5, user.getIDNumber());
			preparedStatement.setString(6, user.getDateOfBirth());
			preparedStatement.setInt(7, user.getCEP());
			preparedStatement.setInt(8, user.getNumberHouse());
			preparedStatement.setString(9, user.getNeighborhood());
			preparedStatement.setString(10, user.getRoad());
			preparedStatement.setString(11, user.getCity());
			preparedStatement.setString(12, user.getState());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar usuário: " + e.getMessage());
			return false;
		}
	}

	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		
		String sql = "select * from user";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				User user = new User();

				user.setName(rs.getString(User.COLUMN_NAME));
			    user.setCpf(rs.getString(User.COLUMN_CPF));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			System.err.println("Erro ao listar usuários: " + e.getMessage());
		}
		return null;
	}
	
	public boolean updateUser(User user, String cpf) {
		String sql = "update user set name = ?, nationality = ?, cpf = ?, licenseNumber = ?, idNumber = ?, dateOfBirth = ?, cep = ?, numberHouse = ?, neighborhood = ?, road = ?, city = ?, state = ? where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getNationality());
			preparedStatement.setString(3, user.getCpf());
			preparedStatement.setLong(4, user.getLicenseNumber());
			preparedStatement.setInt(5, user.getIDNumber());
			preparedStatement.setString(6, user.getDateOfBirth());
			preparedStatement.setInt(7, user.getCEP());
			preparedStatement.setInt(8, user.getNumberHouse());
			preparedStatement.setString(9, user.getNeighborhood());
			preparedStatement.setString(10, user.getRoad());
			preparedStatement.setString(11, user.getCity());
			preparedStatement.setString(12, user.getState());
			preparedStatement.setString(13, cpf);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar usuário: " + e.getMessage());
			return false;
		}
	}
	
	public boolean deleteUser(User user) {
		String sql = "delete from user where cpf = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getCpf());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar usuário: " + e.getMessage());
			return false;
		}
	}
}