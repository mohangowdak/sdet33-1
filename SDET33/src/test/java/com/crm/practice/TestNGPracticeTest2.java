package com.crm.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

public class TestNGPracticeTest2 {

	
	@Test
	public void test2() {
		Reporter.log("TestNGPracticeTest2-test2(before)", true);
		Assert.fail();
		Reporter.log("TestNGPracticeTest2-test2(after)", true);
	}
	
	
}
