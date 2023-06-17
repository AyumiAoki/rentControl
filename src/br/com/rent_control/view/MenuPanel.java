package br.com.rent_control.view;

import javax.swing.*;

import br.com.rent_control.controller.MenuPanelController;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.OptionsMenuButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Class MenuPanel - Represents the menu panel containing the buttons with the
 * application's functionalitiesRepresents the menu panel containing the buttons
 * with the application's functionalities
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = -9049365368368708163L;

	private final JLabel logoLabel;
	private final JLabel rentLabel;
	private final JLabel carLabel;
	private final JLabel userLabel;
	private final JLabel employeeLabel;

	//private final JButton booKCarButton;
	private final JButton addCarButton;
	private final JButton updateCarButton;
	private final JButton deleteCarButton;
	private final JButton queryCarButton;
	private final JButton addUserButton;
	private final JButton updateUserButton;
	private final JButton deleteUserButton;
	private final JButton queryUserButton;
	private final JButton addEmployeeButton;
	private final JButton updateEmployeeButton;
	private final JButton deleteEmployeeButton;
	private final JButton queryEmployeeButton;

	private final RentControl frameRentControl;
	private ContentPanel contentPanel;
	@SuppressWarnings("unused")
	private MenuPanelController menuPanelControl;
	
	private OptionsMenuButton booKCarButton;
	
	/**
	 * Class constructor with parameters.
	 * @param frameRentControl
	 * @param contentPanel
	 */
	public MenuPanel(final RentControl frameRentControl, ContentPanel contentPanel) {
		setLayout(null);
		setBackground(ColorUtils.PRIMARY_DARK_COLOR);
		setPreferredSize(new Dimension(200, this.getPreferredSize().height));

		this.frameRentControl = frameRentControl;
		this.contentPanel = contentPanel;
		
		booKCarButton = new OptionsMenuButton("Aluguel", 0, 0, 200, 40);

		logoLabel = new JLabel("RentControl");
		logoLabel.setBounds(0, 0, 175, 50);
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setFont(logoLabel.getFont().deriveFont(Font.BOLD, 20));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		rentLabel = new JLabel("Aluguel");
		rentLabel.setBounds(0, 50, 175, 30);
		rentLabel.setBackground(ColorUtils.PRIMARY_COLOR);
		rentLabel.setOpaque(true);
		rentLabel.setForeground(Color.WHITE);
		rentLabel.setFont(rentLabel.getFont().deriveFont(Font.BOLD, 14));
		rentLabel.setHorizontalAlignment(SwingConstants.CENTER);

//		booKCarButton = new JButton("Reservar carro");
//		booKCarButton.setBounds(0, 80, 175, 40);
//		booKCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
//		booKCarButton.setForeground(Color.WHITE);
//		booKCarButton.setFont(booKCarButton.getFont().deriveFont(Font.BOLD, 14));
//		booKCarButton.setHorizontalAlignment(SwingConstants.CENTER);
//		booKCarButton.setBorder(null);

		carLabel = new JLabel("Carro");
		carLabel.setBounds(0, 120, 175, 30);
		carLabel.setBackground(ColorUtils.PRIMARY_COLOR);
		carLabel.setOpaque(true);
		carLabel.setForeground(Color.WHITE);
		carLabel.setFont(carLabel.getFont().deriveFont(Font.BOLD, 14));
		carLabel.setHorizontalAlignment(SwingConstants.CENTER);

		addCarButton = new JButton("Adicionar carro");
		addCarButton.setBounds(0, 150, 175, 40);
		addCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		addCarButton.setForeground(Color.WHITE);
		addCarButton.setFont(addCarButton.getFont().deriveFont(Font.BOLD, 14));
		addCarButton.setHorizontalAlignment(SwingConstants.CENTER);
		addCarButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		queryCarButton = new JButton("Consultar carro");
		queryCarButton.setBounds(0, 190, 175, 40);
		queryCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		queryCarButton.setForeground(Color.WHITE);
		queryCarButton.setFont(queryCarButton.getFont().deriveFont(Font.BOLD, 14));
		queryCarButton.setHorizontalAlignment(SwingConstants.CENTER);
		queryCarButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		updateCarButton = new JButton("Atualizar carro");
		updateCarButton.setBounds(0, 230, 175, 40);
		updateCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		updateCarButton.setForeground(Color.WHITE);
		updateCarButton.setFont(updateCarButton.getFont().deriveFont(Font.BOLD, 14));
		updateCarButton.setHorizontalAlignment(SwingConstants.CENTER);
		updateCarButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		deleteCarButton = new JButton("Excluir carro");
		deleteCarButton.setBounds(0, 270, 175, 40);
		deleteCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		deleteCarButton.setForeground(Color.WHITE);
		deleteCarButton.setFont(deleteCarButton.getFont().deriveFont(Font.BOLD, 14));
		deleteCarButton.setHorizontalAlignment(SwingConstants.CENTER);
		deleteCarButton.setBorder(null);

		userLabel = new JLabel("Usuário");
		userLabel.setBounds(0, 310, 175, 30);
		userLabel.setBackground(ColorUtils.PRIMARY_COLOR);
		userLabel.setOpaque(true);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(userLabel.getFont().deriveFont(Font.BOLD, 14));
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);

		addUserButton = new JButton("Adicionar usuário");
		addUserButton.setBounds(0, 340, 175, 40);
		addUserButton.setBackground(ColorUtils.PRIMARY_COLOR);
		addUserButton.setForeground(Color.WHITE);
		addUserButton.setFont(addUserButton.getFont().deriveFont(Font.BOLD, 14));
		addUserButton.setHorizontalAlignment(SwingConstants.CENTER);
		addUserButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		queryUserButton = new JButton("Consultar usuário");
		queryUserButton.setBounds(0, 380, 175, 40);
		queryUserButton.setBackground(ColorUtils.PRIMARY_COLOR);
		queryUserButton.setForeground(Color.WHITE);
		queryUserButton.setFont(queryUserButton.getFont().deriveFont(Font.BOLD, 14));
		queryUserButton.setHorizontalAlignment(SwingConstants.CENTER);
		queryUserButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		updateUserButton = new JButton("Atualizar usuário");
		updateUserButton.setBounds(0, 420, 175, 40);
		updateUserButton.setBackground(ColorUtils.PRIMARY_COLOR);
		updateUserButton.setForeground(Color.WHITE);
		updateUserButton.setFont(updateUserButton.getFont().deriveFont(Font.BOLD, 14));
		updateUserButton.setHorizontalAlignment(SwingConstants.CENTER);
		updateUserButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		deleteUserButton = new JButton("Excluir usuário");
		deleteUserButton.setBounds(0, 460, 175, 40);
		deleteUserButton.setBackground(ColorUtils.PRIMARY_COLOR);
		deleteUserButton.setForeground(Color.WHITE);
		deleteUserButton.setFont(deleteUserButton.getFont().deriveFont(Font.BOLD, 14));
		deleteUserButton.setHorizontalAlignment(SwingConstants.CENTER);
		deleteUserButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		employeeLabel = new JLabel("Funcionário");
		employeeLabel.setBounds(0, 500, 175, 30);
		employeeLabel.setBackground(ColorUtils.PRIMARY_COLOR);
		employeeLabel.setOpaque(true);
		employeeLabel.setForeground(Color.WHITE);
		employeeLabel.setFont(employeeLabel.getFont().deriveFont(Font.BOLD, 14));
		employeeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		addEmployeeButton = new JButton("Adicionar funcionário");
		addEmployeeButton.setBounds(0, 530, 175, 40);
		addEmployeeButton.setBackground(ColorUtils.PRIMARY_COLOR);
		addEmployeeButton.setForeground(Color.WHITE);
		addEmployeeButton.setFont(addEmployeeButton.getFont().deriveFont(Font.BOLD, 14));
		addEmployeeButton.setHorizontalAlignment(SwingConstants.CENTER);
		addEmployeeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		queryEmployeeButton = new JButton("Consultar funcionário");
		queryEmployeeButton.setBounds(0, 570, 175, 40);
		queryEmployeeButton.setBackground(ColorUtils.PRIMARY_COLOR);
		queryEmployeeButton.setForeground(Color.WHITE);
		queryEmployeeButton.setFont(queryEmployeeButton.getFont().deriveFont(Font.BOLD, 14));
		queryEmployeeButton.setHorizontalAlignment(SwingConstants.CENTER);
		queryEmployeeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		updateEmployeeButton = new JButton("Atualizar funcionário");
		updateEmployeeButton.setBounds(0, 610, 175, 40);
		updateEmployeeButton.setBackground(ColorUtils.PRIMARY_COLOR);
		updateEmployeeButton.setForeground(Color.WHITE);
		updateEmployeeButton.setFont(updateEmployeeButton.getFont().deriveFont(Font.BOLD, 14));
		updateEmployeeButton.setHorizontalAlignment(SwingConstants.CENTER);
		updateEmployeeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		deleteEmployeeButton = new JButton("Excluir funcionário");
		deleteEmployeeButton.setBounds(0, 650, 175, 40);
		deleteEmployeeButton.setBackground(ColorUtils.PRIMARY_COLOR);
		deleteEmployeeButton.setForeground(Color.WHITE);
		deleteEmployeeButton.setFont(deleteEmployeeButton.getFont().deriveFont(Font.BOLD, 14));
		deleteEmployeeButton.setHorizontalAlignment(SwingConstants.CENTER);
		deleteEmployeeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorUtils.PRIMARY_COLOR));

		add(booKCarButton.getOptionMenuButton());
		add(rentLabel);
		//add(booKCarButton);
		add(carLabel);
		add(addCarButton);
		add(queryCarButton);
		add(updateCarButton);
		add(deleteCarButton);
		add(userLabel);
		add(addUserButton);
		add(queryUserButton);
		add(updateUserButton);
		add(deleteUserButton);
		add(employeeLabel);
		add(addEmployeeButton);
		add(queryEmployeeButton);
		add(updateEmployeeButton);
		add(deleteEmployeeButton);
		
		menuPanelControl = new MenuPanelController(this);
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
	public JLabel getUserLabel() {
		return userLabel;
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
	 * @return o addCarButton
	 */
	public JButton getAddCarButton() {
		return addCarButton;
	}

	/**
	 * @return o updateCarButton
	 */
	public JButton getUpdateCarButton() {
		return updateCarButton;
	}

	/**
	 * @return o deleteCarButton
	 */
	public JButton getDeleteCarButton() {
		return deleteCarButton;
	}

	/**
	 * @return o queryCarButton
	 */
	public JButton getQueryCarButton() {
		return queryCarButton;
	}

	/**
	 * @return o addUserButton
	 */
	public JButton getAddUserButton() {
		return addUserButton;
	}

	/**
	 * @return o updateUserButton
	 */
	public JButton getUpdateUserButton() {
		return updateUserButton;
	}

	/**
	 * @return o deleteUserButton
	 */
	public JButton getDeleteUserButton() {
		return deleteUserButton;
	}

	/**
	 * @return o queryUserButton
	 */
	public JButton getQueryUserButton() {
		return queryUserButton;
	}

	/**
	 * @return o addEmployeeButton
	 */
	public JButton getAddEmployeeButton() {
		return addEmployeeButton;
	}

	/**
	 * @return o updateEmployeeButton
	 */
	public JButton getUpdateEmployeeButton() {
		return updateEmployeeButton;
	}

	/**
	 * @return o deleteEmployeeButton
	 */
	public JButton getDeleteEmployeeButton() {
		return deleteEmployeeButton;
	}

	/**
	 * @return o queryEmployeeButton
	 */
	public JButton getQueryEmployeeButton() {
		return queryEmployeeButton;
	}
}