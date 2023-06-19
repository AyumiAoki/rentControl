package br.com.rent_control.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import br.com.rent_control.model.dao.UserDao;
//import br.com.rent_control.model.vo.User;
import br.com.rent_control.view.customer.CreateCustomerScreen;

public class CreateCustomerController {
//	private UserDao dao;
	public CreateCustomerController(CreateCustomerScreen createCustomerScreen) {
		// TODO Auto-generated constructor stub
//		dao = new UserDao();
		createCustomerScreen.getAddButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				String name = createCustomerScreen.getNameField().getText();
//				String cpf = createCustomerScreen.getCpfField().getText();
//				String cnh = createCustomerScreen.getCnhField().getText();
//				String bh = createCustomerScreen.getDateOfBirthField().getText();
				
//				User user = new User(name, cpf, 122,  bh);
//				dao.addUser(user);
				
			}
		});
	}
}
