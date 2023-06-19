package br.com.rent_control.view;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import br.com.rent_control.controller.AddCarController;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomField;

public class AddCarScreen extends JPanel{
	private static final long serialVersionUID = 6407486089823829922L;

	private CustomField messagerField;
	private CustomField categoryField;
	private CustomField modelCarField;
	private CustomField maxPassengersField;
	private CustomField trunkSizeField;
	private CustomField transmissionTypeField;
	private CustomField fuelTypeField;
	private CustomField consumptionAverageField;
	private CustomField dailyCostField;
	private CustomField hasAcField;
	private CustomField hasAirbagField;
	private CustomField hasAbsBrakesField;
	private CustomField hasDvdPlayerField;
	
    private JButton addCarButton;
    
    private AddCarController addCarController;
    private final RentControl frameRentControl;
    private final MenuPanel menuPanel;
		
	public AddCarScreen(final RentControl frameRentControl, final MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		addCarController = new AddCarController(this);
		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		
		messagerField = new CustomField("Cadastro de veículo");
		categoryField = new CustomField("Categoria", 111, 92, getCategoryOptions());
		modelCarField = new CustomField("Modelo", 455, 92);
		maxPassengersField = new CustomField("Quantidade de passageiros", 111, 182, getMaxPassengersOptions());
		trunkSizeField = new CustomField("Volume do porta malas (L)", 455, 182);
		transmissionTypeField = new CustomField("Tipo de câmbio", 111, 272, getTransmissionTypeOptions());
		fuelTypeField = new CustomField("Tipo de combustível", 455, 272, getFuelTypeOptions()); 
		consumptionAverageField = new CustomField("Média de consumo (Km/L)", 111, 362); 
		dailyCostField = new CustomField("Custo diário", 455, 362); 
		hasAcField = new CustomField("Possui ar condicionado?", 111, 452, getHasOptions()); 
		hasAirbagField = new CustomField("Possui airbag?", 455, 452, getHasOptions()); 
		hasAbsBrakesField = new CustomField("Possui freio abs?", 111, 542, getHasOptions()); 
		hasDvdPlayerField = new CustomField("Possui dvd ?", 455, 542, getHasOptions()); 
		
		addCarButton = new JButton("Cadastrar");
		addCarButton.setForeground(Color.WHITE);
		addCarButton.setBounds(323, 632, 240, 35);
		addCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		addCarButton.setBorder(null);
		
		add(messagerField.getLabel());
		add(categoryField.getLabel());
		add(categoryField.getComboBox());
		add(modelCarField.getLabel());
		add(modelCarField.getTextField());
		add(maxPassengersField.getLabel());
		add(maxPassengersField.getComboBox());
		add(trunkSizeField.getLabel());
		add(trunkSizeField.getTextField());
		add(transmissionTypeField.getLabel());
		add(transmissionTypeField.getComboBox());
		add(fuelTypeField.getLabel());
		add(fuelTypeField.getComboBox());
		add(consumptionAverageField.getLabel());
		add(consumptionAverageField.getTextField());
		add(dailyCostField.getLabel());
		add(dailyCostField.getTextField());
		add(hasAcField.getLabel());
		add(hasAcField.getComboBox());
		add(hasAirbagField.getLabel());
		add(hasAirbagField.getComboBox());
		add(hasAbsBrakesField.getLabel());
		add(hasAbsBrakesField.getComboBox());
		add(hasDvdPlayerField.getLabel());
		add(hasDvdPlayerField.getComboBox());
		add(addCarButton);
		
		addCarButton.addActionListener(e -> addCarController.addCarButtonClicked());
	}
	
	/**************Options ComboBox**************/
	private String[] getCategoryOptions() {
        List<String> options = Arrays.asList("Compacto", "Standard", "Grande", "Econômico", "Premium", "Minivan");
        return options.toArray(new String[0]);
    }
	
	private String[] getMaxPassengersOptions() {
        List<String> options = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        return options.toArray(new String[0]);
    }
	
	private String[] getTransmissionTypeOptions() {
        List<String> options = Arrays.asList("Manual", "Automático");
        return options.toArray(new String[0]);
    }
	
	private String[] getFuelTypeOptions() {
        List<String> options = Arrays.asList("Gasolina", "Diesel", "Etanol", "Hibrido");
        return options.toArray(new String[0]);
    }
	
	private String[] getHasOptions() {
        List<String> options = Arrays.asList("Sim", "Não");
        return options.toArray(new String[0]);
    }
	/**************End Options ComboBox**************/
	
	/**************Getters e setters**************/
	/**
	 * @return o messagerField
	 */
	public CustomField getMessagerField() {
		return messagerField;
	}

