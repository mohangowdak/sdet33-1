package com.rmgyantra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
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

public class verifyGUIWRTDatabase {
	
	public static void main(String[] args) throws Throwable {
			
		Connection connection=null;
	try {
				Driver d=new Driver();
				DriverManager.registerDriver(d);
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				Statement statement = connection.createStatement();
				String projID="TY_PROJ_010";
				int result = statement.executeUpdate("insert into project values('"+projID+"','sumanth', '24/03/2022', 'andra','On Going', 4);");
				
				//fetch data from propery file
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
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
		
		for(WebElement projElement:list)
		{
			String projectID = projElement.getText();
			
			if(projectID.equals(projID))
			{
				
				System.out.println("TestCase pass");
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
