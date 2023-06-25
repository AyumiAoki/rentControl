package br.com.rent_control.controller;

import javax.swing.*;
import br.com.rent_control.model.CreateDatabase;
import br.com.rent_control.view.*;
import java.awt.BorderLayout;

/**
 * Class RentControl - Represents the main class in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentControl extends JFrame {

	private static final long serialVersionUID = 1582258940777760838L;
	private LoginScreen telaLogin;
	private CreateDatabase createDatabase;

	/**
	 * Parameterless class constructor.
	 */
	public RentControl() {
		createDatabase = new CreateDatabase();
		telaLogin = new LoginScreen(this);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rent Control");
		setSize(1086, 705);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		add(telaLogin);
		createDatabase.createDbTables();
	}

	/**
	 * Main application method
	 */
	public static void main(String[] args) {
		new RentControl();
	}
}