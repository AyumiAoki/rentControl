package br.com.rent_control.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.com.rent_control.controller.AddCarController;
import br.com.rent_control.controller.RentControl;

public class AddCarScreen extends JPanel{
	private static final long serialVersionUID = 6407486089823829922L;
	
	private JTextField categoryField;
	private JTextField maxPassengersField;
	private JTextField trunkSizeField;
	private JTextField transmissionTypeField;
	private JTextField fuelTypeField;
	private JTextField hasAcField;
	private JTextField hasAirbagField;
	private JTextField hasAbsBrakesField;
	private JTextField hasDvdPlayerField;
	private JTextField dailyCostField;

	private JLabel messagerLabel;
	private JLabel categoryLabel;
	private JLabel maxPassengersLabel;
	private JLabel trunkSizeLabel;
	private JLabel transmissionTypeLabel;
	private JLabel fuelTypeLabel;
	private JLabel hasAcLabel;
	private JLabel hasAirbagLabel;
	private JLabel hasAbsBrakesLabel;
	private JLabel hasDvdPlayerLabel;
	private JLabel dailyCostLabel;
	
    private JButton addCarButton;
    
    private AddCarController addCarController;
    private final RentControl frameRentControl;
	
	private final Color COLOR_SECUNDARY = new Color(48, 46, 37);
    private final Color COLOR_PRIMARY = new Color(38, 135, 78);
	
