package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.*;
import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.Car;

/**
 * Class CarDao - Represents the dao of the Car in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CarDao {

	/**
	 * Method that adds cars to the table in the database.
	 * 
	 * @param Car The car to be added.
	 * @return boolean containing true or false if insertion is successful
	 */
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

	/**
	 * Method that returns a list of all cars registered in the database.
	 * 
	 * @return car list.
	 */
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

	/**
	 * Method that returns a list of all cars that are not in the 'rent' table.
	 *
	 * @return List of cars not in 'rent' table.
	 */
	public List<Car> listAvailableCars() {
		List<Car> cars = new ArrayList<>();

		String sql = "SELECT * FROM car WHERE NOT EXISTS (SELECT 1 FROM rent WHERE rent.idCar = car.id)";

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
				car.setId(rs.getInt(Car.ID));
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			System.err.println("Erro ao listar carros disponíveis: " + e.getMessage());
		}
		return null;
	}

	/**
	 * Method that searches for a car by id.
	 * 
	 * @param id The id of the car to be fetched.
	 * @return the car
	 */
	public Car getCarById(String id) {
		String sql = "SELECT * FROM car WHERE id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, id);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
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

					return car;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o carro: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Method that searches for a car model by ID.
	 *
	 * @param id The ID of the car to be fetched.
	 * @return The model of the car, or null if not found.
	 */
	public String getModelById(int id) {
		String sql = "SELECT MODEL FROM car WHERE id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, id);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					Car car = new Car();
					car.setModelCar(rs.getString(Car.COLUMN_MODEL));
					return car.getModelCar();
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o carro: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Method that updates a car in the database table.
	 * 
	 * @param Car The car to be upgraded.
	 * @return boolean true or false if the update was successful.
	 */
	public boolean updateCar(Car Car) {
		String sql = "update car set category = ?, model = ?, maxPassengers = ?, trunkSize = ?, transmissionType = ?, fuelType = ?, consumptionAverage = ?, dailyCost = ?, hasAc = ?, hasAirbag = ?, hasAbsBrakes = ?, hasDvdPlayer = ? where id = ?";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			System.out.println("Car.getModelCar()" + Car.getModelCar());
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
			preparedStatement.setInt(13, Car.getId());

			preparedStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar carro: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method that deletes a car by id.
	 * 
	 * @param id The id of the car to be deleted.
	 * @return boolean containing true or false if the car was successfully deleted.
	 */
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
}