package br.com.rent_control.view;

import javax.swing.*;
import java.awt.*;
import br.com.rent_control.controller.MenuPanelController;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.car.CarManagementScreen;
import br.com.rent_control.view.components.OptionsMenuButton;
import br.com.rent_control.view.customer.CustomerManagementScreen;
import br.com.rent_control.view.rent.RentalScreen;

/**
 * Class MenuPanel - Represents the menu panel containing the buttons with the
 * application's functionalitiesRepresents the menu panel containing the buttons
 * with the application's functionalities
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = -9049365368368708163L;

	private RentControl frameRentControl;
	private ContentPanel contentPanel;
	private MenuPanelController menuPanelControl;

	private OptionsMenuButton booKCarButton;
	private OptionsMenuButton addCarButton;
	private OptionsMenuButton customerButton;

	private final ImageIcon backgroundPanelMenu;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param frameRentControl
	 * @param contentPanel
	 */
	public MenuPanel(final RentControl frameRentControl, ContentPanel contentPanel) {
		setLayout(null);
		setPreferredSize(new Dimension(200, this.getPreferredSize().height));

		this.frameRentControl = frameRentControl;
		this.contentPanel = contentPanel;

		backgroundPanelMenu = new ImageIcon(
				getClass().getResource("/br/com/rent_control/view/images/backgroundPanelMenu.png"));

		customerButton = new OptionsMenuButton("iconUserButton.png", 75);
		addCarButton = new OptionsMenuButton("iconCarButton.png", 115);
		booKCarButton = new OptionsMenuButton("iconRentalButton.png", 155);

		add(customerButton.getButton());
		add(addCarButton.getButton());
		add(booKCarButton.getButton());

		menuPanelControl = new MenuPanelController(this);
		customerButton.getButton().addActionListener(e -> menuPanelControl.changeScreen(customerButton,
				new CustomerManagementScreen(this.frameRentControl, this)));
		addCarButton.getButton().addActionListener(
				e -> menuPanelControl.changeScreen(addCarButton, new CarManagementScreen(this.frameRentControl, this)));
		booKCarButton.getButton().addActionListener(
				e -> menuPanelControl.changeScreen(booKCarButton, new RentalScreen(this.frameRentControl, this)));
	}

	/**
	 * Returns the Jframe of the application.
	 * 
	 * @return RentControl containing the application frame instance.
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * Returns an instance of contentPane, the main panel that contains the
	 * application's contents
	 * 
	 * @return ContentPanel containing an instance of contentPanel
	 */
	public ContentPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * Returns the custom menu button component.
	 * 
	 * @return OptionsMenuButton a custom menu button
	 */
	public OptionsMenuButton getBooKCarButton() {
		return booKCarButton;
	}

	/**
	 * Returns the custom menu button component.
	 * 
	 * @return OptionsMenuButton a custom menu button
	 */
	public OptionsMenuButton getAddCarButton() {
		return addCarButton;
	}

	/**
	 * Returns the custom menu button component.
	 * 
	 * @return OptionsMenuButton a custom menu button
	 */
	public OptionsMenuButton getCustomerButton() {
		return customerButton;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundPanelMenu.getImage(), 0, 0, backgroundPanelMenu.getIconWidth(),
				backgroundPanelMenu.getIconHeight(), this);
	}
}