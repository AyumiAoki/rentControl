package br.com.rent_control.model.vo;

/**
 * Class Customer - Represents a user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class Customer {

	private String name;
	private String cpf;
	private long licenseNumber;
	private String dateOfBirth;

	// Constants with column names
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CPF = "cpf";
	public static final String COLUMN_LICENSENUMBER = "licenseNumber";
	public static final String COLUMN_DDN = "dateOfBirth";

	/**
	 * Parameterless class constructor.
	 */
	public Customer() {
	}

	/**
	 * Class constructor with parameters.
	 * 
	 * @param name
	 * @param cpf
	 * @param licenseNumber
	 * @param iDNumber
	 * @param dateOfBirth
	 */
	public Customer(String name, String cpf, long licenseNumber, String dateOfBirth) {
		this.name = name;
		this.cpf = cpf;
		this.licenseNumber = licenseNumber;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Returns the name of user.
	 * 
	 * @return String containing name of user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Defines the name of user.
	 * 
	 * @param name The name of user to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the CPF of user.
	 * 
	 * @return String containing CPF of user.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Defines the CPF of user.
	 * 
	 * @param cpf The CPF of user to set.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Returns the license number of user.
	 * 
	 * @return double containing license number of user.
	 */
	public long getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * Defines the license number of user.
	 * 
	 * @param licenseNumber The license number of user to set.
	 */
	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * Returns the date of birth of user.
	 * 
	 * @return String containing date of birth of user.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Defines the date of birth of user.
	 * 
	 * @param dateOfBirth The date of birth of user to set.
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}