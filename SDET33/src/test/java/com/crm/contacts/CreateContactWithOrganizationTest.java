package com.crm.contacts;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ConstantPath;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.CreateNewOrganization;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrganizationTest() throws Throwable {
		//Step1: fetch data from external file and store in variable
			
				
				
				
				//Fetch the data from excel
				String orgName =ExcelUtility.fetchData("SDET33", 8, 1);
				String lastName =ExcelUtility.fetchData("SDET33", 8, 2);
				
				
			//generate random number
			int	randomNumber=JavaUtility.generateRandomNumber(1000);
				
			
				OrganizationsPage orgPage=new OrganizationsPage(driver);
				CreateNewOrganization createOrg=new CreateNewOrganization(driver);
				
				
				
				//Step6: create organization
				homePage.clickOrgnizationsTab();
                orgPage.clickCreateOrganizationImage();
				String expOrgName=orgName+randomNumber;
				createOrg.createOrganizationName(expOrgName);
				
				//Step7 : verify the contact
					String actOrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
					 
					if(expOrgName.equalsIgnoreCase(actOrgName))
					{
						System.out.println("Organization created successfully");
					}
					
					
					//Step8: create Contact
					homePage.clickContactsTab();
					driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
					
					driver.findElement(By.name("lastname")).sendKeys(lastName);
					
					//Step9: add organization
					driver.findElement(By.xpath("//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[1]/img[@src='themes/softed/images/select.gif']")).click();
					
					
					
					WebDriverUtility.switchToWindow(driver, "Accounts");
					driver.findElement(By.name("search_text")).sendKeys(expOrgName);
					
					driver.findElement(By.xpath("//input[@name='search']")).click();
					
					
					driver.findElement(By.linkText(expOrgName)).click();
					
	               WebDriverUtility.switchToWindow(driver, "Contacts");
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
					
					//Step10: Verify organization and contact
					String actContName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
					String actAddedOrg = driver.findElement(By.xpath("//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[@id='mouseArea_Organization Name']/a")).getText();
					 
					if(lastName.equalsIgnoreCase(actContName) && actAddedOrg.equalsIgnoreCase(expOrgName))
					{
						System.out.println("Contact created successfully with organization");
						
						ExcelUtility.writeDataInExistingRow("./src/test/resources/testData.xlsx", "SDET33", 8, 4, "pass");
						
					}
					
					
					
	}

}
