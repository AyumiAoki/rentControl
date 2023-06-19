package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.UserDao;
import br.com.rent_control.model.vo.User;

/**
 * Class UserBo - Represents the bo (business object) of the user in the application
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class UserBo {
	
	private UserDao userDao;
	private User user;
	
	/**
	 * Parameterless class constructor.
	 */	
	public UserBo() {
		userDao = new UserDao();
	}
	
	public boolean addUser(String[] listUser) {
		user = new User();
		
		user.setName(listUser[0]);
		user.setCpf(listUser[1]);
		user.setLicenseNumber(Integer.parseInt(listUser[2]));
		user.setDateOfBirth(listUser[3]);
		
		if (userDao.addUser(user))
			return true;
		else
			return false;
	}
}