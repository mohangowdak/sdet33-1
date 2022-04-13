package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Step1: we should create public class and give the class name as webpage name
public class LoginPage {
	//Step3: declaration ---> we will declare the locators as private using @findBy
	@FindBy(name = "user_name")
	private WebElement userNameTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	//Step3: Initialization ---> We will create public constructors and initialize the elements/variables
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//Step 4: Utilization ------> by developing public getters or/and Business library 
	//way1: by creating public getters
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//way2 : by creating business library
	/**
	 * To login to the application
	 * @param userName
	 * @param password
	 */
	public void loginAction(String userName, String password) {
		enterUN_Pwd(userName, password);
		loginButton.click();
	}
	
	/**
	 *  To enter username and Password
	 * @param userName
	 * @param password
	 */
	public void enterUN_Pwd(String userName, String password){
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
	}


}
