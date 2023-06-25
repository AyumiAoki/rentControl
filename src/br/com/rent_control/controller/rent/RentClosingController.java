/**
 * 
 */
package br.com.rent_control.controller.rent;

import javax.swing.JOptionPane;

import br.com.rent_control.model.dao.RentDao;
import br.com.rent_control.view.rent.*;

/**
 * @author ayumi
 *
 */

public class RentClosingController {

	private RentClosing rentClosing;
	private RentDao rentDao;

	public RentClosingController(RentClosing rentClosing) {
		this.rentClosing = rentClosing;
		rentDao = new RentDao();
	}

	public void rentButtonClicked() {
		if(rentDao.rentVehicle(rentClosing.getRent())) {
			JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação!");
		}
		
		rentClosing.getMenuPanel().getContentPanel().removeAll();
		rentClosing.getMenuPanel().getContentPanel()
				.add(new RentalScreen(rentClosing.getFrameRentControl(), rentClosing.getMenuPanel()));
		rentClosing.getMenuPanel().getContentPanel().revalidate();
		rentClosing.getMenuPanel().getContentPanel().repaint();
	}
}