package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.vo.Customer;

/**
 * Class CustomerBo - Represents the bo (business object) of the customer in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
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

	/**
	 * Method that receives data from the view and forwards it to the dao to be
	 * added to the database.
	 * 
	 * @param listCustomer A list of customer data that will be passed to dao.
	 * @return boolean true or false if it was possible to add a customer.
	 */
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