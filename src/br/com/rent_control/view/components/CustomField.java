package br.com.rent_control.view.components;

import java.awt.*;
import javax.swing.*;

/**
 * Class CustomField - Represents text fields with their labels
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CustomField extends JLabel {

	private static final long serialVersionUID = -8298706824076204539L;
	private final JLabel label;
	private JTextField textField;
	private JComboBox<String> comboBox;

	/**
	 * Class constructor with parameter, indicates a label title.
	 * 
	 * @param text
	 * @param y
	 */
	public CustomField(String text, int y) {
		label = new JLabel(text);
		label.setBounds(111, y, 320, 20);
		label.setFont(label.getFont().deriveFont(Font.BOLD, 16));
	}

	/**
	 * Class constructor with parameter, indicates an editable text field.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 */
	public CustomField(String text, int x, int y) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		textField = new JTextField("");
		textField.setBounds(x, y + 28, 320, 35);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		textField.setCaretColor(Color.BLACK);
		textField.setEditable(true);
	}

	/**
	 * Class constructor with parameter, indicates a non-editable text field.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param textValue
	 */
	public CustomField(String text, int x, int y, String textValue) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		textField = new JTextField(textValue);
		textField.setBounds(x, y + 28, 320, 35);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		textField.setCaretColor(Color.BLACK);
		textField.setEditable(false);
	}

	/**
	 * Class constructor with parameter, indicates an update text field, which is
	 * already filled with some information, but can be edited.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param textValue
	 * @param enable
	 */
	public CustomField(String text, int x, int y, String textValue, boolean enable) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		textField = new JTextField(textValue);
		textField.setBounds(x, y + 28, 320, 35);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		textField.setCaretColor(Color.BLACK);
		textField.setEditable(enable);
	}

	/**
	 * class constructor with parameter, indicates a box of options that can be
	 * selected.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param optionComboBox
	 */
	public CustomField(String text, int x, int y, String[] optionComboBox) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		comboBox = new JComboBox<>(optionComboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(x, y + 28, 320, 35);
		comboBox.setBorder(null);
		comboBox.setEditable(false);
		comboBox.setFocusable(false);
		comboBox.setForeground(Color.BLACK);
	}

	/**
	 * class constructor with parameter, indicates an option box that is already
	 * filled with database information and can be updated.
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param optionComboBox
	 * @param value
	 */
	public CustomField(String text, int x, int y, String[] optionComboBox, String value) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		comboBox = new JComboBox<>(optionComboBox);
		comboBox.setSelectedIndex(getIndexByValue(optionComboBox, value));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(x, y + 28, 320, 35);
		comboBox.setBorder(null);
		comboBox.setEditable(false);
		comboBox.setFocusable(false);
		comboBox.setForeground(Color.BLACK);
	}

	/**
	 * @param text
	 * @param x
	 * @param y
	 * @param optionComboBox
	 * @param value
	 */
	public CustomField(String text, int x, int y, String[] optionComboBox, boolean value) {
		label = new JLabel(text);
		label.setBounds(x, y, 320, 20);

		comboBox = new JComboBox<>(optionComboBox);
		comboBox.setSelectedIndex(getIndexByValue(optionComboBox, value ? "Sim" : "Não"));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(x, y + 28, 320, 35);
		comboBox.setBorder(null);
		comboBox.setEditable(false);
		comboBox.setFocusable(false);
		comboBox.setForeground(Color.BLACK);
	}

	/**
	 * Method that returns the index of an array element
	 * 
	 * @see <a href="https://chat.openai.com/">Retornar index do array</a>
	 * @param array
	 * @param value
	 * @return
	 */
	private int getIndexByValue(String[] array, String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns a label
	 * 
	 * @return JLabel containing the label instance
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * Returns a text field
	 * 
	 * @return JTextField containing the text field instance
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Defines text field changes
	 * 
	 * @param textField The text field to be defined
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Returns a combo box
	 * 
	 * @return JComboBox containing the combo box instance
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * Defines combo box changes
	 * 
	 * @param comboBox The combo box to be defined
	 */
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
}