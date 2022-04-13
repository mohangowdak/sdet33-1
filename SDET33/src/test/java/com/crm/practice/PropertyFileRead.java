package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {
	
	public static void main(String[] args) throws IOException {
		//STEP1: convert the physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		
		
		//STEP2: create the object of properties
		Properties properties=new Properties();
		
		//STEP3: load all the Keys
		properties.load(fis);
		
		//Step4: fetch the data
		String url = properties.getProperty("url");
		System.out.println(url);
	}
}
