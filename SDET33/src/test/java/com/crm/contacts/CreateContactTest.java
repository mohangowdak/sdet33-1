package com.crm.contacts;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

//@Listeners(com.crm.genericUtility.ListenerImplementation.class)


public class CreateContactTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void createContactTest() throws SQLException {
		
	
driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

driver.findElement(By.name("lastname")).sendKeys("mohan");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String actResult = driver.findElement(By.id("dtlview_Last Name")).getText();

Assert.assertTrue(actResult.equals("moh"));
Reporter.log("TC Pass", true);




}



	


}
