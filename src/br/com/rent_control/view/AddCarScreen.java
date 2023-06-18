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
		
	public AddCarScreen(final RentControl frameRentControl) {
		setLayout(null);
		setBackground(Color.white);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		addCarController = new AddCarController(this);
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
}