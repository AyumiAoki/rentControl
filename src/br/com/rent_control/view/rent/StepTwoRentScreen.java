package br.com.rent_control.view.rent;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.StepTwoRentController;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.*;

/**
 * @author ayumi
 *
 */
public class StepTwoRentScreen extends JPanel{

	private static final long serialVersionUID = 5098612675418528285L;
	private MenuPanel menuPanel;
	private final RentControl frameRentControl;
	
	private int idCar;
	private String cpfCustomer;

	private CustomField rentMessagerLabel;
	private JToggleButton additionalButtonOne;
	private JToggleButton additionalButtonTwo;
	private JToggleButton additionalButtonThree;
	private JToggleButton additionalButtonFour;
	private JToggleButton additionalButtonFive;
	private JButton proceedButton;

	public StepTwoRentScreen(final RentControl frameRentControl, MenuPanel menuPanel, int idCar, String cpfCustomer) {
		setLayout(null);
		setBackground(Color.white);
		
		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		this.idCar = idCar;
		this.cpfCustomer = cpfCustomer;
		
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
		additionalButtonThree.add(new JLabel("Bebê conforto (crianças de 0 a a ano)"), BorderLayout.WEST);
		additionalButtonThree.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);
		
		additionalButtonFour = new JToggleButton();
		additionalButtonFour.setLayout(new BorderLayout());
		additionalButtonFour.setBounds(111, 285, 664, 35);
		additionalButtonFour.setBackground(Color.white);
		additionalButtonFour.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonFour.add(new JLabel("Cadeira de bebê (crianças de 1 a 4 anos)"), BorderLayout.WEST);
		additionalButtonFour.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);
		
		additionalButtonFive = new JToggleButton();
		additionalButtonFive.setLayout(new BorderLayout());
		additionalButtonFive.setBounds(111, 352, 664, 35);
		additionalButtonFive.setBackground(Color.white);
		additionalButtonFive.setBorder(new LineBorder(ColorUtils.SECUNDARY_DARK_COLOR, 2));
		additionalButtonFive.add(new JLabel("Assento de elevação (crianças de 4 a 7 anos)"), BorderLayout.WEST);
		additionalButtonFive.add(new JLabel("R$ 29,90 * valor único"), BorderLayout.EAST);
		
		proceedButton = new JButton("Prosseguir");
		proceedButton.setForeground(Color.WHITE);
		proceedButton.setBounds(323, 451, 240, 35);
		proceedButton.setBackground(ColorUtils.PRIMARY_COLOR);
		proceedButton.setBorder(null);
		
		add(rentMessagerLabel.getLabel());
		add(additionalButtonOne);
		add(additionalButtonTwo);
		add(additionalButtonThree);
		add(additionalButtonFour);
		add(additionalButtonFive);
		add(proceedButton);
		
		new StepTwoRentController(this);
		
		proceedButton.addActionListener(e -> new StepTwoRentController(this).proceedButtonClicked());
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

	/**
	 * @return o cpfCustomer
	 */
	public String getCpfCustomer() {
		return cpfCustomer;
	}

	/**
	 * @param cpfCustomer o cpfCustomer a ser configurado
	 */
	public void setCpfCustomer(String cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}

	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * @return o additionalButtonOne
	 */
	public JToggleButton getAdditionalButtonOne() {
		return additionalButtonOne;
	}

	/**
	 * @param additionalButtonOne o additionalButtonOne a ser configurado
	 */
	public void setAdditionalButtonOne(JToggleButton additionalButtonOne) {
		this.additionalButtonOne = additionalButtonOne;
	}

	/**
	 * @return o additionalButtonTwo
	 */
	public JToggleButton getAdditionalButtonTwo() {
		return additionalButtonTwo;
	}

	/**
	 * @param additionalButtonTwo o additionalButtonTwo a ser configurado
	 */
	public void setAdditionalButtonTwo(JToggleButton additionalButtonTwo) {
		this.additionalButtonTwo = additionalButtonTwo;
	}

	/**
	 * @return o additionalButtonThree
	 */
	public JToggleButton getAdditionalButtonThree() {
		return additionalButtonThree;
	}

	/**
	 * @param additionalButtonThree o additionalButtonThree a ser configurado
	 */
	public void setAdditionalButtonThree(JToggleButton additionalButtonThree) {
		this.additionalButtonThree = additionalButtonThree;
	}

	/**
	 * @return o additionalButtonFour
	 */
	public JToggleButton getAdditionalButtonFour() {
		return additionalButtonFour;
	}

	/**
	 * @param additionalButtonFour o additionalButtonFour a ser configurado
	 */
	public void setAdditionalButtonFour(JToggleButton additionalButtonFour) {
		this.additionalButtonFour = additionalButtonFour;
	}

	/**
	 * @return o additionalButtonFive
	 */
	public JToggleButton getAdditionalButtonFive() {
		return additionalButtonFive;
	}

	/**
	 * @param additionalButtonFive o additionalButtonFive a ser configurado
	 */
	public void setAdditionalButtonFive(JToggleButton additionalButtonFive) {
		this.additionalButtonFive = additionalButtonFive;
	}
}