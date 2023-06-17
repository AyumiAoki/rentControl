package br.com.rent_control.view.components;

import java.awt.*;
import javax.swing.*;

/**
 * Class OptionsMenuButton - Represents the options menu button in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class OptionsMenuButton extends JButton {

	private static final long serialVersionUID = 2371912274022254839L;
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	private Icon iconCollapsed;
	private Icon iconExpanded;
	private JButton optionMenuButton;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public OptionsMenuButton(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		optionMenuButton = new JButton(this.text);
		optionMenuButton.setBounds(this.x, this.y, this.width, this.height);
		optionMenuButton.setBackground(ColorUtils.BUTTON_COLOR);
		optionMenuButton.setFocusPainted(false);
		optionMenuButton.setForeground(Color.WHITE);
		optionMenuButton.setFont(optionMenuButton.getFont().deriveFont(Font.BOLD, 14));
		optionMenuButton.setBorder(null);
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
	 * @return o optionMenuButton
	 */
	public JButton getOptionMenuButton() {
		return optionMenuButton;
	}

	/**
	 * @param optionMenuButton o optionMenuButton a ser configurado
	 */
	public void setOptionMenuButton(JButton optionMenuButton) {
		this.optionMenuButton = optionMenuButton;
	}
}
