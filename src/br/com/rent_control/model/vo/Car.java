package br.com.rent_control.model.vo;

/**
 * Class Car - Represents a car in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class Car {

	private int id;
	private String category;
	private String modelCar;
	private int maxPassengers;
	private double trunkSize;
	private String transmissionType;
	private String fuelType;
	private double consumptionAverage;
	private double dailyCost;
	private boolean hasAc;
	private boolean hasAirbag;
	private boolean hasAbsBrakes;
	private boolean hasDvdPlayer;

	// Constants with column names
	public static final String COLUMN_CATEGORY = "category";
	public static final String COLUMN_MODEL = "model";
	public static final String COLUMN_MAXPASSENGERS = "maxPassengers";
	public static final String COLUMN_TRUNKSIZE = "trunkSize";
	public static final String COLUMN_TRANSMISSIONTYPE = "transmissionType";
	public static final String COLUMN_FUELTYPE = "fuelType";
	public static final String COLUMN_CONSUMPTIONAVARAGE = "consumptionAverage";
	public static final String COLUMN_DAILY = "dailyCost";
	public static final String COLUMN_HASAC = "hasAc";
	public static final String COLUMN_HASAIRBAG = "hasAirbag";
	public static final String COLUMN_HASABS = "hasAbsBrakes";
	public static final String COLUMN_HASDVD = "hasDvdPlayer";
	public static final String ID = "id";

	/**
	 * Parameterless class constructor.
	 */
	public Car() {
	}

	/**
	 * Class constructor with parameters.
	 * 
	 * @param category
	 * @param maxPassengers
	 * @param trunkSize
	 * @param transmissionType
	 * @param fuelType
	 * @param hasAc
	 * @param hasAirbag
	 * @param hasAbsBrakes
	 * @param hasDvdPlayer
	 * @param dailyCost
	 */
	public Car(String category, String modelCar, int maxPassengers, double trunkSize, String transmissionType,
			String fuelType, double consumptionAverage, double dailyCost, boolean hasAc, boolean hasAirbag,
			boolean hasAbsBrakes, boolean hasDvdPlayer) {
		this.category = category;
		this.modelCar = modelCar;
		this.maxPassengers = maxPassengers;
		this.trunkSize = trunkSize;
		this.transmissionType = transmissionType;
		this.fuelType = fuelType;
		this.consumptionAverage = consumptionAverage;
		this.dailyCost = dailyCost;
		this.hasAc = hasAc;
		this.hasAirbag = hasAirbag;
		this.hasAbsBrakes = hasAbsBrakes;
		this.hasDvdPlayer = hasDvdPlayer;
	}

	/**
	 * Returns the vehicle category.
	 * 
	 * @return String containing the vehicle category.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Defines the vehicle category.
	 * 
	 * @param category The vehicle category to set.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns the vehicle model.
	 * 
	 * @return String containing the vehicle model.
	 */
	public String getModelCar() {
		return modelCar;
	}

	/**
	 * Defines the vehicle model.
	 * 
	 * @param modelCar The vehicle model to set.
	 */
	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	/**
	 * Returns the maximum number of passengers.
	 * 
	 * @return int containing the maximum number of passengers.
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}

	/**
	 * Defines the maximum number of passengers.
	 * 
	 * @param maxPassengers The maximum number of passengers to set.
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	/**
	 * Returns the size the trunk.
	 * 
	 * @return double containing the size trunk.
	 */
	public double getTrunkSize() {
		return trunkSize;
	}

	/**
	 * Defines the size trunk.
	 * 
	 * @param trunkSize The size trunk to set.
	 */
	public void setTrunkSize(double trunkSize) {
		this.trunkSize = trunkSize;
	}

	/**
	 * Returns the transmission type (manual or automatic).
	 * 
	 * @return char containing the transmission type (m or a).
	 */
	public String getTransmissionType() {
		return transmissionType;
	}

	/**
	 * Defines the transmission type.
	 * 
	 * @param transmissionType The transmission type to set.
	 */
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	/**
	 * Returns the fuel type (diesel, gasoline, ethanol or flex).
	 * 
	 * @return string containing the fuel type (diesel, gasoline, ethanol or flex).
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * Defines the fuel type.
	 * 
	 * @param fuelType The fuel type to set.
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * Returns the vehicle's average consumption km/L.
	 * 
	 * @return double containing the average consumption.
	 */
	public double getConsumptionAverage() {
		return consumptionAverage;
	}

	/**
	 * Defines the average consumption of the vehicle.
	 * 
	 * @param consumptionAverage The consumption average to be defined.
	 */
	public void setConsumptionAverage(double consumptionAverage) {
		this.consumptionAverage = consumptionAverage;
	}

	/**
	 * Returns the daily Cost.
	 * 
	 * @return double containing the daily Cost.
	 */
	public double getDailyCost() {
		return dailyCost;
	}

	/**
	 * Defines the daily Cost.
	 * 
	 * @param dailyCost The daily Cost to set.
	 */
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}

	/**
	 * Check if the vehicle has a air conditioning.
	 * 
	 * @return true if the vehicle has a air conditioning, false otherwise.
	 */
	public boolean isHasAc() {
		return hasAc;
	}

	/**
	 * Defines whether the vehicle has a air conditioning.
	 * 
	 * @param hasDvdPlayer true if the vehicle has a air conditioning, false
	 *                     otherwise.
	 */
	public void setHasAc(boolean hasAc) {
		this.hasAc = hasAc;
	}

	/**
	 * Check if the vehicle has a airbag.
	 * 
	 * @return true if the vehicle has a airbag, false otherwise.
	 */
	public boolean isHasAirbag() {
		return hasAirbag;
	}

	/**
	 * Defines whether the vehicle has a airbag.
	 * 
	 * @param hasDvdPlayer true if the vehicle has a airbag, false otherwise.
	 */
	public void setHasAirbag(boolean hasAirbag) {
		this.hasAirbag = hasAirbag;
	}

	/**
	 * Check if the vehicle has a abs brakes.
	 * 
	 * @return true if the vehicle has a abs brakes, false otherwise.
	 */
	public boolean isHasAbsBrakes() {
		return hasAbsBrakes;
	}

	/**
	 * Defines whether the vehicle has a abs brakes.
	 * 
	 * @param hasDvdPlayer true if the vehicle has a abs brakes, false otherwise.
	 */
	public void setHasAbsBrakes(boolean hasAbsBrakes) {
		this.hasAbsBrakes = hasAbsBrakes;
	}

	/**
	 * Check if the vehicle has a DVD player.
	 * 
	 * @return true if the vehicle has a DVD player, false otherwise.
	 */
	public boolean isHasDvdPlayer() {
		return hasDvdPlayer;
	}

	/**
	 * Defines whether the vehicle has a DVD player.
	 * 
	 * @param hasDvdPlayer true if the vehicle has a DVD player, false otherwise.
	 */
	public void setHasDvdPlayer(boolean hasDvdPlayer) {
		this.hasDvdPlayer = hasDvdPlayer;
	}

	/**
	 * Returns the vehicle id.
	 * 
	 * @return int containing the vehicle id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Defines the vehicle id.
	 * 
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
}