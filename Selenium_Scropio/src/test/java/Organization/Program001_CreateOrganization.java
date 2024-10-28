package Organization;
//1. Login to vtiger application
//2. click on organizations link->click on create organization lookup image
//3. Enter organisation name,phone number and email
//4. click on save Button
//5. verify whether the organization is created in Organization Information page
//6. Logout from the application

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Program001_WebDriver_Utility;
import Generic_Utilities.Program002_File_Utility;
import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import ObjectRepository.Program001_LoginPage;
import ObjectRepository.Program002_HomePage;
import ObjectRepository.Program012_CreateOrganizationNavigationPage;
import ObjectRepository.Program013_CreateOrganizationPage;
import ObjectRepository.Program014_ValidateOrganization;

public class Program001_CreateOrganization {
	public static void main(String[] args) throws Throwable {
		//Step1:-Login to vtiger application		
		//reading data from File_Utility
		Program002_File_Utility flib = new Program002_File_Utility();
		Program001_WebDriver_Utility wlib = new Program001_WebDriver_Utility();
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();
		
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
		
        wlib.maximizeWindow(driver);
        wlib.waitForElementsToLoad(driver);
		
		driver.get(URL);
		
		//executing data from POM class - getter methods
		Program001_LoginPage login= new Program001_LoginPage(driver);
		login.loginToVtiger(username, password);
		
        //2. click on organizations link->click on create organization lookup image
		Program012_CreateOrganizationNavigationPage org = new Program012_CreateOrganizationNavigationPage(driver);
		org.getOrgLink();
		org.clickOrgPlus();
		
		int ranNum = jlib.getRandomNum();
		
		//3. Enter organization name,phone number and email
		String orgName = elib.getExcelDataForOrg("orgName",0,0) + ranNum;
		System.out.println(orgName);
		String PhoneNum = elib.getExcelDataUsingDataFormatter("Sheet3",1,0);
		System.out.println(PhoneNum);
		String email = elib.getExcelDataUsingDataFormatter("Sheet3",2,0);
		System.out.println(email);
		
		//4. click on save Button
		Program013_CreateOrganizationPage org2 = new Program013_CreateOrganizationPage(driver);
		org2.enterOrgName(orgName);
		org2.enterPhone(PhoneNum);
		org2.enterEmail(email);
		org2.clickSaveButton();
		
		//5. verify whether the organization is created in Organization Information page
		Program014_ValidateOrganization valid = new Program014_ValidateOrganization(driver);
		valid.validateOrgName(driver,orgName);
        
        //6. Logout
		Program002_HomePage home = new Program002_HomePage(driver);
		home.logout(driver);
		System.out.println("Successfully logged out");
		}
	}


