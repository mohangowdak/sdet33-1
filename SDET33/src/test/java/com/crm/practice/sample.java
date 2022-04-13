package com.crm.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class sample {
	
	public static void main(WebDriver driver, String path) throws IOException {
		
		EventFiringWebDriver efwd=new EventFiringWebDriver(driver);
		File src = efwd.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		
		
		
	}

}
