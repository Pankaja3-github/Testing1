package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Program002_File_Utility;

public class Program001_FetchingDataFromProperties_File {
	public static void main(String[] args) throws Throwable {
		System.out.println("Hello!");
//		//Step 1 : get the file path connectiom
//		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Documents\\Property.properties");
//		
//		//Step 2: Load all the keys
//		Properties pro = new Properties();
//		pro.load(fis);
//		
		//reading data from File_Utility
		Program002_File_Utility flib = new Program002_File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String username = flib.getKeyAndValuePair("username");
        String password = flib.getKeyAndValuePair("password");
		
		//Step 3: Read key values
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
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}

}
