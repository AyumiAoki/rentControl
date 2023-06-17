package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.EmployeeDao;
import br.com.rent_control.model.vo.Employee;

/**
 * Class EmployeeBo - Represents the bo (business object) of the employee in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class EmployeeBo {
	
	private EmployeeDao employeeDao;
	
	/**
	 * Parameterless class constructor.
	 */	
	public EmployeeBo() {
		this.employeeDao = new EmployeeDao();
	}
	
	public boolean authenticateEmployee(String nickname, String password) {
        Employee employee = employeeDao.getEmployeeByNickname(nickname);
        if (employee != null && employee.getPassword().equals(password)) {
            return true; 
        }
        return false;
    }
}