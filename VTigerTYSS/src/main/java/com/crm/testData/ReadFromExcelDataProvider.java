package com.crm.testData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import com.crm.fetchFromExternalFile.IPathConstants;

public class ReadFromExcelDataProvider {
	
	@DataProvider(name = "ExcelData")
	public Object[][] excelData() throws IOException {
		
		FileInputStream inputFile = new FileInputStream(IPathConstants.ExcelDataProvide);
		
		int rowNo = 0 ,cellNo=0;
		//Workbook workbook = new  HSSFWorkbook(inputFile);//For Xls we use HSSF, for xlsx we use XSSF
		Workbook workbook = WorkbookFactory.create(inputFile);
		Sheet sheet = workbook.getSheetAt(0);
		
		int lastRowNum = sheet.getLastRowNum()+1;
		int lastCellNum = sheet.getRow(1).getLastCellNum();
		
		Iterator<Row> rowitr = sheet.iterator();
		Object[][] data = new Object[lastRowNum][lastCellNum];
		
		while(rowitr.hasNext()) {
			Row row = (Row) rowitr.next();
			Iterator<Cell> cellitr = row.iterator();
			cellNo=0;
			
			while(cellitr.hasNext()) {
				Cell cell = (Cell) cellitr.next();
				
				switch(cell.getCellType()) {
				case STRING:
					data[rowNo][cellNo]=cell.getStringCellValue();
					//System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					data[rowNo][cellNo]=cell.getNumericCellValue();
				//System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[rowNo][cellNo]=cell.getBooleanCellValue();
					break;
				case _NONE:
					//data[rowNo][cellNo]=null;
					System.out.print("Null");
					break;
				case BLANK:
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				default:
					//System.out.println(" Default ");
					break;
				}
				//System.out.print(" ");
				if(cellNo==3) {
					break;
				}
				cellNo++;
			}
			rowNo++;
			//System.out.println("");
		}
		workbook.close();
		return data;
		//System.out.println(data);
		//workbook.close();
	}
}
