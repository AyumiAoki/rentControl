package br.com.rent_control.view;

import java.awt.*;
import javax.swing.*;
import br.com.rent_control.controller.*;
import br.com.rent_control.view.components.ColorUtils;

/**
 * Class LoginScreen - Represents a screen the login in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class LoginScreen extends JPanel {

	private static final long serialVersionUID = 7811418568475134687L;

	private final ImageIcon backgroundPanel;

	private final RentControl frameRentControl;

	private final JLabel nameLabel;
	private final JLabel passwordLabel;

	private JButton signInButton;
	private JTextField nameField;
	private JPasswordField passwordField;

	private LoginController loginController;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param frameRenteControl
	 */
	public LoginScreen(final RentControl frameRenteControl) {

		setLayout(null);
		backgroundPanel = new ImageIcon(getClass().getResource("/br/com/rent_control/view/images/backgroundLogin.png"));
		this.frameRentControl = frameRenteControl;

		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(630, 230, 40, 14);
		passwordLabel = new JLabel("Senha");
		passwordLabel.setBounds(630, 319, 45, 14);

		nameField = new JTextField();
		nameField.setBounds(630, 252, 400, 35);
		nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		nameField.setCaretColor(Color.black);
		nameField.setEditable(true);

		passwordField = new JPasswordField();
		passwordField.setBounds(630, 341, 400, 35);
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		passwordField.setCaretColor(Color.black);
		passwordField.setEditable(true);

		signInButton = new JButton("Entrar");
		signInButton.setForeground(Color.WHITE);
		signInButton.setBounds(720, 544, 240, 35);
		signInButton.setBackground(ColorUtils.PRIMARY_COLOR);
		signInButton.setBorder(null);

		add(nameLabel);
		add(nameField);
		add(passwordLabel);
		add(passwordField);
		add(signInButton);

		loginController = new LoginController(this);
		signInButton.addActionListener(e -> loginController.signInButtonClicked());
	}

	/**
	 * Returns the Jframe of the application.
	 * 
	 * @return RentControl containing the application frame instance.
	 */
	public RentControl getFrameRentControl() {
		return frameRentControl;
	}

	/**
	 * Returns a button
	 * 
	 * @return JButtono containing the button instance
	 */
	public JButton getSignInButton() {
		return signInButton;
	}

	/**
	 * Returns a text field
	 * 
	 * @return JTextField containing the text field instance
	 */
	public JTextField getNameField() {
		return nameField;
	}

	/**
	 * Returns the password field
	 * 
	 * @return JPasswordField containing the instance of the password field
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundPanel.getImage(), 0, 0, backgroundPanel.getIconWidth(), backgroundPanel.getIconHeight(),
				this);
	}
}
