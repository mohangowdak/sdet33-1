package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationsTab;
	
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactsTab;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrationIcon;
	
	
	@FindBy(linkText =  "Sign Out")
	private WebElement signOutLink;
	
	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getOrganizationsTab() {
		return organizationsTab;
	}
	public WebElement getContactsTab() {
		return contactsTab;
	}

	//business library
	
	/**
	 * 
	 */
	public void clickOrgnizationsTab() {
		organizationsTab.click();
	}
	/**
	 * 
	 */
	public void clickContactsTab() {
		contactsTab.click();
	}
	/**
	 * used to signout from the application
	 */
	public void signout() {
		//Step11: Sign-out/logout from application
		adminstrationIcon.click();
		signOutLink.click();
		
	}
}
