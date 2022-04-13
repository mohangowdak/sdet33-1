package com.crm.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage homePage;
	public static WebDriver sdriver;

	@BeforeSuite(groups = {"smoke", "regression"})
	public void openDatabase() throws Throwable {
		FileUtility.intiallizePropertyFile(ConstantPath.PropertyFilePath);
		DataBaseUtility.getMysqlDatabaseConnection(ConstantPath.dbUrl, FileUtility.fetchDataFromProperty("dbUserName"), FileUtility.fetchDataFromProperty("dbPassword"));
		ExcelUtility.openExcel(ConstantPath.ExcelPath);
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"smoke", "regression"})
	public void launchBrowser(/*String browser*/) {
		//String browser=FileUtility.fetchDataFromProperty("browser");
		String browser=System.getProperty("browser");
		
		long timeout=JavaUtility.convertStringToLong(FileUtility.fetchDataFromProperty("timeout"));
		
		
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
		//String url=FileUtility.fetchDataFromProperty("url");
		String url=System.getProperty("url");
		WebDriverUtility.launchApplicationWithMaximize(driver, url , timeout);
	     sdriver=driver;
	}
	
	
	@BeforeMethod(groups = {"smoke", "regression"})
	public void loginToApplication() throws Throwable {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginAction(FileUtility.fetchDataFromProperty("userName"), FileUtility.fetchDataFromProperty("password"));
		homePage=new HomePage(driver);
		
	}
	
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void logoutFromApplication() throws Throwable {
		homePage.signout();
		
	}
	@AfterClass(groups = {"smoke", "regression"})
	public void closeBrowser()
	{
		WebDriverUtility.closeBrowser(driver);
	}
	
	@AfterSuite(groups = {"smoke", "regression"})
	public void closeDBConnection() throws Throwable {
		DataBaseUtility.closeDatabseConnection();
		ExcelUtility.closeExcel();
	}
	
	
	
	
	
	
}
