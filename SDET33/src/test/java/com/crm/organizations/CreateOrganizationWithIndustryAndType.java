package com.crm.organizations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryAndType extends BaseClass {

	@Test
	public  void createOrganizationWithIndustryAndType() throws Throwable {
		//Step1: fetch data from external file and store in variable
				FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
				Properties properties=new Properties();
				properties.load(fis);
			
				String excelPath = properties.getProperty("excelPath");
				String excelSheetName = properties.getProperty("excelSheetName");
				
				
	  //generate random number
			Random ran=new Random();
			int randomNumber = ran.nextInt(1000);
			
			//Fetch the data from excel			
			FileInputStream fiss=new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fiss);
			
		String orgName = wb.getSheet(excelSheetName).getRow(11).getCell(1).getStringCellValue();
		String industry = wb.getSheet(excelSheetName).getRow(11).getCell(2).getStringCellValue();
		String type = wb.getSheet(excelSheetName).getRow(11).getCell(3).getStringCellValue();
		
			//Step 2: launch the browser	
				
				//Step6: create organization
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				String expOrgName=orgName+randomNumber;
				driver.findElement(By.name("accountname")).sendKeys(expOrgName);
				WebElement industryDropDown = driver.findElement(By.name("industry"));
				Select sInductry=new Select(industryDropDown);
				sInductry.selectByValue(industry);
				WebElement typeDropDown = driver.findElement(By.name("accounttype"));
				Select sType=new Select(typeDropDown);
				sType.selectByValue(type);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step7 : verify the contact
					String actOrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
					String actIndustry = driver.findElement(By.xpath("//span[@id='dtlview_Industry']/font")).getText();
					String actType = driver.findElement(By.xpath("//span[@id='dtlview_Type']/font")).getText();
					 
					if(expOrgName.equalsIgnoreCase(actOrgName) && actIndustry.equalsIgnoreCase(industry) && actType.equalsIgnoreCase(type)) 
					{
						System.out.println("Organization created successfully with Industry and Type");
						wb.getSheet(excelSheetName).getRow(11).createCell(4).setCellValue("pass");
						FileOutputStream fos=new FileOutputStream(excelPath);
						wb.write(fos);
						
					}
					
	}
}
