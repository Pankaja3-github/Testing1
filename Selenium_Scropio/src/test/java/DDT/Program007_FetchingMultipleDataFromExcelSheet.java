package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Program007_FetchingMultipleDataFromExcelSheet {
	public static void main(String[] args) throws Throwable{
		//Step1:-get the connection of physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//step2:- open workbook in read mode
	    Workbook book = WorkbookFactory.create(fis);
		
	    //step3:-get control of the Sheet
	    Sheet sheet = book.getSheet("Sheet1");
		
	    //step4:-get control of the row
	    int rowNum = sheet.getLastRowNum()+1;
	    System.out.println(rowNum);
	    
	    for (int i = 0; i < rowNum; i++) 
	    {
	    	Row row = sheet.getRow(i);
	    	for (int j = 0; j < row.getLastCellNum(); j++) 
	    	{
	    		Cell cell = row.getCell(j);
	    		String links = cell.getStringCellValue();
	    		System.out.println(links);
			}
			
		}
		
	}

}
