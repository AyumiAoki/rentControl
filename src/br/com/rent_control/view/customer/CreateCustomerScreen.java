package br.com.rent_control.view.customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateCustomerScreen extends JPanel {
	 private static final long serialVersionUID = 1L;
	 private JLabel messagerLabel;
	public CreateCustomerScreen() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBackground(Color.white);
		
		messagerLabel = new JLabel("Clientes");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));
		add(messagerLabel);
	}
}
