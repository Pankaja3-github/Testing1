package Campaigns;

//1. Login to vtiger application
//2. mouseOverOn more Link
//3. click on campaigns
//4. click on create campaign lookup image
//5. Enter campaignName
//6. click on save Btn
//7. verify whether the campaign is created in campaign Information page and Logout from the application. 

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
import ObjectRepository.Program003_CampaignCreateNavigationPage;
import ObjectRepository.Program004_CreateCampaignPage;
import ObjectRepository.Program005_ValidateCampaigns;
//testing
public class Program001_CreateCampaignTest 
{
	public static void main(String[] args) throws Throwable {					
		//reading data from File_Utility
		Program002_File_Utility flib = new Program002_File_Utility();
		Program001_WebDriver_Utility wlib = new Program001_WebDriver_Utility();
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();
		
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
		driver.get(URL);
		
	 	
		//executing data from POM class - getter methods
		Program001_LoginPage login= new Program001_LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		
		wlib.maximizeWindow(driver);
		wlib.waitForElementsToLoad(driver);
		
		//2. mouse hover on more Link
		Program002_HomePage home = new Program002_HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		
		//3. click on campaigns link
		Program003_CampaignCreateNavigationPage camp = new Program003_CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();
		
		int ranNum = jlib.getRandomNum();
		
		//4. click on create campaign lookup image
		//5. Enter campaignName	
		String CampName = elib.getExcelData("Campaigns",0,0) + ranNum;
		System.out.println(CampName);
		
		//6. click on save Btn
		//7. verify whether the campaign is created in campaign Information page and Logout from the application.
	
		Program004_CreateCampaignPage campPage = new Program004_CreateCampaignPage(driver);
		campPage.enterCampName(CampName);
		campPage.clickSaveButton();
		
		Program005_ValidateCampaigns valid = new Program005_ValidateCampaigns(driver);
		valid.validateCampName(driver,CampName);
		home.logout(driver);
	}

}
