package com.Automation_test_practice.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelAsString(String sheetName, int rowNum, int cellNum) throws Throwable
	{
	    FileInputStream fis = new FileInputStream("./testData/dataSheet.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    
	    // Get the cell object safely
	    org.apache.poi.ss.usermodel.Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	    
	    String data = "";
	    if (cell != null) {
	        // DataFormatter cleanly extracts numeric, boolean, or formula results as a String
	        org.apache.poi.ss.usermodel.DataFormatter formatter = new org.apache.poi.ss.usermodel.DataFormatter();
	        data = formatter.formatCellValue(cell);
	    }
	    
	    fis.close();
	    wb.close();
	    
	    return data;
	}

	public double getDataFromExcelAsInt(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		
		FileInputStream fis =new FileInputStream("./testData/dataSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 double dataInt = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		fis.close();
		wb.close();
		return dataInt;
	}
	
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis =new FileInputStream("./testData/dataSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		fis.close();
		wb.close();
		return rowCount;
		
	}
public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
	FileInputStream fis =new FileInputStream("./testData/dataSheet.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	FileOutputStream fos= new FileOutputStream("./TestData/dataSheet.xlsx");
	wb.write(fos);
	fos.close();
	wb.close();
}
	
	
	    static String filePath = "./TestData/dataSheet.xlsx";

	    public static void writeData(String sheetName, int rowNum, int colNum, String value) {
	        try {
	            FileInputStream fis = new FileInputStream(filePath);
	            Workbook workbook = WorkbookFactory.create(fis);
	            Sheet sheet = workbook.getSheet(sheetName);

	            if (sheet == null) {
	                sheet = workbook.createSheet(sheetName);
	            }

	            Row row = sheet.getRow(rowNum);
	            if (row == null) {
	                row = sheet.createRow(rowNum);
	            }

	            Cell cell = row.createCell(colNum);
	            cell.setCellValue(value);

	            FileOutputStream fos = new FileOutputStream(filePath);
	            workbook.write(fos);

	            workbook.close();
	            fis.close();
	            fos.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	


}

