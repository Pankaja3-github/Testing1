package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Program008_InsertDataIntoExcelUsingMap {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("10", "Bangalore");
		map.put("20", "Nagpur");
		map.put("30", "Pune");
		map.put("40", "Hyderabad");
		
		int runNum = 0;
		for ( Entry<String, String> m : map.entrySet()) 
		{
			Row row = sheet.createRow(runNum++);
			row.createCell(0).setCellValue((String)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);
		book.close();
	}

}
