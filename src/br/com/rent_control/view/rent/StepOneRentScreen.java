/**
 * 
 */
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
 * @author ayumi
 *
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

	public void removeFieldsPanel() {
		remove(fieldsPanel);
		revalidate();
		repaint();
	}

	private String[] getRentalAddresses() {
		RentalAddressesDao dao = new RentalAddressesDao();
		List<String> options = new ArrayList<String>();
		for (RentalAddresses address : dao.listLocations()) {
			options.add(address.getLocation());
		}
		return options.toArray(new String[0]);
	}
	
	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return o menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * @param menuPanel o menuPanel a ser configurado
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * @return o cpfField
	 */
	public CustomField getCpfField() {
		return cpfField;
	}

	/**
	 * @param cpfField o cpfField a ser configurado
	 */
	public void setCpfField(CustomField cpfField) {
		this.cpfField = cpfField;
	}

	/**
	 * @return o nameFieldDisable
	 */
	public CustomField getNameFieldDisable() {
		return nameFieldDisable;
	}

	/**
	 * @param nameFieldDisable o nameFieldDisable a ser configurado
	 */
	public void setNameFieldDisable(CustomField nameFieldDisable) {
		this.nameFieldDisable = nameFieldDisable;
	}

	/**
	 * @return o cpfFieldDisable
	 */
	public CustomField getCpfFieldDisable() {
		return cpfFieldDisable;
	}

	/**
	 * @param cpfFieldDisable o cpfFieldDisable a ser configurado
	 */
	public void setCpfFieldDisable(CustomField cpfFieldDisable) {
		this.cpfFieldDisable = cpfFieldDisable;
	}

	/**
	 * @return o dateOfBirthFieldDisable
	 */
	public CustomField getDateOfBirthFieldDisable() {
		return dateOfBirthFieldDisable;
	}

	/**
	 * @param dateOfBirthFieldDisable o dateOfBirthFieldDisable a ser configurado
	 */
	public void setDateOfBirthFieldDisable(CustomField dateOfBirthFieldDisable) {
		this.dateOfBirthFieldDisable = dateOfBirthFieldDisable;
	}

	/**
	 * @return o cnhFieldDisable
	 */
	public CustomField getCnhFieldDisable() {
		return cnhFieldDisable;
	}

	/**
	 * @param cnhFieldDisable o cnhFieldDisable a ser configurado
	 */
	public void setCnhFieldDisable(CustomField cnhFieldDisable) {
		this.cnhFieldDisable = cnhFieldDisable;
	}

	/**
	 * @return o withdrawalDate
	 */
	public CustomField getWithdrawalDate() {
		return withdrawalDate;
	}

	/**
	 * @param withdrawalDate o withdrawalDate a ser configurado
	 */
	public void setWithdrawalDate(CustomField withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	/**
	 * @return o pickUpLocation
	 */
	public CustomField getPickUpLocation() {
		return pickUpLocation;
	}

	/**
	 * @param pickUpLocation o pickUpLocation a ser configurado
	 */
	public void setPickUpLocation(CustomField pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	/**
	 * @return o deliveryDate
	 */
	public CustomField getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate o deliveryDate a ser configurado
	 */
	public void setDeliveryDate(CustomField deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return o returnLocation
	 */
	public CustomField getReturnLocation() {
		return returnLocation;
	}

	/**
	 * @param returnLocation o returnLocation a ser configurado
	 */
	public void setReturnLocation(CustomField returnLocation) {
		this.returnLocation = returnLocation;
	}

	/**
	 * @return o returnButton
	 */
	public JButton getReturnButton() {
		return returnButton;
	}

	/**
	 * @param returnButton o returnButton a ser configurado
	 */
	public void setReturnButton(JButton returnButton) {
		this.returnButton = returnButton;
	}

	/**
	 * @return o customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer o customer a ser configurado
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return o idCar
	 */
	public int getIdCar() {
		return idCar;
	}

	/**
	 * @param idCar o idCar a ser configurado
	 */
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	/**
	 * @return o dailyCost
	 */
	public double getDailyCost() {
		return dailyCost;
	}

	/**
	 * @param dailyCost o dailyCost a ser configurado
	 */
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}
}