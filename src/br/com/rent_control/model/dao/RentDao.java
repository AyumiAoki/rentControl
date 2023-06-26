package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.model.vo.Rent;

/**
 * Class RentDao - Represents the dao of the rent in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentDao {

	/**
	 * Method that adds a location to a table in the database.
	 * 
	 * @param rent The lease to be added
	 * @return boolean containing true or false if insertion is successful
	 */
	public boolean rentVehicle(Rent rent) {
		String sql = "INSERT INTO rent (withdrawalDate, pickUpLocation, deliveryDate, returnLocation, carProtection, gps, cleaning, drinkComfort, babyChair, boosterSeat, cpfCustomer, idCar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, rent.getWithdrawalDate());
			preparedStatement.setString(2, rent.getPickUpLocation());
			preparedStatement.setString(3, rent.getDeliveryDate());
			preparedStatement.setString(4, rent.getDeliveryLocation());
			preparedStatement.setBoolean(5, rent.isCarProtection());
			preparedStatement.setBoolean(6, rent.isGps());
			preparedStatement.setBoolean(7, rent.isCleaning());
			preparedStatement.setBoolean(8, rent.isDrinkComfort());
			preparedStatement.setBoolean(9, rent.isBabyChair());
			preparedStatement.setBoolean(10, rent.isBoosterSeat());
			preparedStatement.setString(11, rent.getCpfCustomer());
			preparedStatement.setInt(12, rent.getIdCar());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao alocar veículo: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * Method that returns a list of all customers registered in the database.
	 * 
	 * @return customer list.
	 */
	public List<Rent> listRents() {
		List<Rent> rents = new ArrayList<Rent>();

		String sql = "select * from rent";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Rent rent = new Rent();

				rent.setCpfCustomer(rs.getString(Rent.COLUMN_CPFCUSTOMER));
				rent.setIdCar(Integer.parseInt(rs.getString(Rent.COLUMN_IDCAR)));
				rent.setDeliveryDate(rs.getString(Rent.COLUMN_RETURNDATE));
				rent.setIdRent(Integer.parseInt(rs.getString(Rent.COLUMN_IDRENT)));
				rents.add(rent);
			}
			return rents;
		} catch (SQLException e) {
			System.err.println("Erro ao listar locações: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Method that searches for a rent by id.
	 * 
	 * @param id The id of the rent to be fetched.
	 * @return the rent
	 */
	public Rent getRentById(String id) {
		String sql = "SELECT * FROM rent WHERE id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, id);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					Rent rent = new Rent();
					rent.setIdRent(rs.getInt(Rent.COLUMN_IDRENT));
					rent.setWithdrawalDate(rs.getString(Rent.COLUMN_WITHDRAWALDATE));
					rent.setPickUpLocation(rs.getString(Rent.COLUMN_PICKUPLOCATION));
					rent.setDeliveryDate(rs.getString(Rent.COLUMN_RETURNDATE));
					rent.setDeliveryLocation(rs.getString(Rent.COLUMN_RETURNLOCATION));
					rent.setCarProtection(rs.getBoolean(Rent.COLUMN_CARPROTECTION));
					rent.setGps(rs.getBoolean(Rent.COLUMN_GPS));
					rent.setCleaning(rs.getBoolean(Rent.COLUMN_CLEANING));
					rent.setDrinkComfort(rs.getBoolean(Rent.COLUMN_DRINKCOMFORT));
					rent.setBabyChair(rs.getBoolean(Rent.COLUMN_BABYCHAIR));
					rent.setBoosterSeat(rs.getBoolean(Rent.COLUMN_BOOSTERSEAT));
					rent.setCpfCustomer(rs.getString(Rent.COLUMN_CPFCUSTOMER));
					rent.setIdCar(rs.getInt(Rent.COLUMN_IDCAR));

					return rent;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar locação: " + e.getMessage());
		}

		return null;
	}
	
	/**
	 * Method that searches for a car id by ID.
	 *
	 * @param id The ID of the rent to be fetched.
	 * @return int The id of the car, or 0 if not found.
	 */
	public int getIdCarById(String id) {
		String sql = "SELECT idCar FROM rent WHERE id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, id);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					Car car = new Car();
					car.setId(rs.getInt(Rent.COLUMN_IDCAR));
					return car.getId();
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o carro: " + e.getMessage());
		}

		return 0;
	}
	
	/**
	 * Verifies if a car ID is present in the 'rent' table.
	 *
	 * @param carId The ID of the car to be checked.
	 * @return True if the car ID is present in the 'rent' table, false otherwise.
	 */
	public boolean isCarIdInRent(int carId) {
	    String sql = "SELECT 1 FROM rent WHERE idCar = ?";

	    try (Connection connection = ConnectionDB.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setInt(1, carId);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            return rs.next(); 
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao verificar se o ID do carro está na tabela rent: " + e.getMessage());
	        return false;
	    }
	}
	
	/**
	 * Verifies if a CPF is present in the 'rent' table.
	 *
	 * @param cpf The CPF to be checked.
	 * @return True if the CPF is present in the 'rent' table, false otherwise.
	 */
	public boolean isCpfInRent(String cpf) {
	    String sql = "SELECT 1 FROM rent WHERE cpfCustomer = ?";

	    try (Connection connection = ConnectionDB.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, cpf);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            return rs.next(); // Returns true if the CPF is present in the 'rent' table
	        }
	    } catch (SQLException e) {
	        System.err.println("Error while checking if CPF is in 'rent' table: " + e.getMessage());
	        return false;
	    }
	}

	/**
	 * Method that updates a rent in the database table.
	 * 
	 * @param rent The rent to be upgraded.
	 * @return boolean true or false if the update was successful.
	 */
	public boolean updateRent(Rent rent) {
		String sql = "UPDATE rent SET withdrawalDate = ?, pickUpLocation = ?, deliveryDate = ?, returnLocation = ?, carProtection = ?, gps = ?, cleaning = ?, drinkComfort = ?, babyChair = ?, boosterSeat = ?, cpfCustomer = ?, idCar = ? where id = ?";
	
		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, rent.getWithdrawalDate());
			preparedStatement.setString(2, rent.getPickUpLocation());
			preparedStatement.setString(3, rent.getDeliveryDate());
			preparedStatement.setString(4, rent.getDeliveryLocation());
			preparedStatement.setBoolean(5, rent.isCarProtection());
			preparedStatement.setBoolean(6, rent.isGps());
			preparedStatement.setBoolean(7, rent.isCleaning());
			preparedStatement.setBoolean(8, rent.isDrinkComfort());
			preparedStatement.setBoolean(9, rent.isBabyChair());
			preparedStatement.setBoolean(10, rent.isBoosterSeat());
			preparedStatement.setString(11, rent.getCpfCustomer());
			preparedStatement.setInt(12, rent.getIdCar());
			preparedStatement.setInt(13, rent.getIdRent());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar locação: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method that deletes a rent by id.
	 * 
	 * @param id The id of the rent to be deleted.
	 * @return boolean containing true or false if the car was successfully deleted.
	 */
	public boolean deleteRentById(int id) {
		String sql = "delete from rent where id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao deletar locação: " + e.getMessage());
			return false;
		}
	}
}