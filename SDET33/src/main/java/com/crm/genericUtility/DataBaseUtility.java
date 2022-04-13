package com.crm.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all the Generic methods of Database
 * @author MOHAN GOWDA
 *
 */
public class DataBaseUtility {

	static Connection connection;
static ArrayList<String> list=new ArrayList<String>();
	/**
	 * This method is used to establish the connection of the MYSQL Database
	 * @param dbUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public static void getMysqlDatabaseConnection(String dbUrl, String dbUserName, String dbPassword) throws SQLException  {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	}


	/**
	 * This method is used to fetch the data from database based on the column Number
	 * @param query
	 * @param columnNumber
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDatabase(String query, int columnNumber ) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		while(result.next())
		{
			list.add(result.getString(columnNumber));
		}
		statement.close();
		return list;
	}
	
	public static ResultSet getDataFromDatabase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		
		return result;
	}
	
	/**
	 * This method is used to fetch the data from database based on the column name
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDatabase(String query, String columnName ) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		statement.close();
		return list;
	}
	

	/**
	 * This method is used to fetch the data from database based on the column name or column number
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 
	public static ArrayList<String> getDataFromDatabase(String query, String columnNameOrColumnNuber) throws SQLException {
		String num="";
		for (int i = 0; i < columnNameOrColumnNuber.length(); i++) {
			char ch = columnNameOrColumnNuber.charAt(i);
			if(Character.isDigit(ch)) {
				num=num+columnNameOrColumnNuber.charAt(i);//1
			}
			else {
				break;
			}
		}
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		
			int columnNumber = 0;
			String columnName = null;
			if(num.equalsIgnoreCase(columnNameOrColumnNuber))
			{
			 columnNumber=Integer.parseInt(num);
			 while(result.next())
				{
			 list.add(result.getString(columnNumber));
				}
			}
			else {
				columnName=columnNameOrColumnNuber;
				while(result.next())
				{
				list.add(result.getString(columnName));
				}
			}
			
		
		statement.close();
		return list;
	}
	
	*/
	
	
	/**
	 * This method is used to update/write/modify the data inside the database
	 * @param query
	 * @throws SQLException
	 */
	public static void updateDataIntoDatabase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		System.out.println("Query executed successfully");
		statement.close();
	}
	
	/**
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public static void closeDatabseConnection() throws SQLException {
		connection.close();
		
	}
	
	/**
	 * This method is used to verify the data wheathe it is present in the database or not
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return 
	 * @throws SQLException
	 */
	public static boolean verifyData(String query, String columnNameOrColumnNumber, String expData) throws SQLException {
		ArrayList<String> listData = getDataFromDatabase(query,columnNameOrColumnNumber);
		boolean flag=false;
		for(String data:listData)
		{
		if(data.equalsIgnoreCase(expData))
		{
			flag=true;
			break;
		}
		}
		return flag;
		
	}

}
