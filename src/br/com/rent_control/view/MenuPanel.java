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

		add(rentLabel.getLabel());
		add(booKCarButton.getButton());
		add(carLabel.getLabel());
		
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
//	public JButton getBooKCarButton() {
//		return booKCarButton;
//	}
	
	

	/**
	 * @return o userLabel
	 */
//	public JLabel getUserLabel() {
//		return userLabel;
//	}

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
	 * @return o addCarButton
	 */
//	public JButton getAddCarButton() {
//		return addCarButton;
//	}

	/**
	 * @return o updateCarButton
	 */
//	public JButton getUpdateCarButton() {
//		return updateCarButton;
//	}
//
//	/**
//	 * @return o deleteCarButton
//	 */
//	public JButton getDeleteCarButton() {
//		return deleteCarButton;
//	}
//
//	/**
//	 * @return o queryCarButton
//	 */
//	public JButton getQueryCarButton() {
//		return queryCarButton;
//	}
//
//	/**
//	 * @return o addUserButton
//	 */
//	public JButton getAddUserButton() {
//		return addUserButton;
//	}
//
//	/**
//	 * @return o updateUserButton
//	 */
//	public JButton getUpdateUserButton() {
//		return updateUserButton;
//	}
//
//	/**
//	 * @return o deleteUserButton
//	 */
//	public JButton getDeleteUserButton() {
//		return deleteUserButton;
//	}
//
//	/**
//	 * @return o queryUserButton
//	 */
//	public JButton getQueryUserButton() {
//		return queryUserButton;
//	}
//
//	/**
//	 * @return o addEmployeeButton
//	 */
//	public JButton getAddEmployeeButton() {
//		return addEmployeeButton;
//	}
//
//	/**
//	 * @return o updateEmployeeButton
//	 */
//	public JButton getUpdateEmployeeButton() {
//		return updateEmployeeButton;
//	}
//
//	/**
//	 * @return o deleteEmployeeButton
//	 */
//	public JButton getDeleteEmployeeButton() {
//		return deleteEmployeeButton;
//	}
//
//	/**
//	 * @return o queryEmployeeButton
//	 */
//	public JButton getQueryEmployeeButton() {
//		return queryEmployeeButton;
//	}
}