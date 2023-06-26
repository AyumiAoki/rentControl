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

	private RentClosingScreen rentClosingScreen;
	private RentDao rentDao;

	public RentClosingController(RentClosingScreen rentClosingScreen) {
		this.rentClosingScreen = rentClosingScreen;
		rentDao = new RentDao();
	}

	public void rentButtonClicked() {
		if (rentClosingScreen.getRentButton().getText().equals("Finalizar aluguel")) {
			if (rentDao.rentVehicle(rentClosingScreen.getRent())) {
				JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação!");
			}
		} else {
			if (rentDao.updateRent(rentClosingScreen.getRent())) {
				JOptionPane.showMessageDialog(null, "Locação atualizada com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível atualizar a locação!");
			}
		}

		rentClosingScreen.getMenuPanel().getContentPanel().removeAll();
		rentClosingScreen.getMenuPanel().getContentPanel().add(
				new RentManagementScreen(rentClosingScreen.getFrameRentControl(), rentClosingScreen.getMenuPanel()));
		rentClosingScreen.getMenuPanel().getContentPanel().revalidate();
		rentClosingScreen.getMenuPanel().getContentPanel().repaint();
	}
}