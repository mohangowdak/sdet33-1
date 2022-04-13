package com.rmgyantra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDatabaseWRTGUI {
	
	public static void main(String[] args) throws Throwable {
			Connection connection=null;
	try {
				Driver d=new Driver();
				DriverManager.registerDriver(d);
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				
				FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
				Properties properties=new Properties();
				properties.load(fis);
				String url = properties.getProperty("url");
				String userName = properties.getProperty("userName");
				String password = properties.getProperty("password");
				String browser = properties.getProperty("browser");
				String timeout = properties.getProperty("timeout");
				long timeoutLong = Long.parseLong(timeout);
				
		
				WebDriver driver = null;
		
	if(browser.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
	else {
		System.out.println("Browser is not Specified Properly");
	}
	
	
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeoutLong, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String projName="bbbb";
		driver.findElement(By.name("projectName")).sendKeys(projName);
		driver.findElement(By.name("createdBy")).sendKeys("MOhan");
	WebElement status = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.getElementsByName('teamSize').value('5')");
	
	Select select=new Select(status);
	select.selectByVisibleText("On Goging");
	
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	Statement statement = connection.createStatement();
	
	//Step4: execute query
	// for fetch data(DQL)
	ResultSet result = statement.executeQuery("select * from project;");
	
	while(result.next())
	{
		String projectName = result.getString("project_name");
		
		if(projectName.equals(projName)) {
			System.out.println("Data is stored in database");
		}
	}
	driver.close();
	
	}
	finally {
	      //Step5: close connection
			connection.close();
			System.out.println("connection is closed");
		
	
}
		
		
	}

}
