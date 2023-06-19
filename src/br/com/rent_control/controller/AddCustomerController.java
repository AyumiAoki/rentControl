/**
 * 
 */
package br.com.rent_control.controller;

import br.com.rent_control.model.bo.UserBo;

/**
 * @author ayumi
 *
 */
public class AddCustomerController {
	
	private AddCustomerController addCustomerController;
	private UserBo userBo;
	
	public AddCustomerController(AddCustomerController addCustomerController) {
		this.addCustomerController = addCustomerController;
		userBo = new UserBo();
	}
}
