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
        Car carro = new Car();

        // Criar um card com informações iniciais
        CarCardPanel card = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card2 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card3 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card4 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card5 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card6 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card7 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card8 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card9 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card10 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");

        // Adicionar o card ao painel
        jp.add(card2);
        jp.add(card3);
        jp.add(card4);
        jp.add(card5);
//        jp.add(card6);
//        jp.add(card7);
//        jp.add(card8);
//        jp.add(card9);
//        jp.add(card10);
        

		JScrollPane js = new JScrollPane(jp);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setBounds(10, 10, 866, 655);
		add(js);
	}
}
