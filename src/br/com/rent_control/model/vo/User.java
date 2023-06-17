package br.com.rent_control.model.vo;

/**
 * Class User - Represents a user in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-06
 */

public class User {
	
	private String name;
	private String nationality;
	private String cpf;
	private long licenseNumber;
	private int idNumber;
	private String dateOfBirth;
	private int cep;
	private int numberHouse;
	private String neighborhood;
	private String road;
	private String city;
	private String state;
	
	//Constants with column names
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CPF = "cpf";
	
	/**
	 * Parameterless class constructor.
	 */	
	public User() {}
	
	/**
	 * Class constructor with parameters.
	 * @param name
	 * @param nationality
	 * @param cpf
	 * @param licenseNumber
	 * @param iDNumber
	 * @param dateOfBirth
	 * @param cep
	 * @param numberHouse
	 * @param neighborhood
	 * @param road
	 * @param city
	 * @param state
	 */
	public User(String name, String nationality, String cpf, long licenseNumber, int idNumber, String dateOfBirth,
			int cep, int numberHouse, String neighborhood, String road, String city, String state) {
		this.name = name;
		this.nationality = nationality;
		this.cpf = cpf;
		this.licenseNumber = licenseNumber;
		this.idNumber = idNumber;
		this.dateOfBirth = dateOfBirth;
		this.cep = cep;
		this.numberHouse = numberHouse;
		this.neighborhood = neighborhood;
		this.road = road;
		this.city = city;
		this.state = state;
	}

	/**
	 * Returns the name of user.
	 * @return String containing name of user.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Defines the name of user.
	 * @param name The name of user to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the nationality of user.
	 * @return String containing nationality of user.
	 */
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * Defines the nationality of user.
	 * @param nationality The nationality of user to set.
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * Returns the CPF of user.
	 * @return String containing CPF of user.
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Defines the CPF of user.
	 * @param cpf The CPF of user to set.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Returns the license number of user.
	 * @return double containing license number of user.
	 */
	public long getLicenseNumber() {
		return licenseNumber;
	}
	
	/**
	 * Defines the license number of user.
	 * @param licenseNumber The license number of user to set.
	 */
	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	/**
	 * Returns the ID number of user.
	 * @return double containing ID number of user.
	 */
	public int getIDNumber() {
		return idNumber;
	}
	
	/**
	 * Defines the ID number of user.
	 * @param iDNumber The ID number of user to set.
	 */
	public void setIDNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	/**
	 * Returns the date of birth of user.
	 * @return String containing date of birth of user.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Defines the date of birth of user.
	 * @param dateOfBirth The date of birth of user to set.
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Returns the CEP of user.
	 * @return double containing CEP of user.
	 */
	public int getCEP() {
		return cep;
	}
	
	/**
	 * Defines the CEP of user.
	 * @param cep The CEP of user to set.
	 */
	public void setCEP(int cep) {
		this.cep = cep;
	}
	
	/**
	 * Returns the number house of user.
	 * @return double containing number house of user.
	 */
	public int getNumberHouse() {
		return numberHouse;
	}
	
	/**
	 * Defines the number house of user.
	 * @param numberHouse The number house of user to set.
	 */
	public void setNumberHouse(int numberHouse) {
		this.numberHouse = numberHouse;
	}
	
	/**
	 * Returns the neighborhood of user.
	 * @return String containing neighborhood of user.
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	
	/**
	 * Defines the neighborhood of user.
	 * @param neighborhood The neighborhood of user to set.
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	/**
	 * Returns the road of user.
	 * @return String containing road of user.
	 */
	public String getRoad() {
		return road;
	}
	
	/**
	 * Defines the road of user.
	 * @param road The road of user to set.
	 */
	public void setRoad(String road) {
		this.road = road;
	}
	
	/**
	 * Returns the city of user.
	 * @return String containing city of user.
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Defines the city of user.
	 * @param city The city of user to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Returns the state of user.
	 * @return String containing state of user.
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Defines the state of user.
	 * @param state The state of user to set.
	 */
	public void setState(String state) {
		this.state = state;
	}
}