	/**
	 * @param messagerField o messagerField a ser configurado
	 */
	public void setMessagerField(CustomField messagerField) {
		this.messagerField = messagerField;
	}

	/**
	 * @return o categoryField
	 */
	public CustomField getCategoryField() {
		return categoryField;
	}

	/**
	 * @param categoryField o categoryField a ser configurado
	 */
	public void setCategoryField(CustomField categoryField) {
		this.categoryField = categoryField;
	}

	/**
	 * @return o modelCarField
	 */
	public CustomField getModelCarField() {
		return modelCarField;
	}

	/**
	 * @param modelCarField o modelCarField a ser configurado
	 */
	public void setModelCarField(CustomField modelCarField) {
		this.modelCarField = modelCarField;
	}

	/**
	 * @return o maxPassengersField
	 */
	public CustomField getMaxPassengersField() {
		return maxPassengersField;
	}

	/**
	 * @param maxPassengersField o maxPassengersField a ser configurado
	 */
	public void setMaxPassengersField(CustomField maxPassengersField) {
		this.maxPassengersField = maxPassengersField;
	}

	/**
	 * @return o trunkSizeField
	 */
	public CustomField getTrunkSizeField() {
		return trunkSizeField;
	}

	/**
	 * @param trunkSizeField o trunkSizeField a ser configurado
	 */
	public void setTrunkSizeField(CustomField trunkSizeField) {
		this.trunkSizeField = trunkSizeField;
	}

	/**
	 * @return o transmissionTypeField
	 */
	public CustomField getTransmissionTypeField() {
		return transmissionTypeField;
	}

	/**
	 * @param transmissionTypeField o transmissionTypeField a ser configurado
	 */
	public void setTransmissionTypeField(CustomField transmissionTypeField) {
		this.transmissionTypeField = transmissionTypeField;
	}

	/**
	 * @return o fuelTypeField
	 */
	public CustomField getFuelTypeField() {
		return fuelTypeField;
	}

	/**
	 * @param fuelTypeField o fuelTypeField a ser configurado
	 */
	public void setFuelTypeField(CustomField fuelTypeField) {
		this.fuelTypeField = fuelTypeField;
	}

	/**
	 * @return o consumptionAverageField
	 */
	public CustomField getConsumptionAverageField() {
		return consumptionAverageField;
	}

	/**
	 * @param consumptionAverageField o consumptionAverageField a ser configurado
	 */
	public void setConsumptionAverageField(CustomField consumptionAverageField) {
		this.consumptionAverageField = consumptionAverageField;
	}

	/**
	 * @return o dailyCostField
	 */
	public CustomField getDailyCostField() {
		return dailyCostField;
	}

	/**
	 * @param dailyCostField o dailyCostField a ser configurado
	 */
	public void setDailyCostField(CustomField dailyCostField) {
		this.dailyCostField = dailyCostField;
	}

	/**
	 * @return o hasAcField
	 */
	public CustomField getHasAcField() {
		return hasAcField;
	}

	/**
	 * @param hasAcField o hasAcField a ser configurado
	 */
	public void setHasAcField(CustomField hasAcField) {
		this.hasAcField = hasAcField;
	}

	/**
	 * @return o hasAirbagField
	 */
	public CustomField getHasAirbagField() {
		return hasAirbagField;
	}

	/**
	 * @param hasAirbagField o hasAirbagField a ser configurado
	 */
	public void setHasAirbagField(CustomField hasAirbagField) {
		this.hasAirbagField = hasAirbagField;
	}

	/**
	 * @return o hasAbsBrakesField
	 */
	public CustomField getHasAbsBrakesField() {
		return hasAbsBrakesField;
	}

	/**
	 * @param hasAbsBrakesField o hasAbsBrakesField a ser configurado
	 */
	public void setHasAbsBrakesField(CustomField hasAbsBrakesField) {
		this.hasAbsBrakesField = hasAbsBrakesField;
	}

	/**
	 * @return o hasDvdPlayerField
	 */
	public CustomField getHasDvdPlayerField() {
		return hasDvdPlayerField;
	}

	/**
	 * @param hasDvdPlayerField o hasDvdPlayerField a ser configurado
	 */
	public void setHasDvdPlayerField(CustomField hasDvdPlayerField) {
		this.hasDvdPlayerField = hasDvdPlayerField;
	}

	/**
	 * @return o addCarButton
	 */
	public JButton getAddCarButton() {
		return addCarButton;
	}

	/**
	 * @param addCarButton o addCarButton a ser configurado
	 */
	public void setAddCarButton(JButton addCarButton) {
		this.addCarButton = addCarButton;
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
	
	/**************End Getters e setters**************/	
}