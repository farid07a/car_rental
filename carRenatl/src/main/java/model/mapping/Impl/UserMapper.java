package model.mapping.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import domain.UserRole;
import model.mapping.GenericMapper;



public class UserMapper implements GenericMapper<User>{

	@Override
	public User mapItem(ResultSet resultSet) throws SQLException {
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
	

	
	
	

}
