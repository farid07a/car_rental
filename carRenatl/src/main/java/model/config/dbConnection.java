package model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.PropertiesReader;

public class dbConnection {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final String PROPERTIES_DB_FILE="src/main/resources/dbconnection.properties";
	private static final String DRIVER = "driverClassName";
	private static final String URL="jdbcUrl"; // "Literal" names literal
	private static final String USER="postgres.username";
	private static final String PASSWORD="postgres.password";
	
	private String databaseUrl="";
	private String databaseUser="";
	private String databasePassword="";
	private String databaseDriver="";
	
	public dbConnection() {
		Properties properties=PropertiesReader.getProperties(PROPERTIES_DB_FILE);
		databaseUrl=properties.getProperty(URL);
		databaseUser=properties.getProperty(USER);
		databasePassword=properties.getProperty(PASSWORD);
		databaseDriver = properties.getProperty(DRIVER);
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			System.out.println("Database Driver :"+databaseDriver);
			System.out.println("Database Url :"+databaseUrl);
			System.out.println("Database User :"+databaseUser);
			System.out.println("Database pasword :"+databasePassword);
			
			Class.forName(databaseDriver); // this runtime 
			connection =DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
			LOGGER.info("Success Connecting database");
			return connection;
		} catch (SQLException e) {
			// TODO: handle exception
			LOGGER.error("Unable to connect database URL:"+databaseUrl+" "+e);
			//throw new RuntimeException("Unable to connect database URL"); // after throw this exception can remove last return
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Unable to find suitable driver database URL:"+databaseUrl+" "+e);
		}
		//return connection;// use when no throw runtimeException
		 return connection;
	}

	public static void main(String[] args) {
		Connection cnx=new dbConnection().getConnection();
		
		
	}
}
