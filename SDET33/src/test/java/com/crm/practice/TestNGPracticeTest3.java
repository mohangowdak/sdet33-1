package com.crm.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

public class TestNGPracticeTest3{

	@Test(groups = {"regression"})
	public void test1() {
		Reporter.log("TestNGPracticeTest3-test1", true);
	}
	

	@Test(groups = {"smoke","regression"})
	public void test2() {
		Reporter.log("TestNGPracticeTest3-test2", true);
	}

	@Test
	public void test3() {
		Reporter.log("TestNGPracticeTest3-test3", true);
	}
	
	
}
