/**
 * 
 */
package br.com.rent_control.controller;

import java.awt.BorderLayout;

import javax.swing.*;

import br.com.rent_control.model.bo.EmployeeBo;
import br.com.rent_control.view.ContentPanel;
import br.com.rent_control.view.LoginScreen;
import br.com.rent_control.view.MenuPanel;

/**
 * Class LoginController - Represents the login screen control in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class LoginController {

	private EmployeeBo employeeBo;
	private LoginScreen loginScreen;
	private ContentPanel contentPanel;

	/**
	 * Class constructor with parameters.
	 * 
	 * @param loginScreen
	 */
	public LoginController(LoginScreen loginScreen) {
		employeeBo = new EmployeeBo();
		contentPanel = new ContentPanel();
		this.loginScreen = loginScreen;
	}

	/**
	 * @return o contentPanel
	 */
	public ContentPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * @param contentPanel o contentPanel a ser configurado
	 */
	public void setContentPanel(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	/**
	 * Method that takes care of the actions when clicking on the login button
	 */
	public void signInButtonClicked() {
		String nickname = loginScreen.getNameField().getText();
		char[] passwordChars = loginScreen.getPasswordField().getPassword();
		String password = new String(passwordChars);

		if (!nickname.equals("") && !password.equals("")) {
			boolean authenticated = employeeBo.authenticateEmployee(nickname, password);

			if (authenticated) {
				loginScreen.setVisible(false);
				loginScreen.getFrameRentControl();

				MenuPanel menuPanel = new MenuPanel(loginScreen.getFrameRentControl(), getContentPanel());

				loginScreen.getFrameRentControl().add(menuPanel, BorderLayout.WEST);
				loginScreen.getFrameRentControl().add(contentPanel, BorderLayout.CENTER);
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}
