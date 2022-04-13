package com.crm.practice;

import com.crm.genericUtility.ExcelUtility;

public class dataProviderPrint {

	public static void main(String[] args) throws Throwable {
		ExcelUtility.openExcel("./src/test/resources/loginTestData.xlsx");
		Object[][] arr = ExcelUtility.fetchMultipleData("Sheet1");

		int i=arr.length;
		int j= arr[0].length;
		for (int j2 = 0; j2 < i; j2++) {
			for(int j3 = 0; j3 < j; j3++)
				System.out.println(arr[j2][j3]);
		}
	}

}
