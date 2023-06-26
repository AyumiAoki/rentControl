package br.com.rent_control.controller.rent;

import java.awt.event.*;
import br.com.rent_control.view.rent.*;

/**
 * @author ayumi
 *
 */

public class RentManagementController {
	public RentManagementController(RentManagementScreen rentManagementScreen) {
		rentManagementScreen.getNewRent().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rentManagementScreen.getMenuPanel().getContentPanel().removeAll();
				rentManagementScreen.getMenuPanel().getContentPanel().add(new RentalScreen(rentManagementScreen.getFrameRentControl(), rentManagementScreen.getMenuPanel()));
				rentManagementScreen.getMenuPanel().getContentPanel().revalidate();
				rentManagementScreen.getMenuPanel().getContentPanel().repaint();
			}
		});
	}
}