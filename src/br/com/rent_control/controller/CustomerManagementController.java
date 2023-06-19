package br.com.rent_control.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.rent_control.view.customer.CreateCustomerScreen;
import br.com.rent_control.view.customer.CustomerManagementScreen;

public class CustomerManagementController {
	public CustomerManagementController(CustomerManagementScreen customerManagementScreen) {
		customerManagementScreen.getNewCustomer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerManagementScreen.getMenuPanel().getContentPanel().removeAll();
				customerManagementScreen.getMenuPanel().getContentPanel().add(new CreateCustomerScreen());
				customerManagementScreen.getMenuPanel().getContentPanel().revalidate();
				customerManagementScreen.getMenuPanel().getContentPanel().repaint();
			}
		});
	}
}