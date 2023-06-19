/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.rent_control.view.*;
import br.com.rent_control.view.components.OptionsMenuButton;
import br.com.rent_control.view.customer.CustomerManagementScreen;

/**
 * Class MenuPanelController - Represents the menu panel screen control in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanelController {

	@SuppressWarnings("unused")
	private MenuPanel menuPanelScreen;
    private JButton selectedButton;
	
	/**
	 * Class constructor with parameters.
	 * @param menuPanelScreen
	 */
	public MenuPanelController(MenuPanel menuPanelScreen) {
		this.menuPanelScreen = menuPanelScreen;
		
		selectedButton = null;
		
		changeScreen(menuPanelScreen.getBooKCarButton(), new RentalScreen());
		changeScreen(menuPanelScreen.getAddCarButton(), new CarManagementScreen(menuPanelScreen.getFrameRentControl(), menuPanelScreen));
		changeScreen(menuPanelScreen.getCustomerButton(), new CustomerManagementScreen(menuPanelScreen.getFrameRentControl(), menuPanelScreen));
		
	}
	
	private void changeScreen(OptionsMenuButton button, Component component) {
		button.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanelScreen.getContentPanel().removeAll();
				menuPanelScreen.getContentPanel().add(component);
				menuPanelScreen.getContentPanel().revalidate();
				menuPanelScreen.getContentPanel().repaint();
				button.setImagePath("src/br/com/rent_control/view/images/iconRentalButton");
				button.getButton().setIcon(new ImageIcon("src/br/com/rent_control/view/images/iconRentalButton"));
//				if (selectedButton != null) {
//		            selectedButton.setIcon(new ImageIcon("src/br/com/rent_control/view/images/iconRentalButtonSelected"));
//		        }	
//				selectedButton = button.getButton();
			}
		});
		
//		button.getButton().addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent e) {
//				//button.getButton().setIcon(new ImageIcon("src/br/com/rent_control/view/images/iconRentalButton"));;
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				//button.getButton().setIcon(new ImageIcon("src/br/com/rent_control/view/images/iconRentalButton"));;
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if (selectedButton != button.getButton()) {
//					//button.getButton().setIcon(new ImageIcon("src/br/com/rent_control/view/images/iconRentalButtonSelected"));
//                }
//			}
//		});
	}
}