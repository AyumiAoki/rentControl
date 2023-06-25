package br.com.rent_control.model.dao;

import java.sql.*;
import java.util.*;
import br.com.rent_control.model.ConnectionDB;
import br.com.rent_control.model.vo.RentalAddresses;

/**
 * Class RentalAddressesDao - Represents the data of the rental company
 * addresses in the application
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 */

public class RentalAddressesDao {

	/**
	 * Method that returns a list of all rental company addresses registered in the
	 * database.
	 * 
	 * @return mailing list
	 */
	public List<RentalAddresses> listLocations() {
		List<RentalAddresses> locations = new ArrayList<RentalAddresses>();

		String sql = "SELECT * FROM rentalAddresses";

		try (Connection connection = ConnectionDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				RentalAddresses address = new RentalAddresses();

				address.setLocation(rs.getString(RentalAddresses.COLUMN_ADDRESS));
				locations.add(address);
			}
			return locations;
		} catch (SQLException e) {
			System.err.println("Erro ao listar endereços: " + e.getMessage());
		}
		return null;
	}
}