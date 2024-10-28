package DDT;

import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Program002_File_Utility;

public class Program002_InsertDataToProperties_File {
	public static void main(String[] args) throws Throwable {
		
//		// Inserting data to properties File
//		FileInputStream fis = new FileInputStream("./src/test/resources/Property2.properties");
//		
		Properties pro = new Properties();
//		
//		//setProperty() --> insert data to physical file
//		pro.setProperty("browser", "chrome");
//		pro.setProperty("url", "http://localhost:8888");
//		pro.setProperty("username", "admin");
//		pro.setProperty("password", "admin");
		
		//reading data from File_Utility
		Program002_File_Utility flib = new Program002_File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
        String PASSWORD = flib.getKeyAndValuePair("password");
		
		//FileOutputStream --> keeps the file in write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Property2.properties");
		pro.store(fos, "CommonData");
		
		//-------------------------------------------------------------------------------------------------------------
		//Fetching data from Properties File
		
		//load--> loading keys into properties file
//		pro.load(fis);
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
//		
		
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
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
