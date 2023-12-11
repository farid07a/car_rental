package model.mapping.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Car;
import model.mapping.GenericMapper;

public class CarMapper implements GenericMapper<Car>{

	@Override
	public Car mapItem(ResultSet resultSet) throws SQLException {
		 long carId=resultSet.getLong(1);
		 String carModel=resultSet.getString(2);
		 String carReleaseYear=resultSet.getString(3);
		 String carColor=resultSet.getString(4);
		 String carCompany=resultSet.getString(5);
		
		return new Car(carId, carModel, carReleaseYear, carColor, carCompany);
	}

}
