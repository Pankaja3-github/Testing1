package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Program009_FetchingSingleDataFromExcelUsingDataFormat {
	public static void main(String[] args) throws Throwable {
		//Step1:-get the connection of physical file
	     FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
	     //step2:- open workbook in read mode
	    Workbook book = WorkbookFactory.create(fis);
		
	    //step3:-get control of the Sheet
	    Sheet sheet = book.getSheet("Sheet3");
		
	    //step4:-get control of the row
	    Row row = sheet.getRow(0);
	    if (row == null) {
            System.out.println("Row is not present in the sheet.");
            return;
        }

	
	    //step5:-get control of the cell
	    Cell cel = row.getCell(0);
	    if (cel == null) {
            System.out.println("Cell is not present in the sheet.");
            return;
        }
		
	    // //step6:-read cell value
	   DataFormatter format = new DataFormatter();
	   String excelData = format.formatCellValue(cel);
	   System.out.println(excelData);
		
	}

}
