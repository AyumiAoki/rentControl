/**
 * 
 */
package br.com.rent_control.view.rent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.CarCardController;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;

/**
 * @author ayumi
 *
 */

public class CarCardPanel extends JPanel {

	private static final long serialVersionUID = 3127568446943655484L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;

	private JLabel groupLabel;
	private JLabel imageCarLabel;
	private JLabel carNameLabel;
	private JLabel carValueLabel;
	private JLabel maxPassengersLabel;
	private JLabel trunkSizeLabel;
	private JLabel transmissionTypeLabel;
	private JLabel fuelTypeLabel;
	private JLabel hasAcLabel;
	private JLabel hasAirbagLabel;
	private JLabel hasAbsBrakesLabel;
	private JLabel hasDvdPlayerLabel;

	private JButton selectCarButton;
	private JButton detailsCarButton;
	private JButton hideInformationButton;

	private JPanel infoPanel;
	private JPanel detailsPanel;
	
	private int idCar;

	public CarCardPanel(Car car, final RentControl frameRentControl, MenuPanel menuPanel, int idCar) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(ColorUtils.SECUNDARY_COLOR);
		setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));

		this.frameRentControl = frameRentControl;
		this.menuPanel = menuPanel;
		this.idCar = idCar;

		// Elementos do painel de informações
		groupLabel = new JLabel(car.getCategory());
		groupLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		groupLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));
		groupLabel.setBounds(0, 8, 270, 25);
		groupLabel.setHorizontalAlignment(JLabel.CENTER);

		imageCarLabel = new JLabel(new ImageIcon("src/br/com/rent_control/view/images/iconCar.png"));
		imageCarLabel.setBounds(45, 41, 180, 120);
		imageCarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		carNameLabel = new JLabel(car.getModelCar());
		carNameLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		carNameLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));
		carNameLabel.setBounds(0, 169, 270, 25);
		carNameLabel.setHorizontalAlignment(JLabel.CENTER);

		carValueLabel = new JLabel("R$ " + Double.toString(car.getDailyCost()));
		carValueLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		carValueLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));
		carValueLabel.setBounds(0, 202, 270, 25);
		carValueLabel.setHorizontalAlignment(JLabel.CENTER);

		selectCarButton = new JButton("Escolher este grupo");
		selectCarButton.setForeground(Color.WHITE);
		selectCarButton.setFont(selectCarButton.getFont().deriveFont(Font.BOLD, 14));
		selectCarButton.setBorder(null);
		selectCarButton.setBackground(ColorUtils.PRIMARY_COLOR);
		selectCarButton.setBounds(35, 235, 200, 35);
		selectCarButton.setHorizontalAlignment(JButton.CENTER);

		detailsCarButton = new JButton("<html><u>Mais informações</u></html>");
		detailsCarButton.setFont(detailsCarButton.getFont().deriveFont(Font.BOLD, 14));
		detailsCarButton.setForeground(ColorUtils.PRIMARY_COLOR);
		detailsCarButton.setContentAreaFilled(false);
		detailsCarButton.setBorder(null);
		detailsCarButton.setBounds(35, 278, 200, 35);
		detailsCarButton.setHorizontalAlignment(JButton.CENTER);
		// Fim dos elementos do painel de informações

		// Painel para as informações iniciais
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBackground(ColorUtils.SECUNDARY_COLOR);

		// Adicionar as informações ao painel
		infoPanel.add(groupLabel);
		infoPanel.add(imageCarLabel);
		infoPanel.add(carNameLabel);
		infoPanel.add(carValueLabel);
		infoPanel.add(selectCarButton);
		infoPanel.add(detailsCarButton);

		// Painel para as informações adicionais
		detailsPanel = new JPanel();
		detailsPanel.setLayout(null);
		detailsPanel.setBackground(ColorUtils.SECUNDARY_COLOR);

		// Elementos do painel de mais informações
		maxPassengersLabel = new JLabel("Quantidade de passageiros: " + Integer.toString(car.getMaxPassengers()));
		maxPassengersLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		maxPassengersLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		maxPassengersLabel.setBounds(0, 8, 270, 25);
		maxPassengersLabel.setHorizontalAlignment(JLabel.CENTER);

		trunkSizeLabel = new JLabel("Volume do bagageiro: " + Double.toString(car.getTrunkSize()));
		trunkSizeLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		trunkSizeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		trunkSizeLabel.setBounds(0, 41, 270, 25);
		trunkSizeLabel.setHorizontalAlignment(JLabel.CENTER);

		transmissionTypeLabel = new JLabel("Tipo de câmbio: " + car.getTransmissionType());
		transmissionTypeLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		transmissionTypeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		transmissionTypeLabel.setBounds(0, 74, 270, 25);
		transmissionTypeLabel.setHorizontalAlignment(JLabel.CENTER);

		fuelTypeLabel = new JLabel("Tipo de combustível: " + car.getFuelType());
		fuelTypeLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		fuelTypeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		fuelTypeLabel.setBounds(0, 107, 270, 25);
		fuelTypeLabel.setHorizontalAlignment(JLabel.CENTER);

		hasAcLabel = new JLabel("Ar condicionado: " + (car.isHasAc() ? "Sim" : "Não"));
		hasAcLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		hasAcLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		hasAcLabel.setBounds(0, 140, 270, 25);
		hasAcLabel.setHorizontalAlignment(JLabel.CENTER);

		hasAirbagLabel = new JLabel("Airbag: " + (car.isHasAirbag() ? "Sim" : "Não"));
		hasAirbagLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		hasAirbagLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		hasAirbagLabel.setBounds(0, 173, 270, 25);
		hasAirbagLabel.setHorizontalAlignment(JLabel.CENTER);

		hasAbsBrakesLabel = new JLabel("Freio ABS: " + (car.isHasAbsBrakes() ? "Sim" : "Não"));
		hasAbsBrakesLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		hasAbsBrakesLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		hasAbsBrakesLabel.setBounds(0, 206, 270, 25);
		hasAbsBrakesLabel.setHorizontalAlignment(JLabel.CENTER);

		hasDvdPlayerLabel = new JLabel("DVD: " + (car.isHasDvdPlayer() ? "Sim" : "Não"));
		hasDvdPlayerLabel.setForeground(ColorUtils.PRIMARY_COLOR);
		hasDvdPlayerLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		hasDvdPlayerLabel.setBounds(0, 239, 270, 25);
		hasDvdPlayerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		hideInformationButton = new JButton("<html><u>Esconder informações</u></html>");
		hideInformationButton.setForeground(ColorUtils.PRIMARY_COLOR);
		hideInformationButton.setFont(detailsCarButton.getFont().deriveFont(Font.BOLD, 14));
		hideInformationButton.setContentAreaFilled(false);
		hideInformationButton.setBorder(null);
		hideInformationButton.setBounds(0, 272, 270, 25);
		hideInformationButton.setHorizontalAlignment(JButton.CENTER);
		// Fim dos elementos do painel de mais informações

		// Adicionar as informações ao painel
		detailsPanel.add(maxPassengersLabel);
		detailsPanel.add(trunkSizeLabel);
		detailsPanel.add(transmissionTypeLabel);
		detailsPanel.add(fuelTypeLabel);
		detailsPanel.add(hasAcLabel);
		detailsPanel.add(hasAirbagLabel);
		detailsPanel.add(hasAbsBrakesLabel);
		detailsPanel.add(hasDvdPlayerLabel);
		detailsPanel.add(hideInformationButton);

		// Adicionar os componentes aos painéis
		add(infoPanel);
		
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setBorder(BorderFactory.createLineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setBorder(BorderFactory.createLineBorder(ColorUtils.SECUNDARY_DARK_COLOR));
			}
		});

		detailsCarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Alternar a visibilidade dos painéis
				add(detailsPanel);
				infoPanel.setVisible(false);
				detailsPanel.setVisible(true);
			}
		});
		
		hideInformationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Alternar a visibilidade dos painéis
				add(infoPanel);
				infoPanel.setVisible(true);
				detailsPanel.setVisible(false);
			}
		});
		
		new CarCardController(this);
	}
	
	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return the menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	
	/**
	 * @param menuPanel the menuPanel to set
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * @return o selectCarButton
	 */
	public JButton getSelectCarButton() {
		return selectCarButton;
	}

	/**
	 * @param selectCarButton o selectCarButton a ser configurado
	 */
	public void setSelectCarButton(JButton selectCarButton) {
		this.selectCarButton = selectCarButton;
	}

	/**
	 * @return o idCar
	 */
	public int getIdCar() {
		return idCar;
	}

	/**
	 * @param idCar o idCar a ser configurado
	 */
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
}