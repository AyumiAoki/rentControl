package br.com.rent_control.model.vo;

/**
 * Class Customer - Represents a user in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-07
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
	 * @return o name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name o name a ser configurado
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return o cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf o cpf a ser configurado
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname o nickname a ser configurado
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return o password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password o password a ser configurado
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}