	public AddCarScreen(final RentControl frameRentControl) {
		setLayout(null);
		setBackground(Color.white);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		addCarController = new AddCarController(this);
		this.frameRentControl = frameRentControl;
		
		messagerLabel = new JLabel("Cadastro de veículo");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setForeground(COLOR_PRIMARY);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));
		
		categoryLabel = new JLabel("Categoria");
		categoryLabel.setBounds(50, 104, 100, 15);
		categoryLabel.setForeground(COLOR_PRIMARY);
		categoryField = new JTextField();
		categoryField.setBounds(50,127,320,35);
		categoryField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		categoryField.setCaretColor(COLOR_SECUNDARY);
		categoryField.setEditable(true);
		
		maxPassengersLabel = new JLabel("Quantidade de passageiros");
		maxPassengersLabel.setBounds(394, 104, 320, 15);
		maxPassengersLabel.setForeground(COLOR_PRIMARY);
		maxPassengersField = new JTextField();
		maxPassengersField.setBounds(394,127,320,35);
		maxPassengersField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		maxPassengersField.setCaretColor(COLOR_SECUNDARY);
		maxPassengersField.setEditable(true);
		
		trunkSizeLabel = new JLabel("Volume do bagageiro (L)");
		trunkSizeLabel.setBounds(50, 178, 320, 15);
		trunkSizeLabel.setForeground(COLOR_PRIMARY);
		trunkSizeField = new JTextField();
		trunkSizeField.setBounds(50,201,320,35);
		trunkSizeField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		trunkSizeField.setCaretColor(COLOR_SECUNDARY);
		trunkSizeField.setEditable(true);
		
		transmissionTypeLabel = new JLabel("Tipo de câmbio");
		transmissionTypeLabel.setBounds(394, 178, 320, 15);
		transmissionTypeLabel.setForeground(COLOR_PRIMARY);
		transmissionTypeField = new JTextField();
		transmissionTypeField.setBounds(394,201,320,35);
		transmissionTypeField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		transmissionTypeField.setCaretColor(COLOR_SECUNDARY);
		transmissionTypeField.setEditable(true);
		
		fuelTypeLabel = new JLabel("Tipo de combustível");
		fuelTypeLabel.setBounds(50, 252, 320, 15);
		fuelTypeLabel.setForeground(COLOR_PRIMARY);
		fuelTypeField = new JTextField();
		fuelTypeField.setBounds(50,275,320,35);
		fuelTypeField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		fuelTypeField.setCaretColor(COLOR_SECUNDARY);
		fuelTypeField.setEditable(true);
		
		dailyCostLabel = new JLabel("Custo diário");
		dailyCostLabel.setBounds(394, 252, 320, 15);
		dailyCostLabel.setForeground(COLOR_PRIMARY);
		dailyCostField = new JTextField();
		dailyCostField.setBounds(394,275,320,35);
		dailyCostField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		dailyCostField.setCaretColor(COLOR_SECUNDARY);
		dailyCostField.setEditable(true);
		
		hasAcLabel = new JLabel("Possui ar condicionado (sim ou nao)");
		hasAcLabel.setBounds(50, 326, 320, 15);
		hasAcLabel.setForeground(COLOR_PRIMARY);
		hasAcField = new JTextField();
		hasAcField.setBounds(50,349,320,35);
		hasAcField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		hasAcField.setCaretColor(COLOR_SECUNDARY);
		hasAcField.setEditable(true);
		
		hasAirbagLabel = new JLabel("Possui airbag (sim ou nao)");
		hasAirbagLabel.setBounds(394, 326, 320, 15);
		hasAirbagLabel.setForeground(COLOR_PRIMARY);
		hasAirbagField = new JTextField();
		hasAirbagField.setBounds(394,349,320,35);
		hasAirbagField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		hasAirbagField.setCaretColor(COLOR_SECUNDARY);
		hasAirbagField.setEditable(true);
		
		hasAbsBrakesLabel = new JLabel("Possui freio abs (sim ou nao)");
		hasAbsBrakesLabel.setBounds(50, 400, 320, 15);
		hasAbsBrakesLabel.setForeground(COLOR_PRIMARY);
		hasAbsBrakesField = new JTextField();
		hasAbsBrakesField.setBounds(50,423,320,35);
		hasAbsBrakesField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		hasAbsBrakesField.setCaretColor(COLOR_SECUNDARY);
		hasAbsBrakesField.setEditable(true);
		
		hasDvdPlayerLabel = new JLabel("Possui dvd (sim ou nao)");
		hasDvdPlayerLabel.setBounds(394, 400, 320, 15);
		hasDvdPlayerLabel.setForeground(COLOR_PRIMARY);
		hasDvdPlayerField = new JTextField();
		hasDvdPlayerField.setBounds(394,423,320,35);
		hasDvdPlayerField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, COLOR_SECUNDARY));
		hasDvdPlayerField.setCaretColor(COLOR_SECUNDARY);
		hasDvdPlayerField.setEditable(true);
		
		addCarButton = new JButton("Cadastrar");
		addCarButton.setForeground(Color.WHITE);
		addCarButton.setBounds(266, 554, 240, 35);
		addCarButton.setBackground(COLOR_PRIMARY);
		addCarButton.setBorder(null);
		
		add(messagerLabel);
		add(categoryLabel);
		add(categoryField);
		add(maxPassengersLabel);
		add(maxPassengersField);
		add(trunkSizeLabel);
		add(trunkSizeField);
		add(transmissionTypeLabel);
		add(transmissionTypeField);
		add(fuelTypeLabel);
		add(fuelTypeField);
		add(dailyCostLabel);
		add(dailyCostField);
		add(hasAcLabel);
		add(hasAcField);
		add(hasAirbagLabel);
		add(hasAirbagField);
		add(hasAbsBrakesLabel);
		add(hasAbsBrakesField);
		add(hasDvdPlayerLabel);
		add(hasDvdPlayerField);
		add(addCarButton);
		
		addCarButton.addActionListener(e -> addCarController.addCarButtonClicked());
	}

	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return o categoryField
	 */
	public JTextField getCategoryField() {
		return categoryField;
	}

	/**
	 * @return o maxPassengersField
	 */
	public JTextField getMaxPassengersField() {
		return maxPassengersField;
	}

	/**
	 * @return o trunkSizeField
	 */
	public JTextField getTrunkSizeField() {
		return trunkSizeField;
	}

	/**
	 * @return o transmissionTypeField
	 */
	public JTextField getTransmissionTypeField() {
		return transmissionTypeField;
	}

	/**
	 * @return o fuelTypeField
	 */
	public JTextField getFuelTypeField() {
		return fuelTypeField;
	}

	/**
	 * @return o hasAcField
	 */
	public JTextField getHasAcField() {
		return hasAcField;
	}

	/**
	 * @return o hasAirbagField
	 */
	public JTextField getHasAirbagField() {
		return hasAirbagField;
	}

	/**
	 * @return o hasAbsBrakesField
	 */
	public JTextField getHasAbsBrakesField() {
		return hasAbsBrakesField;
	}

	/**
	 * @return o hasDvdPlayerField
	 */
	public JTextField getHasDvdPlayerField() {
		return hasDvdPlayerField;
	}

	/**
	 * @return o dailyCostField
	 */
	public JTextField getDailyCostField() {
		return dailyCostField;
	}
}