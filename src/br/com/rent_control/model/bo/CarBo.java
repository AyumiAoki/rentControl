package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;

/**
 * Class CarBo - Represents the bo (business object) of the car in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @version 1.0, 2023-06-08
 */

public class CarBo {

	private CarDao carDao;

	/**
	 * Parameterless class constructor.
	 */
	public CarBo() {
		this.carDao = new CarDao();
	}

	public boolean addCar(Car car) {
//		Car car = carDao.getEmployeeByNickname(nickname);
//		if (car != null && car.getPassword().equals(password)) {
//			return true;
//		}
		return false;
	}

}