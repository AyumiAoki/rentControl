package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.vo.Customer;

/**
 * Class CustomerBo - Represents the bo (business object) of the customer in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class CustomerBo {
	
	private CustomerDao customerDao;
	private Customer customer;
	
	/**
	 * Parameterless class constructor.
	 */	
	public CustomerBo() {
		customerDao = new CustomerDao();
	}
	
	public boolean addCustomer(String[] listCustomer) {
		customer = new Customer();
		
		customer.setName(listCustomer[0]);
		customer.setCpf(listCustomer[1]);
		customer.setLicenseNumber(Long.parseLong(listCustomer[2]));
		customer.setDateOfBirth(listCustomer[3]);
		
		if (customerDao.addCustomer(customer))
			return true;
		else
			return false;
	}
}