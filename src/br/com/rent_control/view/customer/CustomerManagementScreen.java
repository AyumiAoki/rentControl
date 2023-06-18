package br.com.rent_control.view.customer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.rent_control.controller.RentControl;
import br.com.rent_control.view.components.ColorUtils;

public class CustomerManagementScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private final RentControl frameRentControl;
	private JLabel messagerLabel;
	private JLabel nameLabel;
	private JLabel cpfLabel;
	private JLabel cnhLabel;
	private JLabel validityCnhLabel;
	private JButton newButton;
	
	private ImageIcon imageIcon;

	
	public CustomerManagementScreen(final RentControl frameRentControl) {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		
		this.frameRentControl = frameRentControl;
		messagerLabel = new JLabel("Clientes");
		messagerLabel.setBounds(50, 24, 320, 15);
		messagerLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 16));
		
		newButton = new JButton("Novo");
		newButton.setForeground(Color.WHITE);
		newButton.setBounds(706, 34, 80, 34);
		newButton.setBackground(ColorUtils.PRIMARY_LIGHT_COLOR);
		newButton.setBorder(null);
		
//		imageIcon =  new ImageIcon("src/br/com/rent_control/view/images/tableHeader.png");
//		JLabel label = new JLabel(imageIcon);
//		label.setBounds(30, 100, 789, 43);
//		add(label);
		
		JPanel panel = new JPanel(new GridLayout(2, 2));

        // Create JLabels for each cell
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");
        JLabel label4 = new JLabel("Label 4");

        // Add the labels to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        
        add(panel);
		
		nameLabel = new JLabel("Paulo Ribeiro");
		nameLabel.setBounds(49, 154, 165, 24);
		nameLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 14));
		
		cpfLabel = new JLabel("70214855228");
		cpfLabel.setBounds(222, 154, 114, 24);
		cpfLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 14));
		
		cnhLabel = new JLabel("70214855228");
		cnhLabel.setBounds(378, 154, 114, 24);
		cnhLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 14));
		
		cnhLabel = new JLabel("70214855228");
		cnhLabel.setBounds(450, 154, 114, 24);
		cnhLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 14));
		
		validityCnhLabel = new JLabel("17/06/2000");
		validityCnhLabel.setBounds(450, 154, 114, 24);
		validityCnhLabel.setFont(messagerLabel.getFont().deriveFont(Font.BOLD, 14));
		
		
		
//		add(cnhLabel);
//		add(cpfLabel);
//		add(nameLabel);
//		
//		add(newButton);
		
		add(messagerLabel);
	}
	
	

	/**
	 * @return o frameRentControl
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}
}
