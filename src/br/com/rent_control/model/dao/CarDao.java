package br.com.rent_control.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Car;

/**
 * Class CarDao - Represents the dao of the car in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class CarDao {

	public boolean addCar(Car car) {
		String sql = "INSERT INTO car VALUES (?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, car.getCategory());
			preparedStatement.setInt(2, car.getMaxPassengers());
			preparedStatement.setDouble(3, car.getTrunkSize());
			preparedStatement.setString(4, car.getTransmissionType());
			preparedStatement.setString(5, car.getFuelType());
			preparedStatement.setDouble(6, car.getDailyCost());
			preparedStatement.setBoolean(7, car.isHasAc());
			preparedStatement.setBoolean(8, car.isHasAirbag());
			preparedStatement.setBoolean(9, car.isHasAbsBrakes());
			preparedStatement.setBoolean(10, car.isHasDvdPlayer());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar funcionário: " + e.getMessage());
			return false;
		}
	}
}