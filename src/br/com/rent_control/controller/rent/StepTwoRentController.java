package br.com.rent_control.controller.rent;

import javax.swing.JToggleButton;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalButtonUI;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.rent.StepTwoRentScreen;

/**
 * @author ayumi
 *
 */

public class StepTwoRentController {

	private StepTwoRentScreen stepTwoRentScreen;

	public StepTwoRentController(StepTwoRentScreen stepTwoRentScreen) {
		this.stepTwoRentScreen = stepTwoRentScreen;

		eventsButton(stepTwoRentScreen.getAdditionalButtonOne());
		eventsButton(stepTwoRentScreen.getAdditionalButtonTwo());
		eventsButton(stepTwoRentScreen.getAdditionalButtonThree());
		eventsButton(stepTwoRentScreen.getAdditionalButtonFour());
		eventsButton(stepTwoRentScreen.getAdditionalButtonFive());
	}
	
	public void eventsButton(JToggleButton toggleButton) {
		toggleButton.setUI(new MetalButtonUI() {
			@Override
			protected ColorUIResource getSelectColor() {
				return null;
			}
		});

		toggleButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Border border;
				if (toggleButton.isSelected()) {
					border = new LineBorder(ColorUtils.PRIMARY_COLOR, 2);
				} else {
					border = new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2);
				}
				toggleButton.setBorder(border);
			}
		});
	}

	public void proceedButtonClicked() {
		boolean additionalOne = stepTwoRentScreen.getAdditionalButtonOne().isSelected();
		boolean additionalTwo = stepTwoRentScreen.getAdditionalButtonTwo().isSelected();
		boolean additionalThree = stepTwoRentScreen.getAdditionalButtonThree().isSelected();
		boolean additionalFour = stepTwoRentScreen.getAdditionalButtonFour().isSelected();
		boolean additionalFive = stepTwoRentScreen.getAdditionalButtonFive().isSelected();
		
//		if (!category.equals("") && !maxPassengers.equals("") && !trunkSize.equals("") && !transmissionType.equals("")
//				&& !fuelType.equals("") && !dailyCost.equals("") && !hasAbsBrakes.equals("") && !hasAc.equals("")
//				&& !hasAirbag.equals("") && !hasAbsBrakes.equals("") && !hasDvdPlayer.equals("")) {
//			List<String> listCar = Arrays.asList(category, modelCar, maxPassengers, trunkSize, transmissionType,
//					fuelType, consumptionAverage, dailyCost, hasAc, hasAirbag, hasAbsBrakes, hasDvdPlayer);
//			
//			if(carBo.addCar(listCar.toArray(new String[0]))) {
//				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
//				
//				addCarScreen.getModelCarField().setText("");
//
//				addCarScreen.getMenuPanel().getContentPanel().removeAll();
//				addCarScreen.getMenuPanel().getContentPanel().add( new CarManagementScreen(addCarScreen.getFrameRentControl(), addCarScreen.getMenuPanel()));
//				addCarScreen.getMenuPanel().getContentPanel().revalidate();
//				addCarScreen.getMenuPanel().getContentPanel().repaint();
//			} else {
//				JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo!");
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
//		}
	}
}