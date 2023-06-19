/**
 * 
 */
package br.com.rent_control.view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.rent_control.controller.CarManagementController;
import br.com.rent_control.controller.RentControl;
import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.view.components.ColorUtils;

/**
 * @author ayumi
 *
 */
public class CarManagementScreen  extends JPanel {

	private static final long serialVersionUID = -3655302663513376093L;
	private final RentControl frameRentControl;
	private JLabel messagerLabel;
	private MenuPanel menuPanel;
	private JButton newCustomer;
	private List<Car> cars;
	private CarDao carDao;
	private JScrollPane scrollPane;

	public interface ActionButton {
	    void action(String id, String type);
	}

	public CarManagementScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.WHITE);

		this.menuPanel = menuPanel;
		this.frameRentControl = frameRentControl;
		messagerLabel = new JLabel("Veículos");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));
		
		newCustomer = new JButton("Novo");
		newCustomer.setForeground(Color.WHITE);
		newCustomer.setBounds(750, 20, 80, 34);
		newCustomer.setBackground(ColorUtils.PRIMARY_LIGHT_COLOR);
		newCustomer.setBorder(null);


		carDao = new CarDao();
		
		//tableSetup();
		
		add(newCustomer);
		add(messagerLabel);
		
		new CarManagementController(this);
	}
	
	private ActionButton deleteOrEdit = (String id, String type) -> {
		if(type.equals("edit")) {
			System.out.println("Edição!");
			return;
		}
		System.out.println("Exclusão!");
		//carDao.deleteUserByCpf(id);
		this.remove(scrollPane);
		//tableSetup();
		this.revalidate();
		this.repaint();
	};
	
	private void tableSetup() {
		cars = carDao.listCars();
		//CustomTable customTable = new CustomTable(deleteOrEdit, getDataTable());
		//scrollPane = new JScrollPane(customTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 100, 789, 500);
        scrollPane.setBorder(null);
        this.add(scrollPane);
		
	}
	
	private Object[][] getDataTable(){
		Object[][] data = new Object[cars.size() + 1][4];
		data[0] = new Object[]{"Categoria", "Modelo", "Quantidade de passageiros", "Tipo de câmbio"};
		for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            data[i + 1] = new Object[]{car.getCategory(), car.getModelCar(), car.getMaxPassengers(), car.getTransmissionType()};
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
	 * @return the users
	 */
	public List<Car> getUsers() {
		return cars;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<Car> cars) {
		this.cars = cars;
	}	
}
