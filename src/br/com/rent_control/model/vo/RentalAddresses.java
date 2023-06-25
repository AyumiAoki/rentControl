package br.com.rent_control.model.vo;

/**
 * Class RentalAddresses - Represents the rental company's address book in the
 * application.
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentalAddresses {

	private String location;
	public static final String COLUMN_ADDRESS = "address";

	/**
	 * Parameterless class constructor.
	 */
	public RentalAddresses() {
	}

	/**
	 * Class constructor with parameters.
	 * 
	 * @param location
	 */
	public RentalAddresses(String location) {
		this.location = location;
	}

	/**
	 * Returns a rental address.
	 * 
	 * @return String containing an address of the rental company.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Define an address for the rental company.
	 * 
	 * @param location The address to be set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}