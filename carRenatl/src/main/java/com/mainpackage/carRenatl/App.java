package com.mainpackage.carRenatl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
import domain.User;
import domain.UserRole;
import model.config.dbConnection;
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
        Connection connectionObj= new dbConnection().getConnection();
        
        System.out.println("Success Connecting "+connectionObj);
        //System.out.println("Connection to which database:"+connectionObj.getCatalog());
        
        
        
    }
}
