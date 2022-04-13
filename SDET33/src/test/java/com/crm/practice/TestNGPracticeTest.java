package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ExcelUtility;

public class TestNGPracticeTest {

	@Test(dataProvider = "dataProvider_excel")
	public void dataProviderTest(String userName, String password)
	{
	System.out.println(userName+" === "+password);
	}
	
	
	

	
	@DataProvider
	public Object[][] dataProvider_company(){
		Object[][] arr=new Object[5][2];
		
		arr[0][0]="TestYantra";
		arr[0][1]=2010;
		
		arr[1][0]="TestYantra1";
		arr[1][1]=2011;
		
		arr[2][0]="TestYantra2";
		arr[2][1]=2012;
		
		arr[3][0]="TestYantra3";
		arr[3][1]=2013;
		
		arr[4][0]="TestYantra4";
		arr[4][1]=2014;
		
		
		
		return arr;
	}
	

	@DataProvider
	public Object[][] dataProvider_excel() throws Throwable{
		ExcelUtility.openExcel("./src/test/resources/loginTestData.xlsx");
		Object[][] arr = ExcelUtility.fetchMultipleData("Sheet1");
		
		return arr;
		
	}
	
	
}
