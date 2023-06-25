package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.EmployeeDao;
import br.com.rent_control.model.vo.Employee;

/**
 * Class EmployeeBo - Represents the bo (business object) of the employee in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class EmployeeBo {

	private EmployeeDao employeeDao;

	/**
	 * Parameterless class constructor.
	 */
	public EmployeeBo() {
		this.employeeDao = new EmployeeDao();
	}

	/**
	 * Employee authentication method, verifies that the login data are correct and
	 * interacts with the employee's dao
	 * 
	 * @param nickname The nickname of the employee who wants to log in
	 * @param password The password of the employee who wants to login
	 * @return boolean true or false confirming the login data is correct or not
	 */
	public boolean authenticateEmployee(String nickname, String password) {
		Employee employee = employeeDao.getEmployeeByNickname(nickname);
		if (employee != null && employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}