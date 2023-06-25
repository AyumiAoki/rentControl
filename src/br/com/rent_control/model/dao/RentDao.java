package br.com.rent_control.model.dao;

import java.sql.*;
import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Rent;

/**
 * Class RentDao - Represents the dao of the rent in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class RentDao {
	
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
}