package org.automation.testing.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	public static String fetchProperityValue(String key, String fileName) throws IOException {
		InputStream input = Utility.class.getClassLoader().getResourceAsStream(fileName);
		Properties prop = new Properties();

		if (input == null) {
			System.out.println("Sorry, unable to find config.properties");
			return null;
		}
		// load a properties file from class path, inside static method
		prop.load(input);
		// get the property value and print it out
		// System.out.println("propertyData:::->"+prop.getProperty(key));
		return prop.getProperty(key);
	}

}