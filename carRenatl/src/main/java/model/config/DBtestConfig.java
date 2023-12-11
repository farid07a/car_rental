package model.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
 

public class DBtestConfig {

private static final Logger LOGGER = LogManager.getLogger();
// Connection Pool and Handl All actions Of connection (open close exception)
// now we need dataSource for pass to flyWay 
// flyWay get More Information make connection and get data in database for create scripts
private DataSource getDataSource() {
	
	DataSource dataSource = null;
	EmbeddedPostgres postgres=null;
	
	try {
		postgres=EmbeddedPostgres.builder().start();// prepare datasource embeded postgres 
		dataSource= postgres.getPostgresDatabase();// 
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		LOGGER.error("Unable to start EmbededPostgres :"+e);
	}
	// return 
	// copy instance of dataSource and write scripts in datasource and returned prepared with all tables  
	Flyway flyway= getFlaFlyway(dataSource);
	
	flyway.clean();
	flyway.migrate();
	return dataSource;
}

public java.sql.Connection GetConnection() {
	try {
		return getDataSource().getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		LOGGER.error("Unable to get Connection :"+e);
		throw new RuntimeException("Unable to get Connection :"+e);
		
	}
	
	//return null unreachable code;
}

private Flyway getFlaFlyway(final DataSource dataSource) {
	FluentConfiguration configuration =Flyway.configure().dataSource(dataSource);
	return new Flyway(configuration);
	
}

}
