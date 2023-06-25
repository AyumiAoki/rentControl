package br.com.rent_control.view.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.RentClosingController;
import br.com.rent_control.model.vo.Rent;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomField;

/**
 * @author ayumi
 *
 */

public class RentClosing extends JPanel{

	private static final long serialVersionUID = 2270868975260905007L;
	private MenuPanel menuPanel;
	private final RentControl frameRentControl;
	private Rent rent;

	private CustomField rentMessagerLabel;
	private JLabel dailyCostLabel;
	private JLabel additionalOneLabel;
	private JLabel additionalTwoLabel;
	private JLabel additionalThreeLabel;
	private JLabel additionalFourLabel;
	private JLabel additionalFiveLabel;
	private JLabel additionalSixLabel;
	private JLabel rentalFeeLabel;
	private JLabel predictedTotal;
	private JButton rentButton;
	
	private int yAdditional;
	private double amount;
	private double rate;
	private DecimalFormat df;

	public RentClosing(final RentControl frameRentControl, MenuPanel menuPanel, Rent rent,  int dailyAmount, double dailyCost) {
		setLayout(null);
		setBackground(Color.white);
		
		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		this.rent = rent;
		yAdditional = 143;
		amount = 0;
		
		df = new DecimalFormat("#.00");
		
		rentMessagerLabel = new CustomField("Aluguel do veículo - Fechamento", 40);
		
		dailyCostLabel = new JLabel();
		dailyCostLabel.setLayout(new BorderLayout());
		dailyCostLabel.setBounds(111, 84, 664, 35);
		dailyCostLabel.setBackground(Color.white);
		dailyCostLabel.setBorder(null);
		dailyCostLabel.add(new JLabel("Diárias"), BorderLayout.WEST);
		dailyCostLabel.add(new JLabel(dailyAmount + "x R$ " + dailyCost), BorderLayout.EAST);
		
		rate = 0;
		amount += (dailyAmount * dailyCost);
		
		additionalOneLabel = new JLabel();
		additionalTwoLabel = new JLabel();
		additionalThreeLabel = new JLabel();
		additionalFourLabel = new JLabel();
		additionalFiveLabel = new JLabel();
		additionalSixLabel = new JLabel();
		
		if(rent.isCarProtection()) {
			additionalOneLabel.setLayout(new BorderLayout());
			additionalOneLabel.setBounds(111, yAdditional, 664, 35);
			additionalOneLabel.setBackground(Color.white);
			additionalOneLabel.setBorder(null);
			additionalOneLabel.add(new JLabel("Proteção do carro"), BorderLayout.WEST);
			additionalOneLabel.add(new JLabel(dailyAmount + "x R$ 29,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += (dailyAmount * 29.9);
		}
		
		if(rent.isGps()) {
			additionalTwoLabel.setLayout(new BorderLayout());
			additionalTwoLabel.setBounds(111, yAdditional, 664, 35);
			additionalTwoLabel.setBackground(Color.white);
			additionalTwoLabel.setBorder(null);
			additionalTwoLabel.add(new JLabel("GPS"), BorderLayout.WEST);
			additionalTwoLabel.add(new JLabel(dailyAmount + "x R$ 12,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += (dailyAmount * 12.9);
		}
		
		if(rent.isCleaning()) {
			additionalThreeLabel.setLayout(new BorderLayout());
			additionalThreeLabel.setBounds(111, yAdditional, 664, 35);
			additionalThreeLabel.setBackground(Color.white);
			additionalThreeLabel.setBorder(null);
			additionalThreeLabel.add(new JLabel("Limpeza do veículo"), BorderLayout.WEST);
			additionalThreeLabel.add(new JLabel("R$ 34,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += 34.9;
		}
		
		if(rent.isDrinkComfort()) {
			additionalFourLabel.setLayout(new BorderLayout());
			additionalFourLabel.setBounds(111, yAdditional, 664, 35);
			additionalFourLabel.setBackground(Color.white);
			additionalFourLabel.setBorder(null);
			additionalFourLabel.add(new JLabel("Bebê conforto (crianças de 0 a a ano)"), BorderLayout.WEST);
			additionalFourLabel.add(new JLabel("R$ 29,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += 29.9;
		}
		
		if(rent.isBabyChair()) {
			additionalFiveLabel.setLayout(new BorderLayout());
			additionalFiveLabel.setBounds(111, yAdditional, 664, 35);
			additionalFiveLabel.setBackground(Color.white);
			additionalFiveLabel.setBorder(null);
			additionalFiveLabel.add(new JLabel("Cadeira de bebê (crianças de 1 a 4 anos)"), BorderLayout.WEST);
			additionalFiveLabel.add(new JLabel("R$ 29,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += 29.9;
		}
		
		if(rent.isBoosterSeat()) {
			additionalSixLabel.setLayout(new BorderLayout());
			additionalSixLabel.setBounds(111, yAdditional, 664, 35);
			additionalSixLabel.setBackground(Color.white);
			additionalSixLabel.setBorder(null);
			additionalSixLabel.add(new JLabel("Assento de elevação (crianças de 4 a 7 anos)"), BorderLayout.WEST);
			additionalSixLabel.add(new JLabel("R$ 29,90"), BorderLayout.EAST);
			
			yAdditional += 59;
			amount += 29.9;
		}
		
		rate = amount*0.12;
		rentalFeeLabel = new JLabel();
		rentalFeeLabel.setLayout(new BorderLayout());
		rentalFeeLabel.setBounds(111, yAdditional, 664, 35);
		rentalFeeLabel.setBackground(Color.white);
		rentalFeeLabel.setBorder(null);
		rentalFeeLabel.add(new JLabel("Taxa de aluguel (12% do valor total)"), BorderLayout.WEST);
		rentalFeeLabel.add(new JLabel("R$ " + df.format(rate)), BorderLayout.EAST);
		
		yAdditional += 59;
		amount += rate;
		
		predictedTotal = new JLabel();
		predictedTotal.setLayout(new BorderLayout());
		predictedTotal.setBounds(111, yAdditional, 664, 35);
		predictedTotal.setBackground(Color.white);
		predictedTotal.setBorder(null);
		predictedTotal.add(new JLabel("Total previsto"), BorderLayout.WEST);
		predictedTotal.add(new JLabel("R$ " + df.format(amount)), BorderLayout.EAST);
		
		yAdditional += 83;
		
		rentButton = new JButton("Finalizar aluguel");
		rentButton.setForeground(Color.WHITE);
		rentButton.setBounds(323, yAdditional, 240, 35);
		rentButton.setBackground(ColorUtils.PRIMARY_COLOR);
		rentButton.setBorder(null);
		
		add(rentMessagerLabel.getLabel());
		add(dailyCostLabel);
		add(additionalOneLabel);
		add(additionalTwoLabel);
		add(additionalThreeLabel);
		add(additionalFourLabel);
		add(additionalFiveLabel);
		add(additionalSixLabel);
		add(rentalFeeLabel);
		add(predictedTotal);
		add(rentButton);
		
		rentButton.addActionListener(e -> new RentClosingController(this).rentButtonClicked());
	}

	/**
	 * @return o menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * @param menuPanel o menuPanel a ser configurado
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}
	
	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return o rent
	 */
	public Rent getRent() {
		return rent;
	}

	/**
	 * @param rent o rent a ser configurado
	 */
	public void setRent(Rent rent) {
		this.rent = rent;
	}
}