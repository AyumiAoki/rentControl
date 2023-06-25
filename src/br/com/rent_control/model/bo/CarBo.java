package br.com.rent_control.model.bo;

import br.com.rent_control.model.dao.CarDao;
import br.com.rent_control.model.vo.Car;

/**
 * Class CarBo - Represents the bo (business object) of the car in the
 * application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class CarBo {

	private CarDao carDao;
	private Car car;

	/**
	 * Parameterless class constructor.
	 */
	public CarBo() {
		carDao = new CarDao();
	}

	/**
	 * Method that receives data from the view and forwards it to the dao to be
	 * added to the database.
	 * 
	 * @param listCar A list of car data that will be passed to dao.
	 * @return boolean true or false if it was possible to add a car.
	 */
	public boolean addCar(String[] listCar) {
		car = new Car();
		car.setCategory(listCar[0]);
		car.setModelCar(listCar[1]);
		car.setMaxPassengers(Integer.parseInt(listCar[2]));
		car.setTrunkSize(Double.parseDouble(listCar[3].replace(",", ".")));
		car.setTransmissionType(listCar[4]);
		car.setFuelType(listCar[5]);
		car.setConsumptionAverage(Double.parseDouble(listCar[6].replace(",", ".")));
		car.setDailyCost(Double.parseDouble(listCar[7].replace(",", ".")));
		car.setHasAc((listCar[8].equals("Sim") ? true : false));
		car.setHasAirbag((listCar[9].equals("Sim") ? true : false));
		car.setHasAbsBrakes((listCar[10].equals("Sim") ? true : false));
		car.setHasDvdPlayer((listCar[11].equals("Sim") ? true : false));

		if (carDao.addCar(car))
			return true;
		else
			return false;
	}

	/**
	 * Method that receives data from the view and forwards it to the dao to be
	 * updated to the database.
	 * 
	 * @param listCar A list of car data that will be passed to dao.
	 * @param id      The id of the car that will be updated.
	 * @return boolean true or false if it was possible to update a car.
	 */
	public boolean updateCar(String[] listCar, int id) {
		car = new Car();
		car.setCategory(listCar[0]);
		car.setModelCar(listCar[1]);
		car.setMaxPassengers(Integer.parseInt(listCar[2]));
		car.setTrunkSize(Double.parseDouble(listCar[3].replace(",", ".")));
		car.setTransmissionType(listCar[4]);
		car.setFuelType(listCar[5]);
		car.setConsumptionAverage(Double.parseDouble(listCar[6].replace(",", ".")));
		car.setDailyCost(Double.parseDouble(listCar[7].replace(",", ".")));
		car.setHasAc((listCar[8].equals("Sim") ? true : false));
		car.setHasAirbag((listCar[9].equals("Sim") ? true : false));
		car.setHasAbsBrakes((listCar[10].equals("Sim") ? true : false));
		car.setHasDvdPlayer((listCar[11].equals("Sim") ? true : false));
		car.setId(id);

		if (carDao.updateCar(car))
			return true;
		else
			return false;
	}
}