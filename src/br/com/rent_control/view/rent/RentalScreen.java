/**
 * 
 */
package br.com.rent_control.view.rent;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.rent_control.controller.RentControl;
import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;
import br.com.rent_control.view.MenuPanel;
import br.com.rent_control.view.components.ColorUtils;

/**
 * Class RentalScreen - Represents the vehicle rental screen in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentalScreen extends JPanel {

	private static final long serialVersionUID = 711225098574938352L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;
	private JLabel mensage;

	/**
	 * Class constructor with parameter.
	 * 
	 * @param frameRentControl
	 * @param menuPanel
	 */
	public RentalScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.WHITE);

		this.frameRentControl = frameRentControl;
		this.menuPanel = menuPanel;

		JPanel jp = new JPanel(new GridLayout(0, 3, 10, 10));
		jp.setBorder(
				BorderFactory.createCompoundBorder(new LineBorder(Color.WHITE, 0), new EmptyBorder(15, 15, 15, 10)));

		CarDao carDao = new CarDao();

		if (carDao.listAvailableCars().size() == 0) {
			mensage = new JLabel("Nenhum carro disponível para aluguel!");
			mensage.setForeground(ColorUtils.PRIMARY_COLOR);
			mensage.setFont(mensage.getFont().deriveFont(Font.BOLD, 18));
			mensage.setBounds(0, 322, 886, 25);
			mensage.setHorizontalAlignment(JLabel.CENTER);
			add(mensage);
		} else {
			for (Car car : carDao.listAvailableCars()) {
				CarCardPanel card = new CarCardPanel(car, this.getFrameRentControl(), this.getMenuPanel(), car.getId(),
						car.getDailyCost());
				jp.add(card);
			}
		}

		JScrollPane js = new JScrollPane(jp);
		jp.setBackground(Color.WHITE);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setBounds(0, 0, 886, 670);
		add(js);
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
}