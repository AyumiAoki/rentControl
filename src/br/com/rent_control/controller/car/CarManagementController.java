package br.com.rent_control.controller.car;

import java.awt.event.*;
import br.com.rent_control.view.*;
import br.com.rent_control.view.car.AddCarScreen;
import br.com.rent_control.view.car.CarManagementScreen;

/**
 * @author ayumi
 *
 */
public class CarManagementController {

	/**
	 * 
	 */
	public CarManagementController(CarManagementScreen carManagementScreen) {
		carManagementScreen.getNewCar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carManagementScreen.getMenuPanel().getContentPanel().removeAll();
				carManagementScreen.getMenuPanel().getContentPanel().add(new AddCarScreen(
						carManagementScreen.getFrameRentControl(), carManagementScreen.getMenuPanel()));
				carManagementScreen.getMenuPanel().getContentPanel().revalidate();
				carManagementScreen.getMenuPanel().getContentPanel().repaint();
			}
		});
	}
}
