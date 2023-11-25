package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesReader {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static Properties getProperties(final String filePath) {
		

		Properties properties= new Properties();
		
		// Try with Resources from java 7 for close resources after used automatically without block finally
		// FileInputStram implements interface autoClosable
		try(FileInputStream inputStream = new FileInputStream(filePath) ){
			properties.load(inputStream);// hash table in properties
			LOGGER.info("Done Reading from file:" + filePath);
		} catch (FileNotFoundException e) {
			LOGGER.error("Error No reading file found "+filePath + e);
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error("Error while Reading from file :"+filePath+" "+e);
		}
		
		return properties;
	}
	
}
