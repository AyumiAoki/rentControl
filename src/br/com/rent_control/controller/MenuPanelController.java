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
		
		menuPanelScreen.getBooKCarButton().getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanelScreen.getContentPanel().removeAll();

				RentalScreen rentalScreen = new RentalScreen();
				menuPanelScreen.getContentPanel().add(rentalScreen);

				menuPanelScreen.getContentPanel().revalidate();
				menuPanelScreen.getContentPanel().repaint();
				
				menuPanelScreen.getBooKCarButton().getButton().setBackground(COLOR_PRIMARY_DARK);
				
                if (selectedButton != null) {
                    selectedButton.setBackground(COLOR_PRIMARY);
                }

                selectedButton = menuPanelScreen.getBooKCarButton().getButton();
			}
		});
		
		menuPanelScreen.getBooKCarButton().getButton().addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				menuPanelScreen.getBooKCarButton().getButton().setBackground(COLOR_PRIMARY_DARK);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelScreen.getBooKCarButton().getButton().setBackground(COLOR_PRIMARY_DARK);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedButton != menuPanelScreen.getBooKCarButton().getButton()) {
                    menuPanelScreen.getBooKCarButton().getButton().setBackground(COLOR_PRIMARY);
                }
			}
		});
		
//		menuPanelScreen.getAddCarButton().addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				menuPanelScreen.getContentPanel().removeAll();
//
//				AddCarScreen addCarScreen = new AddCarScreen(menuPanelScreen.getFrameRentControl());
//				menuPanelScreen.getContentPanel().add(addCarScreen);
//
//				menuPanelScreen.getContentPanel().revalidate();
//				menuPanelScreen.getContentPanel().repaint();
//				
//				menuPanelScreen.getAddCarButton().setBackground(COLOR_PRIMARY_DARK);
//				
//				if (selectedButton != null) {
//                    selectedButton.setBackground(COLOR_PRIMARY);
//                }
//				
//				selectedButton = menuPanelScreen.getAddCarButton();
//			}
//		});
//		
//		menuPanelScreen.getAddCarButton().addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				menuPanelScreen.getAddCarButton().setBackground(COLOR_PRIMARY_DARK);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if (selectedButton != menuPanelScreen.getAddCarButton()) {
//                    menuPanelScreen.getAddCarButton().setBackground(COLOR_PRIMARY);
//                }
//			}
//		});
		
	}
}