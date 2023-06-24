package br.com.rent_control.model.vo;

/**
 * Class Rent - Represents a rent in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-06
 */

public class Rent {
	
	private String withdrawalDate;
	private String pickUpLocation;
	private String deliveryDate;
	private String deliveryLocation;
	private Customer customer;
	private Car car;
	private boolean carProtection;
	private boolean gps;
	private boolean cleaning;
	private boolean drinkComfort;
	private boolean babyChair;
	private boolean boosterSeat;
	
	/**
	 * Parameterless class constructor.
	 */	
	public Rent() {}

	/**
	 * Class constructor with parameters.
	 * @param withdrawalDate
	 * @param pickUpLocation
	 * @param deliveryDate
	 * @param deliveryLocation
	 * @param customer
	 * @param car
	 * @param carProtection
	 * @param gps
	 * @param cleaning
	 * @param drinkComfort
	 * @param babyChair
	 * @param boosterSeat
	 */
	public Rent(String withdrawalDate, String pickUpLocation, String deliveryDate, String deliveryLocation, Customer customer,
			Car car, boolean carProtection, boolean gps, boolean cleaning, boolean drinkComfort, boolean babyChair,
			boolean boosterSeat) {
		this.withdrawalDate = withdrawalDate;
		this.pickUpLocation = pickUpLocation;
		this.deliveryDate = deliveryDate;
		this.deliveryLocation = deliveryLocation;
		this.customer = customer;
		this.car = car;
		this.carProtection = carProtection;
		this.gps = gps;
		this.cleaning = cleaning;
		this.drinkComfort = drinkComfort;
		this.babyChair = babyChair;
		this.boosterSeat = boosterSeat;
	}

	/**
	 * Returns the withdrawal date.
	 * @return String containing the withdrawal date.
	 */
	public String getWithdrawalDate() {
		return withdrawalDate;
	}

	/**
	 * @param withdrawalDate o withdrawalDate a ser configurado
	 */
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	/**
	 * Returns the withdrawal date.
	 * @return String containing the withdrawal date.
	 */
	public String getPickUpLocation() {
		return pickUpLocation;
	}

	/**
	 * @param pickUpLocation o pickUpLocation a ser configurado
	 */
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	/**
	 * @return o deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate o deliveryDate a ser configurado
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return o deliveryLocation
	 */
	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	/**
	 * @param deliveryLocation o deliveryLocation a ser configurado
	 */
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	/**
	 * @return o customer
	 */
	public Customer getUser() {
		return customer;
	}

	/**
	 * @param customer o customer a ser configurado
	 */
	public void setUser(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return o car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car o car a ser configurado
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * @return o carProtection
	 */
	public boolean isCarProtection() {
		return carProtection;
	}

	/**
	 * @param carProtection o carProtection a ser configurado
	 */
	public void setCarProtection(boolean carProtection) {
		this.carProtection = carProtection;
	}

	/**
	 * @return o gps
	 */
	public boolean isGps() {
		return gps;
	}

	/**
	 * @param gps o gps a ser configurado
	 */
	public void setGps(boolean gps) {
		this.gps = gps;
	}

	/**
	 * @return o cleaning
	 */
	public boolean isCleaning() {
		return cleaning;
	}

	/**
	 * @param cleaning o cleaning a ser configurado
	 */
	public void setCleaning(boolean cleaning) {
		this.cleaning = cleaning;
	}

	/**
	 * @return o drinkComfort
	 */
	public boolean isDrinkComfort() {
		return drinkComfort;
	}

	/**
	 * @param drinkComfort o drinkComfort a ser configurado
	 */
	public void setDrinkComfort(boolean drinkComfort) {
		this.drinkComfort = drinkComfort;
	}

	/**
	 * @return o babyChair
	 */
	public boolean isBabyChair() {
		return babyChair;
	}

	/**
	 * @param babyChair o babyChair a ser configurado
	 */
	public void setBabyChair(boolean babyChair) {
		this.babyChair = babyChair;
	}

	/**
	 * @return o boosterSeat
	 */
	public boolean isBoosterSeat() {
		return boosterSeat;
	}

	/**
	 * @param boosterSeat o boosterSeat a ser configurado
	 */
	public void setBoosterSeat(boolean boosterSeat) {
		this.boosterSeat = boosterSeat;
	}
	
	
}