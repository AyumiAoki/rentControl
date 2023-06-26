package br.com.rent_control.view.rent;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.rent.RentManagementController;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomTable;
import br.com.rent_control.view.customer.CustomerManagementScreen.ActionButton;
import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.dao.RentDao;
import br.com.rent_control.model.vo.*;

/**
 * Class RentManagementScreen - Represents the rent management screen
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentManagementScreen extends JPanel{

	private static final long serialVersionUID = 6269839751385076881L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;
	private JScrollPane scrollPane;
	private JLabel messagerLabel;
	private JButton newRent;
	private List<Rent> rents;
	private RentDao rentDao;
	private CustomerDao customerDao;
	private CarDao carDao;

	public RentManagementScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);

		this.frameRentControl = frameRentControl;
		this.menuPanel = menuPanel;
		messagerLabel = new JLabel("Reservas");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));

		newRent = new JButton("Nova");
		newRent.setForeground(Color.WHITE);
		newRent.setBounds(750, 20, 80, 34);
		newRent.setBackground(ColorUtils.PRIMARY_COLOR);
		newRent.setBorder(null);
		
		rentDao = new RentDao();
		customerDao = new CustomerDao();
		carDao = new CarDao();
		tableSetup();
		
		add(newRent);
		add(messagerLabel);
		
		new RentManagementController(this);
	}
	
	/**
	 * Method that has the action to delete or edit
	 */
	private ActionButton deleteOrEdit = (String id, String type) -> {
		if (type.equals("edit")) {
			Rent rent = rentDao.getRentById(id);
			
			int idCar = rentDao.getIdCarById(id);
			double dailyCost = carDao.getCarById(String.valueOf(idCar)).getDailyCost();
			
			menuPanel.getContentPanel().removeAll();
			menuPanel.getContentPanel().add(new StepOneRentScreen(getFrameRentControl(), menuPanel, idCar, dailyCost, rent));
			menuPanel.getContentPanel().revalidate();
			menuPanel.getContentPanel().repaint();
			return;
		}
		if (rentDao.deleteRentById(Integer.parseInt(id))) {
			this.remove(scrollPane);
			tableSetup();
			this.revalidate();
			this.repaint();
			JOptionPane.showMessageDialog(null, "Locação excluída com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir locação!");
		}

	};

	/**
	 * Method that updates the screen with the table
	 */
	private void tableSetup() {
		rents = rentDao.listRents();
		CustomTable customTable = new CustomTable(deleteOrEdit, getDataTable());
		scrollPane = new JScrollPane(customTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 100, 789, 500);
		scrollPane.setBorder(null);
		this.add(scrollPane);
	}

	/**
	 * Method with the table object
	 * 
	 * @return Object[][]
	 */
	private Object[][] getDataTable() {
		Object[][] data = new Object[rents.size() + 1][4];
		data[0] = new Object[] { "Veículo", "Locatário", "Devolução", "ID" };
		for (int i = 0; i < rents.size(); i++) {
			Rent rentR = rents.get(i);
			String formattedDate = rentR.getDeliveryDate().substring(0, 2) + "/" + rentR.getDeliveryDate().substring(2, 4) + "/" + rentR.getDeliveryDate().substring(4);
			data[i + 1] = new Object[] { carDao.getModelById(rentR.getIdCar()), customerDao.getNameCustomerByCpf(rentR.getCpfCustomer()), formattedDate,
					rentR.getIdRent() };
		}
		return data;
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
	 * Returns a label
	 * 
	 * @return JLabel containing the button instance
	 */
	public JLabel getMessagerLabel() {
		return messagerLabel;
	}

	/**
	 * Define label changes
	 * 
	 * @param messagerLabel The label to be set
	 */
	public void setMessagerLabel(JLabel messagerLabel) {
		this.messagerLabel = messagerLabel;
	}

	/**
	 * Returns a button
	 * 
	 * @return JButtono containing the button instance
	 */
	public JButton getNewRent() {
		return newRent;
	}

	/**
	 * Define button changes
	 * 
	 * @param newRent The button to be set
	 */
	public void setNewRent(JButton newRent) {
		this.newRent = newRent;
	}

	/**
	 * Returns a list of customers
	 * 
	 * @return customer list
	 * 
	 */
	public List<Rent> getRent() {
		return rents;
	}

	/**
	 * Define the rent list
	 * 
	 * @param rents The list of rents to be defined
	 */
	public void setRent(List<Rent> rents) {
		this.rents = rents;
	}
}