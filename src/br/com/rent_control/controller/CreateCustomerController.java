package br.com.rent_control.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.rent_control.model.bo.UserBo;
import br.com.rent_control.view.ContentPanel;
//import br.com.rent_control.model.dao.UserDao;
//import br.com.rent_control.model.vo.User;
import br.com.rent_control.view.customer.CreateCustomerScreen;
import br.com.rent_control.view.customer.CustomerManagementScreen;

public class CreateCustomerController {
	
	private CreateCustomerScreen createCustomerScreen;
	private UserBo userBo;
	
	public CreateCustomerController(CreateCustomerScreen createCustomerScreen) {
		this.createCustomerScreen = createCustomerScreen;
		userBo = new UserBo();
		createCustomerScreen.getAddButton().addActionListener(e -> createCustomButtonClicked());
	}
	
	public void createCustomButtonClicked() {
		String name = createCustomerScreen.getNameField().getTextField().getText();
		String cpf = createCustomerScreen.getCpfField().getTextField().getText();
		String licenseNumber = createCustomerScreen.getCnhField().getTextField().getText();
		String dateOfBirth = createCustomerScreen.getDateOfBirthField().getTextField().getText();
		
		if (!name.equals("") && !cpf.equals("") && !licenseNumber.equals("") && !dateOfBirth.equals("")) {
			List<String> listUser = Arrays.asList(name, cpf, licenseNumber, dateOfBirth);
			
			if(userBo.addUser(listUser.toArray(new String[0]))) {
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

				createCustomerScreen.setVisible(false);

				createCustomerScreen.getMenuPanel().getContentPanel().removeAll();
				createCustomerScreen.getMenuPanel().getContentPanel().add(new CustomerManagementScreen(createCustomerScreen.getFrameRentControl(), createCustomerScreen.getMenuPanel()));
				createCustomerScreen.getMenuPanel().getContentPanel().revalidate();
				createCustomerScreen.getMenuPanel().getContentPanel().repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}
