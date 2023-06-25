package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.dao.RentDao;
import br.com.rent_control.model.vo.Customer;

/**
 * Class RentBo - Represents the bo (business object) of the rent in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class RentBo {
	
	private RentDao rentDao;
	private CustomerDao customerDao;
	private Customer customer;

	/**
	 * Parameterless class constructor.
	 */	
	public RentBo() {
		rentDao = new RentDao();
		customerDao = new CustomerDao();
	}
}