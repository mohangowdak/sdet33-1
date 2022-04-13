package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	//declaration
		@FindBy(name = "accountname")
		private WebElement organizationNameTextField;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		
		
		//Initialization
		public CreateNewOrganization(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//getters
		public WebElement getOrganizationNameTextField() {
			return organizationNameTextField;
		}
		
		public WebElement getSaveButton() {
			return saveButton;
		}

		//business library
		public void createOrganizationName(String orgName) {
			organizationNameTextField.sendKeys(orgName);
			saveButton.click();
		}

}
