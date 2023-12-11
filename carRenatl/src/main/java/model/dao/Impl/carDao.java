package model.dao.Impl;

import java.util.List;

import domain.Car;
import model.dao.api.AbstractDao;
import model.dao.api.GenericDao;
import model.mapping.Impl.CarMapper;

public class carDao extends AbstractDao<Car>{

	@Override
	public int insertItem(Car item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Car> getAllItems() {
		// ::BigINT Explicite casting 
		return queryForObjects("SELECT * FROM car_table WHERE car_id=?::BIGINT", new CarMapper());
		
	}

	@Override
	public Car getItemById(long id) {
		// TODO Auto-generated method stub
		return  queryForObject("SELECT * FROM car_table WHERE car_id=?::BIGINT", new CarMapper(),String.valueOf(id));
	}

	@Override
	public int updateItem(Car item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItemById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
