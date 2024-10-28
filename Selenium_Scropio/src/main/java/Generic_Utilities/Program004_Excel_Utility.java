package Generic_Utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Program004_Excel_Utility {
//  this method is used to read data from excel sheet for campaigns
	public String getExcelData(String sheetNameString,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestDataNew.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Campaigns");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
	}
//  this method is used to read data from excel sheet for products
	public String getExcelDataForProduct(String sheetNameString,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestDataNew.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
	}
//  this method is used to read data from excel sheet for organization
	public String getExcelDataForOrg(String sheetNameString,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestDataNew.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Org");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
	}
	 // this method is used to read data from excel using data formatter
	public String getExcelDataUsingDataFormatter(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("Sheet3");
		
	    Row row = sheet.getRow(rowNum);
	    Cell cel = row.getCell(cellNum);
	    
	    DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		
		return ExcelData;
	}
	
	public String getExcelDataUsingDataFormatterOrg(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestDataNew.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
	    Sheet sheet = book.getSheet("DataProvider");
		
	    Row row = sheet.getRow(rowNum);
	    Cell cel = row.getCell(cellNum);
	    
	    DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		
		return ExcelData;
	}

}
