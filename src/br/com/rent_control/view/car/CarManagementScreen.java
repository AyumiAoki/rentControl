package br.com.rent_control.view.car;

import java.util.List;
import java.awt.*;
import javax.swing.*;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.dao.RentDao;
import br.com.rent_control.controller.*;
import br.com.rent_control.controller.car.CarManagementController;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.*;
import br.com.rent_control.view.customer.CustomerManagementScreen.ActionButton;

/**
 * @author ayumi
 *
 */

public class CarManagementScreen extends JPanel {

	private static final long serialVersionUID = -1189731144824553401L;
	private JButton newCar;
	private CarDao carDao;
	private List<Car> cars;
	private JScrollPane scrollPane;
	private MenuPanel menuPanel;
	private final RentControl frameRentControl;

	public CarManagementScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.white);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;

		JLabel messagerLabel = new JLabel("Veículos");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));

		newCar = new JButton("Novo");
		newCar.setForeground(Color.WHITE);
		newCar.setBounds(750, 20, 80, 34);
		newCar.setBackground(ColorUtils.PRIMARY_COLOR);
		newCar.setBorder(null);

		add(newCar);
		add(messagerLabel);
		carDao = new CarDao();
		tableSetup();

		new CarManagementController(this);
	}

	private ActionButton deleteOrEdit = (String id, String type) -> {
		if (type.equals("edit")) {
			Car car = carDao.getCarById(id);
			menuPanel.getContentPanel().removeAll();
			menuPanel.getContentPanel().add(new AddCarScreen(getFrameRentControl(), menuPanel, car));
			menuPanel.getContentPanel().revalidate();
			menuPanel.getContentPanel().repaint();
			return;
		} else {
			RentDao rentDao = new RentDao();
			if (rentDao.isCarIdInRent(Integer.parseInt(id))) {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir o veículo, pois ele está alocado!");
			} else {
				if (carDao.deleteCarById(Integer.parseInt(id))) {
					this.remove(scrollPane);
					tableSetup();
					this.revalidate();
					this.repaint();
					JOptionPane.showMessageDialog(null, "Veículo excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir veículo!");
				}
			}
		}
	};

	private void tableSetup() {
		cars = carDao.listCars();
		CustomTable customTable = new CustomTable(deleteOrEdit, getDataTable());
		scrollPane = new JScrollPane(customTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 100, 789, 500);
		scrollPane.setBorder(null);
		this.add(scrollPane);
	}

	private Object[][] getDataTable() {
		Object[][] data = new Object[cars.size() + 1][4];
		data[0] = new Object[] { "Categoria", "Modelo", "Qtd", "ID" };
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			data[i + 1] = new Object[] { car.getCategory(), car.getModelCar(), car.getMaxPassengers(), car.getId() };
		}
		return data;
	}

	/**
	 * @return o newCar
	 */
	public JButton getNewCar() {
		return newCar;
	}

	/**
	 * @param newCar o newCar a ser configurado
	 */
	public void setNewCar(JButton newCar) {
		this.newCar = newCar;
	}

	/**
	 * @return o scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane o scrollPane a ser configurado
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
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
}
