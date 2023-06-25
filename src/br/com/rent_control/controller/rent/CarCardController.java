package br.com.rent_control.controller.rent;

import java.awt.event.*;
import br.com.rent_control.view.rent.*;

/**
 * @author ayumi
 *
 */

public class CarCardController {
	
	public CarCardController(CarCardPanel carCardPanel) {
		carCardPanel.getSelectCarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carCardPanel.getMenuPanel().getContentPanel().removeAll();
				carCardPanel.getMenuPanel().getContentPanel().add(new StepOneRentScreen(carCardPanel.getFrameRentControl(), carCardPanel.getMenuPanel(), carCardPanel.getIdCar()));
				carCardPanel.getMenuPanel().getContentPanel().revalidate();
				carCardPanel.getMenuPanel().getContentPanel().repaint();
			}
		});
	}
}