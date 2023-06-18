package br.com.rent_control.view;

import javax.swing.*;

import br.com.rent_control.controller.MenuPanelController;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.components.OptionsMenuButton;
import br.com.rent_control.view.components.OptionsMenuLabel;

import java.awt.*;

/**
 * Class MenuPanel - Represents the menu panel containing the buttons with the
 * application's functionalitiesRepresents the menu panel containing the buttons
 * with the application's functionalities
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = -9049365368368708163L;

	//private final JLabel logoLabel;
	//private final JLabel rentLabel;
	//private final JLabel carLabel;
//	private final JLabel userLabel;
//	//private final JLabel employeeLabel;
//
//	//private final JButton booKCarButton;
//	private final JButton addCarButton;
//	private final JButton updateCarButton;
//	private final JButton deleteCarButton;
//	private final JButton queryCarButton;
//	private final JButton addUserButton;
//	private final JButton updateUserButton;
//	private final JButton deleteUserButton;
//	private final JButton queryUserButton;
//	private final JButton addEmployeeButton;
//	private final JButton updateEmployeeButton;
//	private final JButton deleteEmployeeButton;
//	private final JButton queryEmployeeButton;

	private RentControl frameRentControl;
	private ContentPanel contentPanel;
	@SuppressWarnings("unused")
	private MenuPanelController menuPanelControl;
	
	private OptionsMenuLabel rentLabel;
	private OptionsMenuLabel carLabel;
	private OptionsMenuButton booKCarButton;
	private OptionsMenuButton addCarButton;
	private OptionsMenuButton CustomerButton;
	
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
		
		rentLabel = new OptionsMenuLabel("src/br/com/rent_control/view/images/iconLabelRental.png", 75);
		booKCarButton = new OptionsMenuButton("Reservar veículo", 115);

		carLabel = new OptionsMenuLabel("/br/com/rent_control/view/images/iconLabelCar.png", 150);
		addCarButton = new OptionsMenuButton("Reservar veículo", 190);
		
		// TODO: Trocar a posição
		CustomerButton = new OptionsMenuButton("Cliente", 230);

		add(rentLabel.getLabel());
		add(booKCarButton.getButton());
		add(carLabel.getLabel());
		add(addCarButton.getButton());
		add(CustomerButton.getButton());
		
		menuPanelControl = new MenuPanelController(this);
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
		return CustomerButton;
	}
	
	public void setCustomerButton(OptionsMenuButton customerButton) {
		CustomerButton = customerButton;
	}
}