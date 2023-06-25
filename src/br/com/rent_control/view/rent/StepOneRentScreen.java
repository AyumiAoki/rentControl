package br.com.rent_control.view.rent;

import java.awt.Color;
import java.util.*;
import javax.swing.*;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.StepOneRentController;
import br.com.rent_control.model.dao.RentalAddressesDao;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.model.vo.RentalAddresses;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.*;

/**
 * Class StepOneRentScreen - Represents the first stage of vehicle rental
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class StepOneRentScreen extends JPanel {

	private static final long serialVersionUID = 8140101290388352518L;
	private MenuPanel menuPanel;
	private final RentControl frameRentControl;

	private CustomField rentMessagerLabel;
	private CustomField customerMessagerLabel;
	private CustomField dateMessagerLabel;
	private CustomField cpfField;
	private CustomField nameFieldDisable;
	private CustomField cpfFieldDisable;
	private CustomField dateOfBirthFieldDisable;
	private CustomField cnhFieldDisable;
	private CustomField withdrawalDate;
	private CustomField pickUpLocation;
	private CustomField deliveryDate;
	private CustomField returnLocation;
	private JButton searchButton;
	private JButton proceedButton;
	private JButton returnButton;
	private JPanel fieldsPanel;

	private Customer customer;
	private int idCar;
	private double dailyCost;

	/**
	 * Class constructor with parameter.
	 * 
	 * @param frameRentControl
	 * @param menuPanel
	 * @param idCar
	 * @param dailyCost
	 */
	public StepOneRentScreen(final RentControl frameRentControl, MenuPanel menuPanel, int idCar, double dailyCost) {
		setLayout(null);
		setBackground(Color.white);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		this.idCar = idCar;
		this.dailyCost = dailyCost;

		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(null);
		fieldsPanel.setBounds(0, 139, 886, 542);
		fieldsPanel.setBackground(Color.white);
		customer = new Customer();

		rentMessagerLabel = new CustomField("Aluguel do veículo - Cliente e Data", 40);
		cpfField = new CustomField("Digite o CPF do locatário", 111, 76);
		searchButton = new JButton("Buscar");
		searchButton.setForeground(Color.WHITE);
		searchButton.setBounds(535, 104, 240, 35);
		searchButton.setBackground(ColorUtils.PRIMARY_COLOR);
		searchButton.setBorder(null);

		searchButton.addActionListener(e -> new StepOneRentController(this).searchButtonClicked());

		add(rentMessagerLabel.getLabel());
		add(cpfField.getLabel());
		add(searchButton);
		add(cpfField.getTextField());
	}

	/**
	 * Method that displays user information and date fields for rent
	 */
	public void showFields() {
		customerMessagerLabel = new CustomField("Dados do locatário", 24);
		nameFieldDisable = new CustomField("Nome", 111, 60, customer.getName());
		cpfFieldDisable = new CustomField("CPF", 455, 60, customer.getCpf());
		dateOfBirthFieldDisable = new CustomField("Data de nascimento", 111, 147, customer.getDateOfBirth());
		cnhFieldDisable = new CustomField("Número da licensa", 455, 147, String.valueOf(customer.getLicenseNumber()));

		dateMessagerLabel = new CustomField("Data da locação", 242);
		withdrawalDate = new CustomField("Data da retirada", 111, 278);
		pickUpLocation = new CustomField("Local da retirada", 455, 278, getRentalAddresses());
		deliveryDate = new CustomField("Data da devolução", 111, 365);
		returnLocation = new CustomField("Local da devolução", 455, 365, getRentalAddresses());

		returnButton = new JButton("Retornar");
		returnButton.setForeground(Color.WHITE);
		returnButton.setBounds(111, 460, 240, 35);
		returnButton.setBackground(ColorUtils.PRIMARY_COLOR);
		returnButton.setBorder(null);

		proceedButton = new JButton("Prosseguir");
		proceedButton.setForeground(Color.WHITE);
		proceedButton.setBounds(535, 460, 240, 35);
		proceedButton.setBackground(ColorUtils.PRIMARY_COLOR);
		proceedButton.setBorder(null);

		fieldsPanel.add(customerMessagerLabel.getLabel());
		fieldsPanel.add(nameFieldDisable.getLabel());
		fieldsPanel.add(nameFieldDisable.getTextField());
		fieldsPanel.add(cpfFieldDisable.getLabel());
		fieldsPanel.add(cpfFieldDisable.getTextField());
		fieldsPanel.add(dateOfBirthFieldDisable.getLabel());
		fieldsPanel.add(dateOfBirthFieldDisable.getTextField());
		fieldsPanel.add(cnhFieldDisable.getLabel());
		fieldsPanel.add(cnhFieldDisable.getTextField());
		fieldsPanel.add(dateMessagerLabel.getLabel());
		fieldsPanel.add(withdrawalDate.getLabel());
		fieldsPanel.add(withdrawalDate.getTextField());
		fieldsPanel.add(pickUpLocation.getLabel());
		fieldsPanel.add(pickUpLocation.getComboBox());
		fieldsPanel.add(deliveryDate.getLabel());
		fieldsPanel.add(deliveryDate.getTextField());
		fieldsPanel.add(returnLocation.getLabel());
		fieldsPanel.add(returnLocation.getComboBox());
		fieldsPanel.add(returnButton);
		fieldsPanel.add(proceedButton);

		returnButton.addActionListener(e -> new StepOneRentController(this).returnButtonClicked());
		proceedButton.addActionListener(e -> new StepOneRentController(this).proceedButtonClicked());

		add(fieldsPanel);
		revalidate();
		repaint();
	}

	/**
	 * Method that removes the fields from the panel
	 */
	public void removeFieldsPanel() {
		remove(fieldsPanel);
		revalidate();
		repaint();
	}

	/**
	 * Method that returns the list of rental addresses
	 * 
	 * @return String[] containing the list of addresses
	 */
	private String[] getRentalAddresses() {
		RentalAddressesDao dao = new RentalAddressesDao();
		List<String> options = new ArrayList<String>();
		for (RentalAddresses address : dao.listLocations()) {
			options.add(address.getLocation());
		}
		return options.toArray(new String[0]);
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
	public CustomField getNameFieldDisable() {
		return nameFieldDisable;
	}

	/**
	 * Define custom text field
	 * 
	 * @param nameFieldDisable The custom text field to set
	 */
	public void setNameFieldDisable(CustomField nameFieldDisable) {
		this.nameFieldDisable = nameFieldDisable;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getCpfFieldDisable() {
		return cpfFieldDisable;
	}

	/**
	 * Define custom text field
	 * 
	 * @param cpfFieldDisable The custom text field to set
	 */
	public void setCpfFieldDisable(CustomField cpfFieldDisable) {
		this.cpfFieldDisable = cpfFieldDisable;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getDateOfBirthFieldDisable() {
		return dateOfBirthFieldDisable;
	}

	/**
	 * Define custom text field
	 * 
	 * @param dateOfBirthFieldDisable The custom text field to set
	 */
	public void setDateOfBirthFieldDisable(CustomField dateOfBirthFieldDisable) {
		this.dateOfBirthFieldDisable = dateOfBirthFieldDisable;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getCnhFieldDisable() {
		return cnhFieldDisable;
	}

	/**
	 * Define custom text field
	 * 
	 * @param cnhFieldDisable The custom text field to set
	 */
	public void setCnhFieldDisable(CustomField cnhFieldDisable) {
		this.cnhFieldDisable = cnhFieldDisable;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getWithdrawalDate() {
		return withdrawalDate;
	}

	/**
	 * Define custom text field
	 * 
	 * @param withdrawalDate The custom text field to set
	 */
	public void setWithdrawalDate(CustomField withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getPickUpLocation() {
		return pickUpLocation;
	}

	/**
	 * Define custom text field
	 * 
	 * @param pickUpLocation The custom text field to set
	 */
	public void setPickUpLocation(CustomField pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Define custom text field
	 * 
	 * @param deliveryDate The custom text field to set
	 */
	public void setDeliveryDate(CustomField deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Returns a custom text field
	 * 
	 * @return CustomField containing field information
	 */
	public CustomField getReturnLocation() {
		return returnLocation;
	}

	/**
	 * Define custom text field
	 * 
	 * @param returnLocation The custom text field to set
	 */
	public void setReturnLocation(CustomField returnLocation) {
		this.returnLocation = returnLocation;
	}

	/**
	 * Returns a button
	 * 
	 * @return JButtono containing the button instance
	 */
	public JButton getReturnButton() {
		return returnButton;
	}

	/**
	 * Define button changes
	 * 
	 * @param returnButton The button to be set
	 */
	public void setReturnButton(JButton returnButton) {
		this.returnButton = returnButton;
	}

	/**
	 * Returns a customer
	 * 
	 * @return Customer containing customer data
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Define a customer
	 * 
	 * @param customer The client to be edited
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Returns the vehicle id.
	 * 
	 * @return int containing the vehicle id.
	 */
	public int getIdCar() {
		return idCar;
	}

	/**
	 * Defines the vehicle id.
	 * 
	 * @param idCar The id to set.
	 */
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	/**
	 * Returns the daily Cost.
	 * 
	 * @return double containing the daily Cost.
	 */
	public double getDailyCost() {
		return dailyCost;
	}

	/**
	 * Defines the daily Cost.
	 * 
	 * @param dailyCost The daily Cost to set.
	 */
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}
}