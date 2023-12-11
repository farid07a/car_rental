package model.dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.User;
import domain.UserRole;
import model.config.dbConnection;
import model.dao.api.AbstractDao;
import model.dao.api.GenericDao;
import model.mapping.Impl.UserMapper;

// this implementation is for befor abstraction and only with interface

//public class UserDao implements GenericDao<User>{
public class UserDao extends AbstractDao<User>{
	private static final String DELETE_USER_BY_ID = "DELETE FROM user_table WHERE user_id = ?";
	// casting in postgres :: BIGINT
	private static final String SELECT_USER_BY_ID = "SELECT * FROM user_table WHERE user_id = ? ";
	private static final String SELECT_ALL_USER = "SELECT * FROM user_table";
	private static final Logger LOGGER = LogManager.getLogger();
	//private Connection connection =new dbConnection().getConnection();
	private Connection connection;
	
	private static final String INSERT_USER="INSERT INTO user_table "
			+ "(user_name,user_email,user_password,user_address,user_blocked,user_role) "
			+ "VALUES (?,?,?,?,?,?)";
	
	private static final String UPDATE_USER="UPDATE user_table SET user_name=?, user_email=?, user_password=?, user_address=?, user_blocked=?,user_role=?"
			+ " WHERE user_id =? ";
	
	
	public UserDao() {
		this.connection=new dbConnection().getConnection();
	}
	
	public UserDao(final Connection connection) {
		super(connection);
		this.connection=connection;
	}
	
	
	@Override
	public int insertItem(User item) {
		try {
			
			PreparedStatement prstm= connection.prepareStatement(INSERT_USER);
			prstm.setString(1, item.getUserName()); // PrepareStatment Not Array for starting with 0 but start with 1
			prstm.setString(2, item.getUserEmail());
			prstm.setString(3, item.getUserPassword());
			prstm.setString(4, item.getUserAddress());
			prstm.setBoolean(5, item.isUserBlocked());
			prstm.setString(6, item.getUserRole().name());
			return prstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public List<User> getAllItems() {
		// Statement I can use statement for one time but i need this method many time Now changed use prepareStatement for best use 
		// and not recompile 
		/*List <User> users=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USER);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				// mapping Columns to User object (columns to attributes)
				 User user = new UserMapper().mapItem(resultSet);
				users.add(user);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// above code is before use abstraction class AbstractDao
		
		return queryForObjects(SELECT_ALL_USER, new UserMapper());
	}

	
	// very strong datatype
	@Override
	public User getItemById(final long id) {
		
//		PreparedStatement prstm;
//		User user=new User();
//		try {
//			prstm = connection.prepareStatement(SELECT_USER_BY_ID); // ? Generic means prepareStatement change ? by values 
//			prstm.setLong(1, id);
//			ResultSet resultset=prstm.executeQuery();
//			while (resultset.next()) {
//				user= new UserMapper().mapItem(resultset);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 // PrepareStatment Not Array for starting with 0 but start with 1
//		return user;
		return queryForObject(SELECT_USER_BY_ID, new UserMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(User item) {
try {
			
			PreparedStatement prstm= connection.prepareStatement(UPDATE_USER);
			
			// Mapping object to database columns
			prstm.setString(1, item.getUserName()); // PrepareStatment Not Array for starting with 0 but start with 1
			prstm.setString(2, item.getUserEmail());
			prstm.setString(3, item.getUserPassword());
			prstm.setString(4, item.getUserAddress());
			prstm.setBoolean(5, item.isUserBlocked());
			prstm.setString(6, item.getUserRole().name());
			prstm.setLong(7, item.getUserId());
			
			return prstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int deleteItemById(long id) {
		PreparedStatement prstm;
		try {
			prstm = connection.prepareStatement(DELETE_USER_BY_ID);
			prstm.setLong(1, id);
			return prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error("Error When delete User "+e.getMessage());
			
		} // ? Generic means prepareStatement change ? by values 
		
		return 0;
	}
	
	// use كضححهىل 
	
	// any helper method put in end of class
	/*
	private User getUser(ResultSet resultSet) throws SQLException {
		long userId = resultSet.getLong("user_id"); // 8 Bytes
		 String userName  = resultSet.getString("user_name"); 
		 String userEmail = resultSet.getString("user_email"); 
		 String userPassword = resultSet.getString("user_password"); 
		 String userAddress = resultSet.getString("user_address"); 
		 boolean userBlocked = resultSet.getBoolean("user_blocked"); 
		 UserRole userRole = UserRole.valueOf(resultSet.getString("user_role")); 
		User user=new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, userRole);
		return user;
	}
	*/
	// DRY - SOLID

}
