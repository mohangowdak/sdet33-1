package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property file common methods
 * @author MOHAN GOWDA
 *
 */
public class FileUtility {

	static Properties properties;
	/**
	 * This method is used to fetch the Data from Property File
	 * @param path
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public static String fetchDataFromProperty(String key) {
		String value = properties.getProperty(key);
		return value;
	}

	/**
	 * This method is used to intiallize the property file
	 * @param path
	 * @throws IOException
	 */
	public static void intiallizePropertyFile(String path) throws IOException {

		FileInputStream fis=new FileInputStream(path);
		properties=new Properties();
		properties.load(fis);
	}

}
