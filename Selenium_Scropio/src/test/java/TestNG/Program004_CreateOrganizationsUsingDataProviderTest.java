package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Program001_WebDriver_Utility;
import Generic_Utilities.Program002_File_Utility;
import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import ObjectRepository.Program001_LoginPage;
import ObjectRepository.Program002_HomePage;
import ObjectRepository.Program012_CreateOrganizationNavigationPage;

public class Program004_CreateOrganizationsUsingDataProviderTest {
	
	@Test (dataProvider = "getData")
	public void organizationModule(String orgName,String phnNum,String mailId) throws Throwable
	{
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8888");
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		Program002_File_Utility flib = new Program002_File_Utility();
		Program001_WebDriver_Utility wlib = new Program001_WebDriver_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String username = flib.getKeyAndValuePair("username");
		String password = flib.getKeyAndValuePair("password");
						
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
		wlib.waitForElementsToLoad(driver);
		
		Program001_LoginPage login= new Program001_LoginPage(driver);
		login.loginToVtiger(username, password);
		Program012_CreateOrganizationNavigationPage org = new Program012_CreateOrganizationNavigationPage(driver);
		org.getOrgLink();
		org.clickOrgPlus();
		
		Program002_HomePage home = new Program002_HomePage(driver);
		home.logout(driver);
		System.out.println("Successfully logged out");
		
//		driver.findElement(By.linkText("Organizations")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.name("phone")).sendKeys(phnNum);
//		driver.findElement(By.name("email1")).sendKeys(mailId);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		
		System.out.println("Organization Name : "+orgName);
		System.out.println("Phone Number : "+phnNum);
		System.out.println("Email ID : "+mailId);
	}
		
		@DataProvider
		public Object[][] getData() throws Throwable, IOException
		{
			Program003_Java_Utility jlib = new Program003_Java_Utility();
			int ranNum = jlib.getRandomNum();
			Object[][] objArr = new Object[3][3];
			
			Program004_Excel_Utility elib = new Program004_Excel_Utility();

			objArr[0][0] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",0,0)  + ranNum;
			objArr[0][1] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",0,1);
			objArr[0][2] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",0,2);

			
			objArr[1][0] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",1,0)  + ranNum;
			objArr[1][1] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",1,1);
			objArr[1][2] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",1,2);
			
			objArr[2][0] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",2,0)  + ranNum;
			objArr[2][1] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",2,1);
			objArr[2][2] = elib.getExcelDataUsingDataFormatterOrg("DataProvider",2,2);
			
			return objArr;
		}
		
}
