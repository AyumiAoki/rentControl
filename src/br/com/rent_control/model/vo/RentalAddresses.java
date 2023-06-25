package br.com.rent_control.model.vo;

/**
 * @author ayumi
 *
 */

public class RentalAddresses {

	private String location;
	public static final String COLUMN_ADDRESS = "address";

	public RentalAddresses() {
	}

	public RentalAddresses(String location) {
		this.location = location;
	}

	/**
	 * @return o location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location o location a ser configurado
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}