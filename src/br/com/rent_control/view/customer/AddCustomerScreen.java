package br.com.rent_control.view.customer;

import java.awt.*;
import javax.swing.*;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.controller.*;
import br.com.rent_control.controller.customer.AddCustomerController;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.view.components.*;

/**
 * Class AddCustomerScreen - Represents the screen add customer
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

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

	/**
	 * @param frameRentControl
	 * @param menuPanel
	 */
	public AddCustomerScreen(final RentControl frameRentControl, final MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;

		messagerField = new CustomField("Cadastro de cliente", 40);
		nameField = new CustomField("Nome", 111, 92);
		cpfField = new CustomField("CPF", 455, 92);
		dateOfBirthField = new CustomField("Data de nascimento", 455, 179);
		cnhField = new CustomField("Número da CNH", 111, 179);

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
	 * Class constructor with parameter.
	 * 
	 * @param frameRentControl
	 * @param menuPanel
	 * @param customer
	 */
	public AddCustomerScreen(final RentControl frameRentControl, final MenuPanel menuPanel, Customer customer) {
		setLayout(null);
		setBackground(Color.white);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;

		messagerField = new CustomField("Edição de cliente", 40);
		nameField = new CustomField("Nome", 111, 92, customer.getName(), true);
		cpfField = new CustomField("CPF", 455, 92, customer.getCpf());
		dateOfBirthField = new CustomField("Data de nascimento", 455, 179, customer.getDateOfBirth(), true);
		cnhField = new CustomField("Número da CNH", 111, 179, customer.getLicenseNumber() + "", true);

		addButton = new JButton("Salvar");
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
	 * Returns the Jframe of the application.
	 * 
	 * @return RentControl containing the application frame instance.
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * Returns the application's options menu
	 * 
	 * @return MenuPanel containing the application menu
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getNameField() {
		return nameField;
	}

	/**
	 * Define custom text field
	 * 
	 * @param nameField The custom text field to set
	 */
	public void setNameField(CustomField nameField) {
		this.nameField = nameField;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getCpfField() {
		return cpfField;
	}

	/**
	 * Define custom text field
	 * 
	 * @param cpfField The custom text field to set
	 */
	public void setCpfField(CustomField cpfField) {
		this.cpfField = cpfField;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getDateOfBirthField() {
		return dateOfBirthField;
	}

	/**
	 * Define custom text field
	 * 
	 * @param dateOfBirthField The custom text field to set
	 */
	public void setDateOfBirthField(CustomField dateOfBirthField) {
		this.dateOfBirthField = dateOfBirthField;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getCnhField() {
		return cnhField;
	}

	/**
	 * Define custom text field
	 * 
	 * @param cnhField The custom text field to set
	 */
	public void setCnhField(CustomField cnhField) {
		this.cnhField = cnhField;
	}

	/**
	 * Returns a button
	 * 
	 * @return JButtono containing the button instance
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Define button changes
	 * 
	 * @param addButton The button to be set
	 */
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
}