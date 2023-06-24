package br.com.rent_control.view.customer;

import java.awt.*;
import javax.swing.*;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.controller.*;
import br.com.rent_control.controller.customer.AddCustomerController;
import br.com.rent_control.view.components.*;

public class AddCustomerScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	 
	private CustomField messagerField;
	private CustomField nameField;
	private CustomField cpfField;
	private CustomField dateOfBirthField;
	private CustomField cnhField;
	private JButton addButton;
	
    private final RentControl frameRentControl;
    private final MenuPanel menuPanel;
	
	public AddCustomerScreen(final RentControl frameRentControl, final MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);
	
		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		
		messagerField = new CustomField("Cadastro de cliente");
		nameField = new CustomField("Nome", 111, 92);
		cpfField = new CustomField("CPF", 455, 92);
		dateOfBirthField = new CustomField("Data de nascimento", 455, 182);
		cnhField = new CustomField("Número da licensa de motorista", 111, 182);
		
		addButton = new JButton("Cadastrar");
		addButton.setForeground(Color.WHITE);
		addButton.setBounds(323, 300, 240, 35);
		addButton.setBackground(ColorUtils.PRIMARY_COLOR);
		addButton.setBorder(null);
		
		add(messagerField.getLabel());
		add(nameField.getLabel());
		add(nameField.getTextField());
		add(cpfField.getLabel());
		add(cpfField.getTextField());
		add(dateOfBirthField.getLabel());
		add(dateOfBirthField.getTextField());
		add(cnhField.getLabel());
		add(cnhField.getTextField());
		add(addButton);
		
		new AddCustomerController(this);
	}

	/**
	 * @return the nameField
	 */
	public CustomField getNameField() {
		return nameField;
	}

	/**
	 * @param nameField the nameField to set
	 */
	public void setNameField(CustomField nameField) {
		this.nameField = nameField;
	}

	/**
	 * @return the cpfField
	 */
	public CustomField getCpfField() {
		return cpfField;
	}

	/**
	 * @param cpfField the cpfField to set
	 */
	public void setCpfField(CustomField cpfField) {
		this.cpfField = cpfField;
	}

	/**
	 * @return the dateOfBirthField
	 */
	public CustomField getDateOfBirthField() {
		return dateOfBirthField;
	}

	/**
	 * @param dateOfBirthField the dateOfBirthField to set
	 */
	public void setDateOfBirthField(CustomField dateOfBirthField) {
		this.dateOfBirthField = dateOfBirthField;
	}

	/**
	 * @return the cnhField
	 */
	public CustomField getCnhField() {
		return cnhField;
	}

	/**
	 * @param cnhField the cnhField to set
	 */
	public void setCnhField(CustomField cnhField) {
		this.cnhField = cnhField;
	}

	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * @param addButton the addButton to set
	 */
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	/**
	 * @return the frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return the menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
}