package br.com.rent_control.controller.customer;

import java.util.*;
import javax.swing.JOptionPane;
import br.com.rent_control.model.bo.CustomerBo;
import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.view.customer.*;

public class AddCustomerController {
	
	private AddCustomerScreen addCustomerScreen;
	private CustomerBo customerBo;
	
	public AddCustomerController(AddCustomerScreen addCustomerScreen) {
		this.addCustomerScreen = addCustomerScreen;
		customerBo = new CustomerBo();
		addCustomerScreen.getAddButton().addActionListener(e -> buttonClicked());
	}
	
	public void buttonClicked() {
		String name = addCustomerScreen.getNameField().getTextField().getText();
		String cpf = addCustomerScreen.getCpfField().getTextField().getText();
		String licenseNumber = addCustomerScreen.getCnhField().getTextField().getText();
		String dateOfBirth = addCustomerScreen.getDateOfBirthField().getTextField().getText();
		
		if (!name.equals("") && !cpf.equals("") && !licenseNumber.equals("") && !dateOfBirth.equals("")) {
			
			
			
			if(addCustomerScreen.getAddButton().getText().equals("Salvar")) {
				editCustom(new Customer(name, cpf, Long.parseLong(licenseNumber), dateOfBirth));
			}else  {
				List<String> listCustomer = Arrays.asList(name, cpf, licenseNumber, dateOfBirth);
				createCustom(listCustomer);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
	
	private void editCustom(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		
		
		if(customerDao.updateCustomer(customer)) {
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
			openCustomerManagementScreen();
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!");
		}
	}
	
	private void createCustom(List<String> listCustomer) {
		if(customerBo.addCustomer(listCustomer.toArray(new String[0]))) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

			openCustomerManagementScreen();
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
		}
	}
	
	private void openCustomerManagementScreen() {
		addCustomerScreen.setVisible(false);

		addCustomerScreen.getMenuPanel().getContentPanel().removeAll();
		addCustomerScreen.getMenuPanel().getContentPanel().add(new CustomerManagementScreen(addCustomerScreen.getFrameRentControl(), addCustomerScreen.getMenuPanel()));
		addCustomerScreen.getMenuPanel().getContentPanel().revalidate();
		addCustomerScreen.getMenuPanel().getContentPanel().repaint();
	}
}
