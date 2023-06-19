package br.com.rent_control.model.dao;

import java.sql.*;
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
			    car.setMaxPassengers(rs.getInt(Car.COLUMN_MAXPASSENGERS));
			    car.setTrunkSize(rs.getDouble(Car.COLUMN_TRUNKSIZE));
			    car.setTransmissionType(rs.getString(Car.COLUMN_TRANSMISSIONTYPE));
			    car.setFuelType(rs.getString(Car.COLUMN_FUELTYPE));
			    car.setConsumptionAverage(rs.getDouble(Car.COLUMN_CONSUMPTIONAVARAGE));
			    car.setDailyCost(rs.getDouble(Car.COLUMN_DAILY));
			    car.setHasAc(rs.getBoolean(Car.COLUMN_HASAC));
			    car.setHasAirbag(rs.getBoolean(Car.COLUMN_HASAIRBAG));
			    car.setHasAbsBrakes(rs.getBoolean(Car.COLUMN_HASABS));
			    car.setHasDvdPlayer(rs.getBoolean(Car.COLUMN_HASDVD));
			    car.setId(Integer.parseInt(rs.getString(Car.ID)));
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			System.err.println("Erro ao listar carros: " + e.getMessage());
		}
		return null;
	}
	
	public boolean deleteCarById(int id) {
		String sql = "delete from car where id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao excluir carro: " + e.getMessage());
			return false;
		}
	}
	
	public static void main(String[] args) {
		CarDao c = new CarDao();
		for (Car car : c.listCars()) {
			System.out.println(car.getCategory());
		}
	}
}