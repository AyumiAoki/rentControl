package br.com.rent_control.model.vo;

/**
 * Class Car - Represents a car in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-06
 */

public class Car {
	
	private String category;
	private int maxPassengers;
	private double trunkSize;
	private String transmissionType;
	private String fuelType;
	private boolean hasAc;
	private boolean hasAirbag;
	private boolean hasAbsBrakes;
	private boolean hasDvdPlayer;
	private double dailyCost;
	
	/**
	 * Parameterless class constructor.
	 */
	public Car() {}
	
	/**
	 * Class constructor with parameters.
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
	public Car(String category, int maxPassengers, double trunkSize, String transmissionType, String fuelType,
			boolean hasAc, boolean hasAirbag, boolean hasAbsBrakes, boolean hasDvdPlayer, double dailyCost) {
		this.category = category;
		this.maxPassengers = maxPassengers;
		this.trunkSize = trunkSize;
		this.transmissionType = transmissionType;
		this.fuelType = fuelType;
		this.hasAc = hasAc;
		this.hasAirbag = hasAirbag;
		this.hasAbsBrakes = hasAbsBrakes;
		this.hasDvdPlayer = hasDvdPlayer;
		this.dailyCost = dailyCost;
	}

	/**
	 * Returns the vehicle category.
	 * @return String containing the vehicle category.
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Defines the vehicle category.
	 * @param category The vehicle category to set.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Returns the maximum number of passengers.
	 * @return int containing the maximum number of passengers.
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	/**
	 * Defines the maximum number of passengers.
	 * @param maxPassengers The maximum number of passengers to set.
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	/**
	 * Returns the size the trunk.
	 * @return double containing the size trunk.
	 */
	public double getTrunkSize() {
		return trunkSize;
	}
	
	/**
	 * Defines the size trunk.
	 * @param trunkSize The size trunk to set.
	 */
	public void setTrunkSize(double trunkSize) {
		this.trunkSize = trunkSize;
	}
	
	/**
	 * Returns the transmission type (manual or automatic).
	 * @return char containing the transmission type (m or a).
	 */
	public String getTransmissionType() {
		return transmissionType;
	}
	
	/**
	 * Defines the transmission type.
	 * @param transmissionType The transmission type to set.
	 */
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}
	
	/**
	 * Returns the fuel type (diesel, gasoline, ethanol or flex).
	 * @return char containing the fuel type (d, g, e or f).
	 */
	public String getFuelType() {
		return fuelType;
	}
	
	/**
	 * Defines the fuel type.
	 * @param fuelType The fuel type to set.
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
		
	/**
	 * Check if the vehicle has a air conditioning.
	 * @return true if the vehicle has a air conditioning, false otherwise.
	 */
	public boolean isHasAc() {
		return hasAc;
	}
	
	/**
	 * Defines whether the vehicle has a air conditioning.
	 * @param hasDvdPlayer true if the vehicle has a air conditioning, false otherwise.
	 */
	public void setHasAc(boolean hasAc) {
		this.hasAc = hasAc;
	}
	
	/**
	 * Check if the vehicle has a airbag.
	 * @return true if the vehicle has a airbag, false otherwise.
	 */
	public boolean isHasAirbag() {
		return hasAirbag;
	}
	
	/**
	 * Defines whether the vehicle has a airbag.
	 * @param hasDvdPlayer true if the vehicle has a airbag, false otherwise.
	 */
	public void setHasAirbag(boolean hasAirbag) {
		this.hasAirbag = hasAirbag;
	}
	
	/**
	 * Check if the vehicle has a abs brakes.
	 * @return true if the vehicle has a abs brakes, false otherwise.
	 */
	public boolean isHasAbsBrakes() {
		return hasAbsBrakes;
	}
	
	/**
	 * Defines whether the vehicle has a abs brakes.
	 * @param hasDvdPlayer true if the vehicle has a abs brakes, false otherwise.
	 */
	public void setHasAbsBrakes(boolean hasAbsBrakes) {
		this.hasAbsBrakes = hasAbsBrakes;
	}
	
	/**
	 * Check if the vehicle has a DVD player.
	 * @return true if the vehicle has a DVD player, false otherwise.
	 */
	public boolean isHasDvdPlayer() {
		return hasDvdPlayer;
	}
	
	/**
	 * Defines whether the vehicle has a DVD player.
	 * @param hasDvdPlayer true if the vehicle has a DVD player, false otherwise.
	 */
	public void setHasDvdPlayer(boolean hasDvdPlayer) {
		this.hasDvdPlayer = hasDvdPlayer;
	}
	
	/**
	 * Returns the daily Cost.
	 * @return double containing the daily Cost.
	 */
	public double getDailyCost() {
		return dailyCost;
	}
	
	/**
	 * Defines the daily Cost.
	 * @param dailyCost The daily Cost to set.
	 */
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}
}