package com.crm.organizations;

import java.awt.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.objectRepository.CreateNewOrganization;
import com.crm.objectRepository.OrganizationInformationPage;
import com.crm.objectRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {


@Test
public void createOrganizationTest() throws Throwable
	{
	
	//Create the object for POM Class
	OrganizationsPage org=new OrganizationsPage(driver);
	CreateNewOrganization createOrg=new CreateNewOrganization(driver);
	OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
	
	//store variable
	String OrgName=ExcelUtility.fetchData(FileUtility.fetchDataFromProperty("excelSheetName"), 5, 1)+JavaUtility.generateRandomNumber(1000);
	
	
	//click on oganization tab
	homePage.clickOrgnizationsTab();
	
	//click on create organization
	org.clickCreateOrganizationImage();
	
	//create Organization and Save 
	createOrg.createOrganizationName(OrgName);

			
				//Step7 : verify the contact
					String actOrgName = orgInfo.fetchOrgName();
					 
					if(OrgName.equalsIgnoreCase(actOrgName))
					{
						Reporter.log("Organization created successfully");
					}
					
					

	}
}
