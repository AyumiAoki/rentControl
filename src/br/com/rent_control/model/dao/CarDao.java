package br.com.rent_control.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Car;

/**
 * Class CarDao - Represents the dao of the Car in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class CarDao {

	public boolean addCar(Car Car) {
		String sql = "INSERT INTO car (category, model, maxPassengers, trunkSize, transmissionType, fuelType, consumptionAverage, dailyCost, hasAc, hasAirbag, hasAbsBrakes, hasDvdPlayer) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, Car.getCategory());
			preparedStatement.setString(2, Car.getModelCar());
			preparedStatement.setInt(3, Car.getMaxPassengers());
			preparedStatement.setDouble(4, Car.getTrunkSize());
			preparedStatement.setString(5, Car.getTransmissionType());
			preparedStatement.setString(6, Car.getFuelType());
			preparedStatement.setDouble(7, Car.getConsumptionAverage());
			preparedStatement.setDouble(8, Car.getDailyCost());
			preparedStatement.setBoolean(9, Car.isHasAc());
			preparedStatement.setBoolean(10, Car.isHasAirbag());
			preparedStatement.setBoolean(11, Car.isHasAbsBrakes());
			preparedStatement.setBoolean(12, Car.isHasDvdPlayer());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar funcionário: " + e.getMessage());
			return false;
		}
	}
	
	public List<Car> listCars() {
		List<Car> cars = new ArrayList<Car>();
		
		String sql = "SELECT * FROM car";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Car car = new Car();

				car.setCategory(rs.getString(Car.COLUMN_CATEGORY));
			    car.setModelCar(rs.getString(Car.COLUMN_MODEL));
			    car.setMaxPassengers(Integer.parseInt(rs.getString(Car.COLUMN_MAXPASSENGERS)));
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			System.err.println("Erro ao listar carros: " + e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		CarDao c = new CarDao();
		for (Car car : c.listCars()) {
			System.out.println(car.getCategory());
		}
	}
}