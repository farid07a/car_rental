package com.mainpackage.carRenatl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
import domain.User;
import domain.UserRole;
import model.config.dbConnection;
import model.dao.Impl.UserDao;
import util.PropertiesReader;
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	
    	
    	
		/*
		 * User us01=new domain.User(); us01.setUserName("Farid");
		 * us01.setUserRole(UserRole.ADMIN); System.out.println(us01);
		 * 
		 * 
		 * Properties properties_var=
		 * PropertiesReader.getProperties("src/main/resources/dbconnectionn.properties")
		 * ;
		 * 
		 * System.out.println("fileLengh"+properties_var.size());
		 * System.out.println("jdbcUrl:"+properties_var.getProperty("jdbcUrl"));
		 */
        //Connection connectionObj= new dbConnection().getConnection();
        
        //System.out.println("Success Connecting "+connectionObj);
        //System.out.println("Connection to which database:"+connectionObj.getCatalog());
        
    	
    	UserDao user_dao= new UserDao();
    	
//    	user_dao.insertItem(new User(1,"farid","farid master","pass","biskra",true,UserRole.ADMIN));
//    	user_dao.insertItem(new User(1,"mayar","mayar master","pass","biskra",true,UserRole.ADMIN));
//    	System.out.println("Succes Insert data ");
    	//user_dao.insertItem(null)
    	
    	System.out.println("======================= SELECT ALL =====================");
    	List<User> users=user_dao.getAllItems();
    	
    	System.out.println("Size of data in db :"+ users.size());
    	DisplayListUsersAfterUpdate(users);
    	
//    	System.out.println("======================= SELECT BY ID =====================");
//    	
//    	User user_by_id= user_dao.getItemById(103);
//    	System.out.println(user_by_id);
//    	
//    	System.out.println("======================= DELETE =====================");
//    	System.out.println("Delete User By Id"+user_dao.deleteItemById(102));
//    	List<User> listAfterDelete = user_dao.getAllItems();
//    	DisplayListUsersAfterUpdate(listAfterDelete);
//    	
//    	
//    	System.out.println("======================= UPDATE =====================");
//    	user_dao.updateItem(new User(101, "new Name", "New Email", "New Password", "New Adress", true,UserRole.ADMIN));
//    	
//    	listAfterDelete = user_dao.getAllItems();
//    	DisplayListUsersAfterUpdate(listAfterDelete);
//    	
//    	System.out.println("======================= End  =====================");
    	
    	
        
        
    }

	private static void DisplayListUsersAfterUpdate(List<User> listAfterDelete) {
		for (User user : listAfterDelete) {
			System.out.println(user);
		}
	}
}
