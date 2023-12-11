package model.dao.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.mapping.GenericMapper;

public abstract class AbstractDao<T> implements GenericDao<T>{
	
	// we need connection variable 
	private Connection connection;
	private static final Logger LOGGER = LogManager.getLogger();
	//we create empty constructor dependency injection 
	
	public AbstractDao() {
		// TODO Auto-generated constructor stub
	}
	
	// this for initialize connection 
	public AbstractDao(Connection connection) {
		this.connection=connection;
	}
	
	
	
	//CRUD Operations
	// Read
	// Protect because for extend and use this method

	// return list T
	/**
	 * convention name like spring or jdbc template quertforObject
	 * 
	 * @param query
	 * @param mapper
	 * We use Class interface generic for mapper class and with this interface 
	 * we can use child class user in concret method
	 * we user for other methods we use  parent class and after implement or extent with concrete class
	 * use child class
	 * @return
	 */
	
	
	protected List<T> queryForObjects(final String query, GenericMapper<T> mapper,String... parameters) {
		List <T> items = new ArrayList<>();
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			fillPreparedStatementWithObjects(statement,query);
			
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				T item = mapper.mapItem(result);
				items.add(item);
				
			}
			
		}catch (SQLException	 e) {
				LOGGER.error("Unable to process Query "+query+"!"+e.getMessage());
		}
		return items;
	}
	
	// we make private because i not used outer this class used only this class
	/**
	 * No Return type
	 * @param statement
	 * @param query
	 * @throws SQLException 
	 */
	private  void fillPreparedStatementWithObjects(final PreparedStatement statement,final  String...parameters) throws SQLException {
		
		for (int i = 1; i < parameters.length+1; i++) 
		{
			statement.setObject(i, parameters[i-1]);
		}
	}

	protected T queryForObject(final String query,final GenericMapper<T> mapper,String... parameters) {
		List<T> items =queryForObjects(query, mapper,parameters);
		if (items.size()==1) return items.get(0);		
		else return null; 
	}
	
	
	
}
