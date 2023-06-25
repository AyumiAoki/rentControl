package br.com.rent_control.model.vo;

/**
 * Class Rent - Represents a rent in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class Rent {

	private String withdrawalDate;
	private String pickUpLocation;
	private String deliveryDate;
	private String deliveryLocation;
	private String cpfCustomer;
	private int idCar;
	private boolean carProtection;
	private boolean gps;
	private boolean cleaning;
	private boolean drinkComfort;
	private boolean babyChair;
	private boolean boosterSeat;

	/**
	 * Parameterless class constructor.
	 */
	public Rent() {
	}

	/**
	 * Class constructor with parameters.
	 * 
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
	public Rent(String withdrawalDate, String pickUpLocation, String deliveryDate, String deliveryLocation,
			String cpfCustomer, int idCar, boolean carProtection, boolean gps, boolean cleaning, boolean drinkComfort,
			boolean babyChair, boolean boosterSeat) {
		this.withdrawalDate = withdrawalDate;
		this.pickUpLocation = pickUpLocation;
		this.deliveryDate = deliveryDate;
		this.deliveryLocation = deliveryLocation;
		this.cpfCustomer = cpfCustomer;
		this.idCar = idCar;
		this.carProtection = carProtection;
		this.gps = gps;
		this.cleaning = cleaning;
		this.drinkComfort = drinkComfort;
		this.babyChair = babyChair;
		this.boosterSeat = boosterSeat;
	}

	/**
	 * Returns the withdrawal date.
	 * 
	 * @return String containing the withdrawal date.
	 */
	public String getWithdrawalDate() {
		return withdrawalDate;
	}

	/**
	 * Defines the withdrawal date.
	 * 
	 * @param withdrawalDate The withdrawal date to be defined.
	 */
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	/**
	 * Returns the pickup location.
	 * 
	 * @return String containing the pickup location.
	 */
	public String getPickUpLocation() {
		return pickUpLocation;
	}

	/**
	 * Defines the pickup location.
	 * 
	 * @param pickUpLocation Pickup location to be defined.
	 */
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	/**
	 * 
	 * Returns the return date.
	 * 
	 * @return String containing the return date.
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Defines the return date.
	 * 
	 * @param deliveryDate The return date to be defined.
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Returns the drop-off location.
	 * 
	 * @return String containing the return location.
	 */
	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	/**
	 * Defines the return location.
	 * 
	 * @param deliveryLocation The return location to be defined.
	 */
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	/**
	 * Return the customer's cpf.
	 * 
	 * @return String containing the customer's CPF.
	 */
	public String getCpfCustomer() {
		return cpfCustomer;
	}

	/**
	 * Define the customer's cpf.
	 * 
	 * @param customer The customer's cpf to be defined.
	 */
	public void setCpfCustomer(String cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}

	/**
	 * Returns the id of the vehicle to be allocated
	 * 
	 * @return int containing the vehicle id.
	 */
	public int getIdCar() {
		return idCar;
	}

	/**
	 * Define the id of the car to be allocated.
	 * 
	 * @param car The id of the car to set.
	 */
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	/**
	 * Returns if car protection has been added to the lease.
	 * 
	 * @return boolean containing true or false if car protection was added to the
	 *         lease.
	 */
	public boolean isCarProtection() {
		return carProtection;
	}

	/**
	 * Defines whether the vehicle has protection added.
	 * 
	 * @param carProtection The value that indicates whether the car has protection
	 *                      or not.
	 */
	public void setCarProtection(boolean carProtection) {
		this.carProtection = carProtection;
	}

	/**
	 * Returns whether the GPS has been added to the location.
	 * 
	 * @return boolean containing true or false if the GPS was added to the
	 *         location.
	 */
	public boolean isGps() {
		return gps;
	}

	/**
	 * Defines whether the vehicle has GPS added.
	 * 
	 * @param gps The value that indicates whether the car has GPS or not.
	 */
	public void setGps(boolean gps) {
		this.gps = gps;
	}

	/**
	 * Returns whether vehicle cleaning has been added to the lease.
	 * 
	 * @return boolean containing true or false if cleaning was added to tenancy.
	 */
	public boolean isCleaning() {
		return cleaning;
	}

	/**
	 * Defines if the vehicle has the cleaning added.
	 * 
	 * @param cleaning The value that indicates whether the car is clean or not.
	 */
	public void setCleaning(boolean cleaning) {
		this.cleaning = cleaning;
	}

	/**
	 * Returns if the baby comfort was added to the lease.
	 * 
	 * @return boolean containing true or false if the baby comfort was added to the
	 *         lease.
	 */
	public boolean isDrinkComfort() {
		return drinkComfort;
	}

	/**
	 * Defines whether the vehicle has baby comfort added.
	 * 
	 * @param drinkComfort The value that indicates whether the car has baby comfort
	 *                     or not.
	 */
	public void setDrinkComfort(boolean drinkComfort) {
		this.drinkComfort = drinkComfort;
	}

	/**
	 * Returns if the baby chair was added to the location.
	 * 
	 * @return boolean containing true or false if the baby chair was added to the
	 *         lease.
	 */
	public boolean isBabyChair() {
		return babyChair;
	}

	/**
	 * Defines if the vehicle has a baby seat added.
	 * 
	 * @param babyChair The value that indicates whether the car has a baby seat or
	 *                  not.
	 */
	public void setBabyChair(boolean babyChair) {
		this.babyChair = babyChair;
	}

	/**
	 * Returns whether the booster seat has been added to the lease.
	 * 
	 * @return boolean containing true or false if the booster seat has been added
	 *         to the lease.
	 */
	public boolean isBoosterSeat() {
		return boosterSeat;
	}

	/**
	 * Defines whether the vehicle has the booster seat added.
	 * 
	 * @param boosterSeat The value indicating whether the car has a booster seat or
	 *                    not.
	 */
	public void setBoosterSeat(boolean boosterSeat) {
		this.boosterSeat = boosterSeat;
	}
}