package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//declaration
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createOrganizationImage;
		
		
		
		//Initialization
		public OrganizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//getters
		public WebElement getCreateOrganizationImage() {
			return createOrganizationImage;
		}

		//business library
		public void clickCreateOrganizationImage() {
			createOrganizationImage.click();
		}
	
	
}
