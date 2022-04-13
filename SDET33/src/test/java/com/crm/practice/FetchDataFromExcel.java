package com.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws Exception {
//		Step1: we should convert the physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");

//		Step2: open the excel file using "WorkbookFactory" class and crete(--);
		Workbook wb = WorkbookFactory.create(fis);

//		Step3: we should get the control of particular sheet by using "getSheet(----)";
	     Sheet sh = wb.getSheet("SDET33");
	     
//		Step4: we should get the control of particular row by using "getRow(--)";
	     	Row row = sh.getRow(1);
	     
//		Step5: we should get the control of particular cell by using "getCell(--)" ;
	    	Cell cell = row.getCell(0);
	    
//		Step6: read / fetch the data by using "getStringCellValue()", "toString()"
	    		String data = cell.getStringCellValue();
	    		System.out.println(data);
	    	
//		Step7: close the workbook by using "close()"----> belongs to WorkBook interface
	    			wb.close();
	
	}
}
