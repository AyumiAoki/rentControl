package br.com.rent_control.model.vo;

/**
 * Class Customer - Represents a user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class Employee {

	private String name;
	private String cpf;
	private String nickname;
	private String password;

	// Constants with column names
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CPF = "cpf";
	public static final String COLUMN_NICKNAME = "nickname";
	public static final String COLUMN_PASS = "password";

	/**
	 * Parameterless class constructor.
	 */
	public Employee() {
	}

	/**
	 * Class constructor with parameters.
	 * 
	 * @param name
	 * @param cpf
	 * @param nickname
	 * @param password
	 */
	public Employee(String name, String cpf, String nickname, String password) {
		this.name = name;
		this.cpf = cpf;
		this.nickname = nickname;
		this.password = password;
	}

	/**
	 * Returns the name of the employee.
	 * 
	 * @return String containing the employee's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Defines the name of the employee.
	 * 
	 * @param name The name to be defined.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the cpf of the employee.
	 * 
	 * @return String containing the employee's cpf.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Defines the cpf of the employee.
	 * 
	 * @param cpf The cpf to be defined.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Returns the nickname of the employee.
	 * 
	 * @return String containing the employee's nickname.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Defines the nickname of the employee.
	 * 
	 * @param nickname The nickname to be defined.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Returns the password of the employee.
	 * 
	 * @return String containing the employee's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Defines the password of the employee.
	 * 
	 * @param password The password to be defined.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}