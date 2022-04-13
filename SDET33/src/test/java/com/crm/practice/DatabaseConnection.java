package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
	try {
		//Step1: we should create the object for the driver and register the driver
				Driver d=new Driver();
				DriverManager.registerDriver(d);
				
				

				//Step2: get the connection 
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33","root","root");
				
				//Step3: create Statement
				Statement statement = connection.createStatement();
				
				//Step4: execute query
				// for fetch data(DQL)
				ResultSet result = statement.executeQuery("select * from sdet33;");
				
				while(result.next())
				{
					System.out.println(result.getString(3));
					
					
				}
				
	
	
	}
	finally {
		      //Step5: close connection
				connection.close();
				System.out.println("connection is closed");
		
	}
	
	
	
		
	}
}
