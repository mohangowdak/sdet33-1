package com.crm.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForStaleElementReferenceException {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUN_Pwd("admin", "admin");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		loginPage.loginAction("admin", "admin");
	}
}
