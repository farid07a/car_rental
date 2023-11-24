package model.dao.Impl;
import java.util.List;

import domain.User;
import model.dao.GenericDao;

public class UserDao implements GenericDao<User>{

	@Override
	public int insertItem(User item) {
		
		return 0;
	}

	@Override
	public List<User> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getItemById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(User item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItemById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
