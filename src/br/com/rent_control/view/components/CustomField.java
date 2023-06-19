/**
 * 
 */
package br.com.rent_control.view.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author ayumi
 *
 */
public class CustomField extends JLabel{

	private static final long serialVersionUID = -8298706824076204539L;
	private final JLabel label;
	private JTextField textField;
	private JComboBox<String> comboBox;
	
	public CustomField(String text) {
		label = new JLabel(text);
		label.setBounds(111, 40, 320, 15);
		label.setFont(label.getFont().deriveFont(Font.BOLD, 16));
	}
	
	public CustomField(String text, int x, int y) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 15);
		
		textField = new JTextField("");
		textField.setBounds(x,y+23,320,35);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		textField.setCaretColor(Color.BLACK);
		textField.setEditable(true);
	}
	
	public CustomField(String text, int x, int y, String textValue) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 15);
		
		textField = new JTextField(textValue);
		textField.setBounds(x,y+23,320,35);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		textField.setCaretColor(ColorUtils.SECUNDARY_COLOR);
		textField.setEditable(true);
	}
	
	public CustomField(String text, int x, int y, String[] optionComboBox) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 15);
		
		comboBox = new JComboBox<>(optionComboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(x,y+23,320,35);
		comboBox.setBorder(null);
		comboBox.setEditable(false);
		comboBox.setFocusable(false);
		comboBox.setForeground(ColorUtils.PRIMARY_COLOR);
	}

	/**
	 * @return o label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * @return o textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @param textField o textField a ser configurado
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * @return o comboBox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @param comboBox o comboBox a ser configurado
	 */
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
}