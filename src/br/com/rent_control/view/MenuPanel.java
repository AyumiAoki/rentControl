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
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = -9049365368368708163L;

	private RentControl frameRentControl;
	private ContentPanel contentPanel;
	@SuppressWarnings("unused")
	private MenuPanelController menuPanelControl;

	
	private OptionsMenuButton booKCarButton;
	private OptionsMenuButton addCarButton;
	private OptionsMenuButton customerButton;
	
	private final ImageIcon backgroundPanelMenu;
	
	/**
	 * Class constructor with parameters.
	 * @param frameRentControl
	 * @param contentPanel
	 */
	public MenuPanel(final RentControl frameRentControl, ContentPanel contentPanel) {
		setLayout(null);
		setPreferredSize(new Dimension(200, this.getPreferredSize().height));

		this.frameRentControl = frameRentControl;
		this.contentPanel = contentPanel;
		
		backgroundPanelMenu = new ImageIcon(getClass().getResource("/br/com/rent_control/view/images/backgroundPanelMenu.png"));
		
		booKCarButton = new OptionsMenuButton("iconRentalButton.png", 75);
		customerButton = new OptionsMenuButton("iconUserButton.png", 115);
		addCarButton = new OptionsMenuButton("iconCarButton.png", 155);

		add(booKCarButton.getButton());
		add(customerButton.getButton());
		add(addCarButton.getButton());
		
		menuPanelControl = new MenuPanelController(this);
		booKCarButton.getButton().addActionListener(e -> menuPanelControl.changeScreen(booKCarButton,new RentalScreen(this.frameRentControl, this)));
		customerButton.getButton().addActionListener(e -> menuPanelControl.changeScreen(customerButton,new CustomerManagementScreen(this.frameRentControl, this)));
		addCarButton.getButton().addActionListener(e -> menuPanelControl.changeScreen(addCarButton,new CarManagementScreen(this.frameRentControl, this)));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundPanelMenu.getImage(), 0, 0, backgroundPanelMenu.getIconWidth(), backgroundPanelMenu.getIconHeight(), this);
	}
	
	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return o contentPanel
	 */
	public ContentPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * @param contentPanel o contentPanel a ser configurado
	 */
	public void setContentPanel(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	/**
	 * @return o booKCarButton
	 */
	public OptionsMenuButton getBooKCarButton() {
		return booKCarButton;
	}

	/**
	 * @param booKCarButton o booKCarButton a ser configurado
	 */
	public void setBooKCarButton(OptionsMenuButton booKCarButton) {
		this.booKCarButton = booKCarButton;
	}

	/**
	 * @return the addCarButton
	 */
	public OptionsMenuButton getAddCarButton() {
		return addCarButton;
	}

	/**
	 * @param addCarButton the addCarButton to set
	 */
	public void setAddCarButton(OptionsMenuButton addCarButton) {
		this.addCarButton = addCarButton;
	}
	
	public OptionsMenuButton getCustomerButton() {
		return customerButton;
	}
	
	public void setCustomerButton(OptionsMenuButton customerButton) {
		this.customerButton = customerButton;
	}
}