package com.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	
	@Test
	public void practice1() {
		SoftAssert sa=new SoftAssert();
		String s="Sdet33";
		System.out.println("line 11");

	System.out.println("line 13");
	sa.assertAll();
	System.out.println("line 14");
	
	}

	@Test
	public void practice2() {
		String s="Sdet33";
		System.out.println("line 11 - practice 2");
	System.out.println("line 13 - practice 2 ");
	}
}
