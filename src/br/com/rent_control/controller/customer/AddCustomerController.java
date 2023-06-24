package br.com.rent_control.controller.customer;

import java.util.*;
import javax.swing.JOptionPane;
import br.com.rent_control.model.bo.CustomerBo;
import br.com.rent_control.view.customer.*;

public class AddCustomerController {
	
	private AddCustomerScreen addCustomerScreen;
	private CustomerBo customerBo;
	
	public AddCustomerController(AddCustomerScreen addCustomerScreen) {
		this.addCustomerScreen = addCustomerScreen;
		customerBo = new CustomerBo();
		addCustomerScreen.getAddButton().addActionListener(e -> createCustomButtonClicked());
	}
	
	public void createCustomButtonClicked() {
		String name = addCustomerScreen.getNameField().getTextField().getText();
		String cpf = addCustomerScreen.getCpfField().getTextField().getText();
		String licenseNumber = addCustomerScreen.getCnhField().getTextField().getText();
		String dateOfBirth = addCustomerScreen.getDateOfBirthField().getTextField().getText();
		
		if (!name.equals("") && !cpf.equals("") && !licenseNumber.equals("") && !dateOfBirth.equals("")) {
			List<String> listCustomer = Arrays.asList(name, cpf, licenseNumber, dateOfBirth);
			
			if(customerBo.addCustomer(listCustomer.toArray(new String[0]))) {
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

				addCustomerScreen.setVisible(false);

				addCustomerScreen.getMenuPanel().getContentPanel().removeAll();
				addCustomerScreen.getMenuPanel().getContentPanel().add(new CustomerManagementScreen(addCustomerScreen.getFrameRentControl(), addCustomerScreen.getMenuPanel()));
				addCustomerScreen.getMenuPanel().getContentPanel().revalidate();
				addCustomerScreen.getMenuPanel().getContentPanel().repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}
