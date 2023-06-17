package br.com.rent_control.view.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Class OptionsMenuButton - Represents the options menu button in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class OptionsMenuButton extends JButton {

	private static final long serialVersionUID = 2371912274022254839L;
	private String text;
	private int y;
	private Icon iconCollapsed;
	private Icon iconExpanded;
	private JButton button;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public OptionsMenuButton(String text, int y) {
		this.text = text;
		this.y = y;
		
		button = new JButton(this.text);
		button.setBounds(0, this.y, 200, 35);
		button.setBackground(ColorUtils.BUTTON_COLOR);
		button.setFocusPainted(false);
		button.setForeground(Color.WHITE);
		button.setFont(button.getFont().deriveFont(Font.BOLD, 14));
		button.setBorder(new EmptyBorder(0, 16, 0, 0));
		button.setHorizontalAlignment(SwingConstants.LEFT);
	}

	/**
	 * @return o iconCollapsed
	 */
	public Icon getIconCollapsed() {
		return iconCollapsed;
	}

	/**
	 * @param iconCollapsed o iconCollapsed a ser configurado
	 */
	public void setIconCollapsed(Icon iconCollapsed) {
		this.iconCollapsed = iconCollapsed;
	}

	/**
	 * @return o iconExpanded
	 */
	public Icon getIconExpanded() {
		return iconExpanded;
	}

	/**
	 * @param iconExpanded o iconExpanded a ser configurado
	 */
	public void setIconExpanded(Icon iconExpanded) {
		this.iconExpanded = iconExpanded;
	}

	/**
	 * @return o button
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * @param button o button a ser configurado
	 */
	public void setOptionMenuButton(JButton optionMenuButton) {
		this.button = optionMenuButton;
	}
}
