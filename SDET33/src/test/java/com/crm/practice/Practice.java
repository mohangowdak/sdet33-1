package com.crm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.DataBaseUtility;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	public static void main(String[] args) throws Throwable {
	/*
		//excel1
		ExcelUtility.openExcel("./src/test/resources/testData.xlsx");
		ExcelUtility.writeDataInNewRow("./src/test/resources/testData.xlsx", "SDET33", 19, 1, "Status");
		String orgName =ExcelUtility.fetchData( "SDET33", 8, 1);
		System.out.println(orgName);
		ExcelUtility.writeDataInNewRow("./src/test/resources/testData.xlsx", "SDET33", 20, 1, "pass");
		String lastName =ExcelUtility.fetchData( "SDET33",8,  2);
		System.out.println(lastName);
		
		//excel2
		ExcelUtility.openExcel("./src/test/resources/testData2.xlsx");
		ExcelUtility.writeDataInNewRow("./src/test/resources/testData2.xlsx", "SDET33", 20, 1, "pass");
		String orgName1 =ExcelUtility.fetchData( "SDET33", 8, 1);
		ExcelUtility.writeDataInNewRow("./src/test/resources/testData2.xlsx", "SDET33", 19, 1, "Status");
		System.out.println(orgName1);
		String lastName1 =ExcelUtility.fetchData( "SDET33",8,  2);
		System.out.println(lastName1);
		ExcelUtility.closeExcel();
		
		
		
		//database
		DataBaseUtility.getMysqlDatabaseConnection(ConstantPath.dbUrl, "root", "root");
		System.out.println( DataBaseUtility.verifyData("select * from project;", "2", "mohan"));
	
	
	*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement login =driver.findElement(By.id("submitButton"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		
		js.executeScript("arguments[0].value='admin'", userName);
		js.executeScript("arguments[0].value='admin'", password);
		js.executeScript("arguments[0].click();", login);
		WebElement topOppelement = driver.findElement(By.xpath("//b[contains(.,'Top Opportunities')]"));
		
		//js.executeScript("arguments[0].scrollIntoView();", topOppelement);
		WebDriverUtility.scrollDownToPageThroughJS(driver,  "+");
		Thread.sleep(4000);
		WebDriverUtility.scrollDownToPageThroughJS(driver,  "-");
		
		
		
	}
	
	

}
