package br.com.rent_control.controller.rent;

import javax.swing.JToggleButton;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalButtonUI;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.rent.RentClosing;
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
		eventsButton(stepTwoRentScreen.getAdditionalButtonSix());
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
		boolean additionalSix = stepTwoRentScreen.getAdditionalButtonSix().isSelected();
		
		stepTwoRentScreen.getRent().setCarProtection(additionalOne);
		stepTwoRentScreen.getRent().setGps(additionalTwo);
		stepTwoRentScreen.getRent().setCleaning(additionalThree);
		stepTwoRentScreen.getRent().setDrinkComfort(additionalFour);
		stepTwoRentScreen.getRent().setBabyChair(additionalFive);
		stepTwoRentScreen.getRent().setBoosterSeat(additionalSix);
		
		stepTwoRentScreen.getMenuPanel().getContentPanel().removeAll();
		stepTwoRentScreen.getMenuPanel().getContentPanel().add(new RentClosing(stepTwoRentScreen.getFrameRentControl(), stepTwoRentScreen.getMenuPanel(), stepTwoRentScreen.getRent(), stepTwoRentScreen.getDailyAmount(), stepTwoRentScreen.getDailyCost()));
		stepTwoRentScreen.getMenuPanel().getContentPanel().revalidate();
		stepTwoRentScreen.getMenuPanel().getContentPanel().repaint();
	}
}