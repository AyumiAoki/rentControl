/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.rent_control.view.CarManagementScreen;
import br.com.rent_control.view.customer.CreateCustomerScreen;

/**
 * @author ayumi
 *
 */
public class CarManagementController {

	/**
	 * 
	 */
	public CarManagementController(CarManagementScreen carManagementScreen) {
		carManagementScreen.getNewCustomer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carManagementScreen.getMenuPanel().getContentPanel().removeAll();
				carManagementScreen.getMenuPanel().getContentPanel().add(new CreateCustomerScreen());
				carManagementScreen.getMenuPanel().getContentPanel().revalidate();
				carManagementScreen.getMenuPanel().getContentPanel().repaint();
			}
		});
	}
}