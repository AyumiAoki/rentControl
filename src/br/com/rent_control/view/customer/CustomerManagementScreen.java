package br.com.rent_control.view.customer;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.customer.CustomerManagementController;
import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.dao.RentDao;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomTable;

/**
 * Class CustomerManagementScreen - Represents the client management screen
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CustomerManagementScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;
	private JScrollPane scrollPane;
	private JLabel messagerLabel;
	private JButton newCustomer;
	private List<Customer> customers;
	private CustomerDao customerDao;

	/**
	 * Interface that represents the action of the button
	 *
	 */
	public interface ActionButton {
		void action(String id, String type);
	}

	/**
	 * Class constructor with parameter.
	 * 
	 * @param frameRentControl
	 * @param menuPanel
	 */
	public CustomerManagementScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);

		this.frameRentControl = frameRentControl;
		this.menuPanel = menuPanel;
		messagerLabel = new JLabel("Clientes");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));

		newCustomer = new JButton("Novo");
		newCustomer.setForeground(Color.WHITE);
		newCustomer.setBounds(750, 20, 80, 34);
		newCustomer.setBackground(ColorUtils.PRIMARY_COLOR);
		newCustomer.setBorder(null);

		customerDao = new CustomerDao();

		tableSetup();

		add(newCustomer);
		add(messagerLabel);

		new CustomerManagementController(this);
	}

	/**
	 * Method that has the action to delete or edit
	 */
	private ActionButton deleteOrEdit = (String id, String type) -> {
		if (type.equals("edit")) {
			Customer customer = customerDao.getCustomerByCpf(id);
			menuPanel.getContentPanel().removeAll();
			menuPanel.getContentPanel().add(new AddCustomerScreen(getFrameRentControl(), menuPanel, customer));
			menuPanel.getContentPanel().revalidate();
			menuPanel.getContentPanel().repaint();
			return;
		} else {
			RentDao rentDao = new RentDao();
			if (rentDao.isCpfInRent(id)) {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente, pois ele tem uma alocação aberta!");
			} else {
				if (customerDao.deleteCustomerByCpf(id)) {
					JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
					this.remove(scrollPane);
					tableSetup();
					this.revalidate();
					this.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!");
				}
			}
		}
	};

	/**
	 * Method that updates the screen with the table
	 */
	private void tableSetup() {
		customers = customerDao.listCustomer();
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
		Object[][] data = new Object[customers.size() + 1][4];
		data[0] = new Object[] { "Nome", "CPF", "CNH", "ID" };
		for (int i = 0; i < customers.size(); i++) {
			Customer usuario = customers.get(i);
			data[i + 1] = new Object[] { usuario.getName(), usuario.getCpf(), usuario.getLicenseNumber(),
					usuario.getCpf() };
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
	public JButton getNewCustomer() {
		return newCustomer;
	}

	/**
	 * Define button changes
	 * 
	 * @param newCustomer The button to be set
	 */
	public void setNewCustomer(JButton newCustomer) {
		this.newCustomer = newCustomer;
	}

	/**
	 * Returns a list of customers
	 * 
	 * @return customer list
	 * 
	 */
	public List<Customer> getUsers() {
		return customers;
	}

	/**
	 * Define the customer list
	 * 
	 * @param customers The list of customers to be defined
	 */
	public void setUsers(List<Customer> customers) {
		this.customers = customers;
	}
}