package br.com.rent_control.view.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import br.com.rent_control.view.customer.CustomerManagementScreen.ActionButton;

/**
 * Class CustomTable - Represents a custom table
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CustomTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private ActionButton actionButton;

	/**
	 * Class constructor with parameter.
	 * 
	 * @param actionButton The actions that the button should perform.
	 * @param data         The data the table should display.
	 */
	public CustomTable(ActionButton actionButton, Object[][] data) {
		this.actionButton = actionButton;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);

		GridLayout layout = new GridLayout(1, data[0].length + 2);
		layout.setHgap(50);

		for (int row = 0; row < data.length; row++) {
			JPanel panel = new JPanel(layout);
			panel.setBorder(null);
			panel.setBackground(Color.white);
			panel.setBorder(new EmptyBorder(10, 10, 10, 10));

			if (row == 0) {
				panel.setBackground(new Color(243, 246, 249));
			}
			for (int col = 0; col < data[row].length; col++) {
				Object cell = data[row][col];

				if (col + 1 == data[row].length && row == 0) {
					displayLabel("Editar", panel, Font.BOLD);
					displayLabel("Excluir", panel, Font.BOLD);
				} else {
					if (col == data[row].length - 1) {
						displayIcon(cell.toString(), "edit", panel);
						displayIcon(cell.toString(), "trash", panel);
					} else {
						if (row == 0) {
							displayLabel(cell.toString(), panel, Font.BOLD);
						} else {
							displayLabel(cell.toString(), panel, 400);
						}

					}
				}
			}

			add(panel);
		}

		if (data.length < 15) {
			add(Box.createVerticalStrut(31 * (15 - data.length)));
		}
	}

	/**
	 * Method that displayed the label
	 * 
	 * @param label
	 * @param panel
	 * @param fontWeight
	 */
	private void displayLabel(String label, JPanel panel, int fontWeight) {
		JLabel newLabel = new JLabel(label);
		newLabel.setFont(newLabel.getFont().deriveFont(fontWeight, 14));
		panel.add(newLabel);
	}

	/**
	 * Method that displays the icon
	 * 
	 * @param id
	 * @param path
	 * @param panel
	 */
	private void displayIcon(String id, String path, JPanel panel) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("src/br/com/rent_control/view/images/" + path + ".png"));
		btn.setForeground(Color.WHITE);
		btn.setBackground(path.equals("edit") ? ColorUtils.WARNING_COLOR : ColorUtils.DANGER_COLOR);
		btn.setBorder(null);
		panel.add(btn);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionButton.action(id, path);
			}
		});
	}
}
