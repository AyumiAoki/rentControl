package br.com.rent_control.controller;

import br.com.rent_control.model.CreateDatabase;
import br.com.rent_control.view.*;

import java.awt.BorderLayout;

import javax.swing.*;

/**
 * Class RentControl - Represents the main class in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentControl extends JFrame {

	private static final long serialVersionUID = 1582258940777760838L;
	private LoginScreen telaLogin;
	private CreateDatabase createDatabase;

	public RentControl() {
		createDatabase = new CreateDatabase();
		telaLogin = new LoginScreen(this);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rent Control");
		setSize(950, 725);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);

		add(telaLogin);
		createDatabase.createDbTables();
	}

	public static void main(String[] args) {
		new RentControl();
	}
}