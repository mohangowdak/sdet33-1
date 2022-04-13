package com.crm.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class FetchMultipleData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {	
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Login");
		String[][] str=new String[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 1; i <=sh.getLastRowNum(); i++) {
			for (int j = 0; j <sh.getRow(1).getLastCellNum();j++) {
				str[i-1][j] = sh.getRow(i).getCell(j).toString();
				System.out.print(str[i-1][j]);
			}
		}
	}
}