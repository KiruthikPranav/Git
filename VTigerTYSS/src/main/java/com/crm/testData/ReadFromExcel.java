package com.crm.testData;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel{
	public String readStringValueFromExcel(int sheetnum,int row, int cell) throws IOException {
		FileInputStream fileInput = new FileInputStream("I:\\Selenium\\1 Selenium Class\\xlsDemoFile.xls");
		//Workbook workbook = new HSSFWorkbook(fileInput);
		Workbook workbook = WorkbookFactory.create(fileInput);
		Sheet sheet = workbook.getSheetAt(sheetnum);
		String value =  sheet.getRow(row).getCell(cell).getStringCellValue();
		workbook.close();
		return value;
	}
	public int readNumericValueFromExcel(int sheetnum,int row, int cell) throws IOException {
		FileInputStream fileInput = new FileInputStream("I:\\Selenium\\1 Selenium Class\\xlsDemoFile.xls");
		//Workbook workbook = new HSSFWorkbook(fileInput);
		Workbook workbook = WorkbookFactory.create(fileInput);
		Sheet sheet = workbook.getSheetAt(sheetnum);
		int value = (int) sheet.getRow(row).getCell(cell).getNumericCellValue();
		workbook.close();
		return value;
	}
}