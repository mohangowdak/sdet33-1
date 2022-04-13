package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {


	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgNameText;
	
	//Step3: Initialization ---> We will create public constructors and initialize the elements/variables
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business logic
	
	public String fetchOrgName() {
		return (orgNameText.getText());
	}
	
	
}
