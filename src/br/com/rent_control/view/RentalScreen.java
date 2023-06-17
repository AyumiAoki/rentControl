/**
 * 
 */
package br.com.rent_control.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.rent_control.model.vo.Car;

/**
 * @author ayumi
 *
 */

public class RentalScreen extends JPanel{

	private static final long serialVersionUID = 711225098574938352L;

	public RentalScreen() {
		setLayout(new GridLayout(2, 3, 10, 10));
		setBackground(Color.white);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
        Car carro = new Car("Grupo 2 - Compacto Sta", 8, 450, "manual", "gasolina", true, true, true, true, 50);

        // Criar um card com informações iniciais
        CarCardPanel card = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card2 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card3 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card4 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card5 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");
        CarCardPanel card6 = new CarCardPanel(carro, "Fiat uno top das galaxaias", "src/br/com/rent_control/view/images/logo_white.png");

        // Adicionar o card ao painel
        add(card);
        add(card2);
        add(card3);
        add(card4);
        add(card5);
        add(card6);
	}
}
