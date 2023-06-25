package br.com.rent_control.view.customer;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.controller.customer.CustomerManagementController;
import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;
import br.com.rent_control.view.components.CustomTable;

public class CustomerManagementScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;
	private JScrollPane scrollPane;
	private JLabel messagerLabel;
	private JButton newCustomer;
	private List<Customer> customers;
	private CustomerDao customerDao;

	public interface ActionButton {
		void action(String id, String type);
	}

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
		newCustomer.setBackground(ColorUtils.PRIMARY_LIGHT_COLOR);
		newCustomer.setBorder(null);

		customerDao = new CustomerDao();

		tableSetup();

		add(newCustomer);
		add(messagerLabel);

		new CustomerManagementController(this);
	}

	private ActionButton deleteOrEdit = (String id, String type) -> {
		if (type.equals("edit")) {
			Customer customer = customerDao.getCustomerByCpf(id);
			menuPanel.getContentPanel().removeAll();
			menuPanel.getContentPanel().add(new AddCustomerScreen(getFrameRentControl(), menuPanel, customer));
			menuPanel.getContentPanel().revalidate();
			menuPanel.getContentPanel().repaint();
			return;
		}
		if (customerDao.deleteCustomerByCpf(id)) {
			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
			this.remove(scrollPane);
			tableSetup();
			this.revalidate();
			this.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!");
		}

	};

	private void tableSetup() {
		customers = customerDao.listCustomer();
		CustomTable customTable = new CustomTable(deleteOrEdit, getDataTable());
		scrollPane = new JScrollPane(customTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 100, 789, 500);
		scrollPane.setBorder(null);
		this.add(scrollPane);

	}

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
	 * @return the messagerLabel
	 */
	public JLabel getMessagerLabel() {
		return messagerLabel;
	}

	/**
	 * @param messagerLabel the messagerLabel to set
	 */
	public void setMessagerLabel(JLabel messagerLabel) {
		this.messagerLabel = messagerLabel;
	}

	/**
	 * @return the newCustomer
	 */
	public JButton getNewCustomer() {
		return newCustomer;
	}

	/**
	 * @param newCustomer the newCustomer to set
	 */
	public void setNewCustomer(JButton newCustomer) {
		this.newCustomer = newCustomer;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getUsers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setUsers(List<Customer> customers) {
		this.customers = customers;
	}
}