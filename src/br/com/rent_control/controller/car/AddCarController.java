/**
 * 
 */
package br.com.rent_control.controller.car;

import java.util.*;
import br.com.rent_control.view.*;
import br.com.rent_control.view.car.AddCarScreen;
import br.com.rent_control.view.car.CarManagementScreen;

import javax.swing.JOptionPane;
import br.com.rent_control.model.bo.CarBo;

/**
 * @author ayumi
 *
 */

public class AddCarController {

	private AddCarScreen addCarScreen;
	private CarBo carBo;

	public AddCarController(AddCarScreen addCarScreen) {
		this.addCarScreen = addCarScreen;
		carBo = new CarBo();
	}

	public void addCarButtonClicked() {
		String category = addCarScreen.getCategoryField().getComboBox().getSelectedItem().toString();
		String modelCar = addCarScreen.getModelCarField().getTextField().getText();
		String maxPassengers = addCarScreen.getMaxPassengersField().getComboBox().getSelectedItem().toString();
		String trunkSize = addCarScreen.getTrunkSizeField().getTextField().getText();
		String transmissionType = addCarScreen.getTransmissionTypeField().getComboBox().getSelectedItem().toString();
		String fuelType = addCarScreen.getFuelTypeField().getComboBox().getSelectedItem().toString();
		String consumptionAverage = addCarScreen.getConsumptionAverageField().getTextField().getText();
		String dailyCost = addCarScreen.getDailyCostField().getTextField().getText();
		String hasAc = addCarScreen.getHasAcField().getComboBox().getSelectedItem().toString();
		String hasAirbag = addCarScreen.getHasAirbagField().getComboBox().getSelectedItem().toString();
		String hasAbsBrakes = addCarScreen.getHasAbsBrakesField().getComboBox().getSelectedItem().toString();
		String hasDvdPlayer = addCarScreen.getHasDvdPlayerField().getComboBox().getSelectedItem().toString();

		if (!category.equals("") && !maxPassengers.equals("") && !trunkSize.equals("") && !transmissionType.equals("")
				&& !fuelType.equals("") && !dailyCost.equals("") && !hasAbsBrakes.equals("") && !hasAc.equals("")
				&& !hasAirbag.equals("") && !hasAbsBrakes.equals("") && !hasDvdPlayer.equals("")) {
			List<String> listCar = Arrays.asList(category, modelCar, maxPassengers, trunkSize, transmissionType,
					fuelType, consumptionAverage, dailyCost, hasAc, hasAirbag, hasAbsBrakes, hasDvdPlayer);
			
			if(carBo.addCar(listCar.toArray(new String[0]))) {
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
				
				addCarScreen.getModelCarField().setText("");

				addCarScreen.getMenuPanel().getContentPanel().removeAll();
				addCarScreen.getMenuPanel().getContentPanel().add( new CarManagementScreen(addCarScreen.getFrameRentControl(), addCarScreen.getMenuPanel()));
				addCarScreen.getMenuPanel().getContentPanel().revalidate();
				addCarScreen.getMenuPanel().getContentPanel().repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}
