package model.dao.Impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Car;

public class carDaoTest {
	
	private model.dao.Impl.carDao carDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertItem() {
	}

	@Test
	public void testGetAllItems() {
		List<Car> cars=carDao.getAllItems();
		System.out.println("size cars "+cars.size());
		assertEquals(100, cars.size());
	}

	@Test
	public void testGetItemById() {
	}

	@Test
	public void testUpdateItem() {
	}

	@Test
	public void testDeleteItemById() {
	}

}
