package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchParticularRowData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {	
	FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
     Sheet sh = wb.getSheet("Login");
     for (int i = 1; i <=sh.getLastRowNum(); i++) {
    	 String userName = sh.getRow(i).getCell(0).toString();
    	 
    	 if(userName.equalsIgnoreCase("admin11"))
    	 {
    		 String password = sh.getRow(i).getCell(1).toString();
    		 System.out.println(password); 
    	 }
	}
}
}