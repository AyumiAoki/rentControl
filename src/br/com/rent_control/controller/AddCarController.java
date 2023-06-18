/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.view.AddCarScreen;
import br.com.rent_control.view.ContentPanel;

/**
 * @author ayumi
 *
 */

public class AddCarController {

	private AddCarScreen addCarScreen;
	private CarDao carDao;
	private Car car;

	public AddCarController(AddCarScreen addCarScreen) {
		this.addCarScreen = addCarScreen;
		carDao = new CarDao();
		car = new Car();
	}

	public void addCarButtonClicked() {
		//String category = addCarScreen.getCategoryField().getText();
		int maxPassengers = (addCarScreen.getMaxPassengersField().getText().equals("") ? 0 : Integer.parseInt(addCarScreen.getMaxPassengersField().getText()));
		double trunkSize = (addCarScreen.getTrunkSizeField().getText().equals("") ? 0 : Double.parseDouble(addCarScreen.getTrunkSizeField().getText()));
		String transmissionType = addCarScreen.getTransmissionTypeField().getText();
		String fuelType = addCarScreen.getFuelTypeField().getText();
		double dailyCost = (addCarScreen.getDailyCostField().getText().equals("") ? 0 : Double.parseDouble(addCarScreen.getDailyCostField().getText()));
		String hasAc = addCarScreen.getHasAcField().getText();
		String hasAirbag = addCarScreen.getHasAirbagField().getText();
		String hasAbsBrakes = addCarScreen.getHasAbsBrakesField().getText();
		String hasDvdPlayer = addCarScreen.getHasDvdPlayerField().getText();
		
		if (maxPassengers != 0 && trunkSize != 0 && transmissionType.equals("")
				&& fuelType.equals("") && dailyCost != 0 && hasAbsBrakes.equals("") && hasAc.equals("")
				&& hasAirbag.equals("") && hasAbsBrakes.equals("") && hasDvdPlayer.equals("")) {
			//car.setCategory(category);
			car.setMaxPassengers(maxPassengers);
			car.setTrunkSize(trunkSize);
			car.setTransmissionType(transmissionType);
			car.setFuelType(fuelType);
			car.setDailyCost(dailyCost);
			car.setHasAc(addCarScreen.getHasAcField().getText().equals("sim") ? true : false);
			car.setHasAirbag(addCarScreen.getHasAirbagField().getText().equals("sim") ? true : false);
			car.setHasAbsBrakes(addCarScreen.getHasAbsBrakesField().getText().equals("sim") ? true : false);
			car.setHasDvdPlayer(addCarScreen.getHasDvdPlayerField().getText().equals("sim") ? true : false);

			boolean added = carDao.addCar(car);
			
			if(added) {
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");

				addCarScreen.setVisible(false);

				ContentPanel contentPanel = new ContentPanel();
				addCarScreen.getFrameRentControl().add(contentPanel, BorderLayout.CENTER);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}
