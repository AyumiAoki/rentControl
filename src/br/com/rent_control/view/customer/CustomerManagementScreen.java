package br.com.rent_control.view.customer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomTable;


public class CustomerManagementScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private final RentControl frameRentControl;
	private JLabel messagerLabel;
	private JButton newButton;

	public interface ActionButton {
	    void action(String id, String type);
	}
	
	private Object[][] data = {
			{"Nome", "idade", "Pais", "Cep", "id"},
            {"John Doe", 30, "New York", "1231", "1"},
            {"John Doe", 30, "New York", "1231", "2"}
    };
	
	
	public CustomerManagementScreen(final RentControl frameRentControl) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBackground(Color.white);
		
		this.frameRentControl = frameRentControl;
		messagerLabel = new JLabel("Clientes");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));
		
		newButton = new JButton("Novo");
		newButton.setForeground(Color.WHITE);
		newButton.setBounds(750, 20, 80, 34);
		newButton.setBackground(ColorUtils.PRIMARY_LIGHT_COLOR);
		newButton.setBorder(null);
		
		ActionButton funcao1 = (id, type) -> System.out.println("Olá, mundo!" + id + type);
		CustomTable customTable = new CustomTable(funcao1, data);
		JScrollPane scrollPane = new JScrollPane(customTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 100, 789, 500);
        scrollPane.setBorder(null);
		
		add(scrollPane);
		
		add(newButton);
		
		add(messagerLabel);
	}
	
	

	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}
}
