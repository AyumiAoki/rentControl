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
 * @author ayumi
 *
 */

public class RentalScreen extends JPanel{

	private static final long serialVersionUID = 711225098574938352L;
	private final RentControl frameRentControl;
	private MenuPanel menuPanel;
	private JLabel mensage;

	public RentalScreen(final RentControl frameRentControl, MenuPanel menuPanel) {
		setLayout(null);
		setBackground(Color.WHITE);
		
		this.frameRentControl = frameRentControl;
		this.menuPanel = menuPanel;
		
		JPanel jp = new JPanel(new GridLayout(0,3, 10, 10));
		jp.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.WHITE, 0), new EmptyBorder(15, 15, 15, 10)));
        
        CarDao carDao = new CarDao();
        
        if(carDao.listCars().size() == 0) {
        	mensage = new JLabel("Nenhum carro disponível para aluguel!");
        	mensage.setForeground(ColorUtils.PRIMARY_COLOR);
        	mensage.setFont(mensage.getFont().deriveFont(Font.BOLD, 18));
        	mensage.setBounds(0, 322, 886, 25);
        	mensage.setHorizontalAlignment(JLabel.CENTER);
    		add(mensage);
        } else {
        	for (Car car : carDao.listCars()) {
    			CarCardPanel card = new CarCardPanel(car, this.getMenuPanel());
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
}
