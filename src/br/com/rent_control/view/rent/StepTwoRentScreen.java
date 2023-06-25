package br.com.rent_control.view.rent;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.StepTwoRentController;
import br.com.rent_control.model.vo.Rent;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.*;

/**
 * Class StepTwoRentScreen - Represents the second stage of vehicle rental
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class StepTwoRentScreen extends JPanel {

	private static final long serialVersionUID = 5098612675418528285L;
	private MenuPanel menuPanel;
	private final RentControl frameRentControl;
	private Rent rent;
	private int dailyAmount;
	private double dailyCost;

	private CustomField rentMessagerLabel;
	private JToggleButton additionalButtonOne;
	private JToggleButton additionalButtonTwo;
	private JToggleButton additionalButtonThree;
	private JToggleButton additionalButtonFour;
	private JToggleButton additionalButtonFive;
	private JToggleButton additionalButtonSix;
	private JButton proceedButton;

	/**
	 * Class constructor with parameter.
	 * 
	 * @param frameRentControl
	 * @param menuPanel
	 * @param rent
	 * @param dailyAmount
	 * @param dailyCost
	 */
	public StepTwoRentScreen(final RentControl frameRentControl, MenuPanel menuPanel, Rent rent, int dailyAmount,
			double dailyCost) {
		setLayout(null);
		setBackground(Color.white);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		this.rent = rent;
		this.dailyAmount = dailyAmount;
		this.dailyCost = dailyCost;

		rentMessagerLabel = new CustomField("Aluguel do veículo - Adicionais", 40);

		additionalButtonOne = new JToggleButton();
		additionalButtonOne.setLayout(new BorderLayout());
		additionalButtonOne.setBounds(111, 84, 664, 35);
		additionalButtonOne.setBackground(Color.white);
		additionalButtonOne.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonOne.add(new JLabel("Proteção do carro"), BorderLayout.WEST);
		additionalButtonOne.add(new JLabel("R$ 29,90/dia"), BorderLayout.EAST);

		additionalButtonTwo = new JToggleButton();
		additionalButtonTwo.setLayout(new BorderLayout());
		additionalButtonTwo.setBounds(111, 151, 664, 35);
		additionalButtonTwo.setBackground(Color.white);
		additionalButtonTwo.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonTwo.add(new JLabel("GPS"), BorderLayout.WEST);
		additionalButtonTwo.add(new JLabel("R$ 12,90/dia"), BorderLayout.EAST);

		additionalButtonThree = new JToggleButton();
		additionalButtonThree.setLayout(new BorderLayout());
		additionalButtonThree.setBounds(111, 218, 664, 35);
		additionalButtonThree.setBackground(Color.white);
		additionalButtonThree.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonThree.add(new JLabel("Limpeza do veículo"), BorderLayout.WEST);
		additionalButtonThree.add(new JLabel("R$ 34,90 * valor único"), BorderLayout.EAST);

		additionalButtonFour = new JToggleButton();
		additionalButtonFour.setLayout(new BorderLayout());
		additionalButtonFour.setBounds(111, 285, 664, 35);
		additionalButtonFour.setBackground(Color.white);
		additionalButtonFour.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonFour.add(new JLabel("Bebê conforto (crianças de 0 a a ano)"), BorderLayout.WEST);
		additionalButtonFour.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);

		additionalButtonFive = new JToggleButton();
		additionalButtonFive.setLayout(new BorderLayout());
		additionalButtonFive.setBounds(111, 352, 664, 35);
		additionalButtonFive.setBackground(Color.white);
		additionalButtonFive.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonFive.add(new JLabel("Cadeira de bebê (crianças de 1 a 4 anos)"), BorderLayout.WEST);
		additionalButtonFive.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);

		additionalButtonSix = new JToggleButton();
		additionalButtonSix.setLayout(new BorderLayout());
		additionalButtonSix.setBounds(111, 419, 664, 35);
		additionalButtonSix.setBackground(Color.white);
		additionalButtonSix.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonSix.add(new JLabel("Assento de elevação (crianças de 4 a 7 anos)"), BorderLayout.WEST);
		additionalButtonSix.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);

		proceedButton = new JButton("Prosseguir");
		proceedButton.setForeground(Color.WHITE);
		proceedButton.setBounds(323, 518, 240, 35);
		proceedButton.setBackground(ColorUtils.PRIMARY_COLOR);
		proceedButton.setBorder(null);

		add(rentMessagerLabel.getLabel());
		add(additionalButtonOne);
		add(additionalButtonTwo);
		add(additionalButtonThree);
		add(additionalButtonFour);
		add(additionalButtonFive);
		add(additionalButtonSix);
		add(proceedButton);

		new StepTwoRentController(this);

		proceedButton.addActionListener(e -> new StepTwoRentController(this).proceedButtonClicked());
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
	 * Returns the application's options menu
	 * 
	 * @return MenuPanel containing the application menu
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * Returns vehicle rental information.
	 * 
	 * @return Rent containing the necessary information for the rental of the
	 *         vehicle
	 */
	public Rent getRent() {
		return rent;
	}

	/**
	 * Define vehicle rental information
	 * 
	 * @param rent The rental information to be defined
	 */
	public void setRent(Rent rent) {
		this.rent = rent;
	}

	/**
	 * Returns the daily rate
	 * 
	 * @return int containing the daily amount.
	 */
	public int getDailyAmount() {
		return dailyAmount;
	}

	/**
	 * Defines the daily amount.
	 * 
	 * @param dailyAmount The daily amount to set.
	 */
	public void setDailyAmount(int dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	/**
	 * Returns the daily Cost.
	 * 
	 * @return double containing the daily Cost.
	 */
	public double getDailyCost() {
		return dailyCost;
	}

	/**
	 * Defines the daily Cost.
	 * 
	 * @param dailyCost The daily Cost to set.
	 */
	public void setDailyCost(double dailyCost) {
		this.dailyCost = dailyCost;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonOne() {
		return additionalButtonOne;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonOne The button to be set
	 */
	public void setAdditionalButtonOne(JToggleButton additionalButtonOne) {
		this.additionalButtonOne = additionalButtonOne;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonTwo() {
		return additionalButtonTwo;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonTwo The button to be set
	 */
	public void setAdditionalButtonTwo(JToggleButton additionalButtonTwo) {
		this.additionalButtonTwo = additionalButtonTwo;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonThree() {
		return additionalButtonThree;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonThree The button to be set
	 */
	public void setAdditionalButtonThree(JToggleButton additionalButtonThree) {
		this.additionalButtonThree = additionalButtonThree;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonFour() {
		return additionalButtonFour;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonFour The button to be set
	 */
	public void setAdditionalButtonFour(JToggleButton additionalButtonFour) {
		this.additionalButtonFour = additionalButtonFour;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonFive() {
		return additionalButtonFive;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonFive The button to be set
	 */
	public void setAdditionalButtonFive(JToggleButton additionalButtonFive) {
		this.additionalButtonFive = additionalButtonFive;
	}

	/**
	 * Returns a toggle button
	 * 
	 * @return JToggleButton containing a toggle button
	 */
	public JToggleButton getAdditionalButtonSix() {
		return additionalButtonSix;
	}

	/**
	 * Define button changes
	 * 
	 * @param additionalButtonSix The button to be set
	 */
	public void setAdditionalButtonSix(JToggleButton additionalButtonSix) {
		this.additionalButtonSix = additionalButtonSix;
	}
}