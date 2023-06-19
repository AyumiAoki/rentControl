/**
 * 
 */
package br.com.rent_control.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.com.rent_control.model.vo.Car;

/**
 * @author ayumi
 *
 */

public class CarCardPanel extends JPanel {

	private static final long serialVersionUID = 3127568446943655484L;

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

	private final Color COLOR_PRIMARY = new Color(38, 135, 78);
	private final Color COLOR_SECUNDARY = new Color(236, 238, 244);

	public CarCardPanel(Car car) {
		setLayout(new BorderLayout());
		setBackground(COLOR_SECUNDARY);
		setPreferredSize(new Dimension(200, 350));		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// Elementos do painel de informações
		//groupLabel = new JLabel(car.getCategory());
		groupLabel = new JLabel(car.getCategory());
		groupLabel.setForeground(COLOR_PRIMARY);
		groupLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));

		imageCarLabel = new JLabel("");
		imageCarLabel.setPreferredSize(new Dimension(186, 120));
		imageCarLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

		carNameLabel = new JLabel(car.getModelCar());
		carNameLabel.setForeground(COLOR_PRIMARY);
		carNameLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));

		carValueLabel = new JLabel("              R$ " + Double.toString(car.getDailyCost()) + "              ");
		carValueLabel.setForeground(COLOR_PRIMARY);
		carValueLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 14));

		selectCarButton = new JButton("Escolher este grupo");
		selectCarButton.setPreferredSize(new Dimension(190, 25));
		selectCarButton.setFont(selectCarButton.getFont().deriveFont(Font.BOLD, 14));
		selectCarButton.setForeground(Color.WHITE);
		selectCarButton.setBorder(null);
		selectCarButton.setBackground(COLOR_PRIMARY);

		detailsCarButton = new JButton("<html><u>Mais informações</u></html>");
		detailsCarButton.setFont(detailsCarButton.getFont().deriveFont(Font.BOLD, 14));
		detailsCarButton.setForeground(COLOR_PRIMARY);
		detailsCarButton.setContentAreaFilled(false);
		detailsCarButton.setBorder(null);
		// Fim dos elementos do painel de informações

		// Painel para as informações iniciais
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 16));
		infoPanel.setBackground(COLOR_SECUNDARY);

		// Adicionar as informações ao painel
		infoPanel.add(groupLabel);
		infoPanel.add(imageCarLabel);
		infoPanel.add(carNameLabel);
		infoPanel.add(carValueLabel);
		infoPanel.add(selectCarButton);
		infoPanel.add(detailsCarButton);

		// Painel para as informações adicionais
		detailsPanel = new JPanel();
		detailsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 16));
		detailsPanel.setBackground(COLOR_SECUNDARY);

		// Elementos do painel de mais informações
		maxPassengersLabel = new JLabel("Quantidade de passageiros: " + Integer.toString(car.getMaxPassengers()));
		maxPassengersLabel.setForeground(COLOR_PRIMARY);
		maxPassengersLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		trunkSizeLabel = new JLabel("Volume do bagageiro: " + Double.toString(car.getTrunkSize()));
		trunkSizeLabel.setForeground(COLOR_PRIMARY);
		trunkSizeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		transmissionTypeLabel = new JLabel("Tipo de câmbio: " + car.getTransmissionType());
		transmissionTypeLabel.setForeground(COLOR_PRIMARY);
		transmissionTypeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		fuelTypeLabel = new JLabel("Tipo de combustível: " + car.getFuelType());
		fuelTypeLabel.setForeground(COLOR_PRIMARY);
		fuelTypeLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		hasAcLabel = new JLabel("Ar condicionado: " + (car.isHasAc() ? "Sim" : "Não"));
		hasAcLabel.setForeground(COLOR_PRIMARY);
		hasAcLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		hasAirbagLabel = new JLabel("              Airbag: " + (car.isHasAirbag() ? "Sim" : "Não") + "                 ");
		hasAirbagLabel.setForeground(COLOR_PRIMARY);
		hasAirbagLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		hasAbsBrakesLabel = new JLabel("          Freio ABS: " + (car.isHasAbsBrakes() ? "Sim" : "Não" + "              "));
		hasAbsBrakesLabel.setForeground(COLOR_PRIMARY);
		hasAbsBrakesLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));

		hasDvdPlayerLabel = new JLabel("          DVD: " + (car.isHasDvdPlayer() ? "Sim" : "Não" + "              "));
		hasDvdPlayerLabel.setForeground(COLOR_PRIMARY);
		hasDvdPlayerLabel.setFont(groupLabel.getFont().deriveFont(Font.BOLD, 12));
		
		hideInformationButton = new JButton("<html><u>Esconder informações</u></html>");
		hideInformationButton.setFont(detailsCarButton.getFont().deriveFont(Font.BOLD, 14));
		hideInformationButton.setForeground(COLOR_PRIMARY);
		hideInformationButton.setContentAreaFilled(false);
		hideInformationButton.setBorder(null);
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
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
		
		selectCarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
