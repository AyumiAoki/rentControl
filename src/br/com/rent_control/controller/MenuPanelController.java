/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.*;
import javax.swing.border.LineBorder;

import br.com.rent_control.view.*;
import br.com.rent_control.view.components.OptionsMenuButton;

/**
 * Class MenuPanelController - Represents the menu panel screen control in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanelController {

	private MenuPanel menuPanelScreen;
	private OptionsMenuButton buttonSelect;
	
	/**
	 * Class constructor with parameters.
	 * @param menuPanelScreen
	 */
	public MenuPanelController(MenuPanel menuPanelScreen) {
		this.menuPanelScreen = menuPanelScreen;
		buttonSelect = null;
	}
	
	public void changeScreen(OptionsMenuButton button, Component component) {
		menuPanelScreen.getContentPanel().removeAll();
        menuPanelScreen.getContentPanel().add(component);
        menuPanelScreen.getContentPanel().revalidate();
        menuPanelScreen.getContentPanel().repaint();
        if(buttonSelect == null) {
    		button.getButton().setBorder(new LineBorder(Color.WHITE, 1));  
    		buttonSelect = button;
        } else {
        	buttonSelect.getButton().setBorder(null);
        	button.getButton().setBorder(new LineBorder(Color.WHITE, 1));  
        	buttonSelect = button;
        }
	}
}