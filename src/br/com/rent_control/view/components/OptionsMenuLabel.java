/**
 * 
 */
package br.com.rent_control.view.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author ayumi
 *
 */
public class OptionsMenuLabel {

	private final JLabel label;
	private String imagePath;
	private int y;
	
	public OptionsMenuLabel(String imagePath, int y) {
		this.imagePath = imagePath;
		this.y = y;
		
		label = new JLabel(new ImageIcon(this.imagePath));
		label.setBounds(0, this.y, 200, 40);
	}

	/**
	 * @return o label
	 */
	public JLabel getLabel() {
		return label;
	}
}