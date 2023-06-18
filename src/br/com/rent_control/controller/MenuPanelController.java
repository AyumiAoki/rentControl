/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private final Color COLOR_PRIMARY;
	private final Color COLOR_PRIMARY_DARK;
    private JButton selectedButton;
	
	/**
	 * Class constructor with parameters.
	 * @param menuPanelScreen
	 */
	public MenuPanelController(MenuPanel menuPanelScreen) {
		this.menuPanelScreen = menuPanelScreen;
		
		COLOR_PRIMARY = new Color(38, 135, 78);
		COLOR_PRIMARY_DARK = new Color(0, 102, 51);
		selectedButton = null;
		
		changeScreen(menuPanelScreen.getBooKCarButton(), new RentalScreen());
		changeScreen(menuPanelScreen.getAddCarButton(), new AddCarScreen(menuPanelScreen.getFrameRentControl()));
		changeScreen(menuPanelScreen.getCustomerButton(), new CustomerManagementScreen(menuPanelScreen.getFrameRentControl()));
		
	}
	
	private void changeScreen(OptionsMenuButton button, Component component) {
		button.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanelScreen.getContentPanel().removeAll();
				menuPanelScreen.getContentPanel().add(component);
				menuPanelScreen.getContentPanel().revalidate();
				menuPanelScreen.getContentPanel().repaint();
				button.getButton().setBackground(COLOR_PRIMARY_DARK);
				if (selectedButton != null) {
		            selectedButton.setBackground(COLOR_PRIMARY);
		        }	
				selectedButton = button.getButton();
			}
		});
		
		button.getButton().addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				button.getButton().setBackground(COLOR_PRIMARY_DARK);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				button.getButton().setBackground(COLOR_PRIMARY_DARK);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedButton != button.getButton()) {
					button.getButton().setBackground(COLOR_PRIMARY);
                }
			}
		});
		
	}
}