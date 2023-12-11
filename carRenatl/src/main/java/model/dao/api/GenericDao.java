package model.dao.api;

import java.util.List;

public interface GenericDao <T>{// Type means Type (enum,class)
	//CRUD
	
	// Create
	int insertItem(T item);
	
	// Read 01
	List <T> getAllItems();
	
	//Read 02
	
	T getItemById(long id);
	
	//Update
	int updateItem(T item);
	
	//Delete
	
	int deleteItemById(long id);
	
	
}
