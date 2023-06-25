package br.com.rent_control.view.components;

import javax.swing.*;

/**
 * Class OptionsMenuButton - Represents the options menu button in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class OptionsMenuButton extends JButton {

	private static final long serialVersionUID = 2371912274022254839L;
	private String imagePath;
	private int y;
	private JButton button;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param imagePath
	 * @param y
	 */
	public OptionsMenuButton(String imagePath, int y) {
		this.imagePath = imagePath;
		this.y = y;

		button = new JButton();
		button.setBounds(0, this.y, 200, 40);
		button.setIcon(new ImageIcon("src/br/com/rent_control/view/images/" + this.imagePath));
		button.setFocusPainted(false);
		button.setBorder(null);
	}

	/**
	 * Returns a button
	 * 
	 * @return JButtono containing the button instance
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * Define button changes
	 * 
	 * @param optionMenuButton The button to be set
	 */
	public void setOptionMenuButton(JButton optionMenuButton) {
		this.button = optionMenuButton;
	}

	/**
	 * Returns the path where the image is located
	 * 
	 * @return Strind containing the image path
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Define the path where the image is located
	 * 
	 * @param imagePath The image path to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}