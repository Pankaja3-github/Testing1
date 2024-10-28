package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Program002_File_Utility;
import ObjectRepository.Program001_LoginPage;

//1. Login to vtiger application
//2. click on products link
//3. click on create product lookup image
//4. Enter product name
//5. click on save Btn
//6. verify whether the product is created in product Information page
//7. click on product link
//8. navigate to product table page 
//9. select the product created checkbox
//10. click on delete
//11. Handle the Alert popup and verify product deleted or not and Logout from the application

public class Program002_CreateAndDeleteProducts {
	public static void main(String[] args) throws Throwable {
		//1. Login to vtiger application
//	    FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Documents\\Property.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//				
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
//						
		//reading data from File_Utility
		Program002_File_Utility flib = new Program002_File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get(URL);
		
		//executing data from POM class - getter methods
		Program001_LoginPage login= new Program001_LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//2. click on products link
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		//3. click on create product lookup image
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
		//4. Enter product name
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);	
        
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestDataNew.xlsx");  
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Products3");

		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
//		cell.setCellValue("Products");
//		
//		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataNew.xlsx");
//		book.write(fos);
//		
//		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestDataNew.xlsx");
//		Workbook book1 = WorkbookFactory.create(fis2);
//	    Sheet sheet1 = book1.getSheet("Products3");
//				
//		Row row1 = sheet1.getRow(0);
//	    Cell cel1 = row1.getCell(0);
		String proName = cell.getStringCellValue()+ ranNum;
		System.out.println(proName);
		driver.findElement(By.name("productname")).sendKeys(proName);
		
		//5. click on save Btn
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//6. verify whether the product is created in product Information page
		WebElement amdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(amdLink).perform();
		
		//7. click on product link & //8. navigate to product table page 
		driver.findElement(By.xpath("//a[text()='Products']")).click();
	
		//9. select the product created checkbox   
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + proName + "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		
		//10. click on delete
//		Handle alert
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		//11. Handle the Alert popup and verify product deleted or not and Logout from the application
		driver.switchTo().alert().accept();
		
//		WebElement amdLink1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		act.moveToElement(amdLink1).perform();
		
	    String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if(actData.contains(proName))
		{
			System.out.println("Product is deleted!");
		}
		else
		{
			System.out.println("Product is not deleted!");
		}
		
//	    Logout from the application
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Successfully logged out");
	}

}
