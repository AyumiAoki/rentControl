/**
 * 
 */
package br.com.rent_control.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;

/**
 * @author ayumi
 *
 */

public class RentalScreen extends JPanel{

	private static final long serialVersionUID = 711225098574938352L;

	public RentalScreen() {
		setLayout(null);
		setBackground(Color.white);
		JPanel jp = new JPanel(new GridLayout(0,3, 10, 10));
		jp.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        CarDao carDao = new CarDao();
        
        for (Car car : carDao.listCars()) {
			CarCardPanel card = new CarCardPanel(car);
			jp.add(card);
		}

		JScrollPane js = new JScrollPane(jp);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setBounds(10, 10, 866, 655);
		add(js);
	}
}
