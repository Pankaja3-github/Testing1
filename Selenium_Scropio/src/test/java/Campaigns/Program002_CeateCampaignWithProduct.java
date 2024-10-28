package Campaigns;

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
import ObjectRepository.Program006_CreateProductNavigationPage;
import ObjectRepository.Program007_CreateProductPage;
import ObjectRepository.Program008_ValidateProducts;
import ObjectRepository.Program010_SwitchingProductPage;

//1. Login to vtiger application-
//2. mouseOverOn more Link
//3. click on campaigns
//4. click on create campaign lookup image
//5. Enter campaignName
//6. Click on Product plus img
//7. Handle the PopUp
//8. Product name should be added to campaign createpage
//9. click on save Btn
//10. verify whether the campaign is created in campaign Information page and Logout from the application.

public class Program002_CeateCampaignWithProduct {
	public static void main(String[] args) throws Throwable {
//		Step1:-Login to vtiger application
		
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
		
		driver.get(URL); 
		
		//executing data from POM class - getter methods
		Program001_LoginPage login= new Program001_LoginPage(driver);
		login.loginToVtiger(username, password);
		
		wlib.maximizeWindow(driver);
		wlib.waitForElementsToLoad(driver);
		
		int ranNum = jlib.getRandomNum();
		
//		create a product
		Program006_CreateProductNavigationPage prod = new Program006_CreateProductNavigationPage(driver);
		prod.getProdLink();
		prod.clickProdPlus();
		String prodName = elib.getExcelDataForProduct("Product",0,0) + ranNum;
		System.out.println(prodName);
		Program007_CreateProductPage prod2 = new Program007_CreateProductPage(driver);
		prod2.enterProdName(prodName);
		prod2.clickSaveButton();
		
		//2. mouse hover on more Link
		Program002_HomePage home = new Program002_HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		
		//3. click on campaign	
		Program003_CampaignCreateNavigationPage camp = new Program003_CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();
		
		
		
		Program004_CreateCampaignPage campPage = new Program004_CreateCampaignPage(driver);
		
		//6. Click on Product plus 
		campPage.clickProdPlus();
		
		wlib.switchToWindow(driver, "Products&action");

		Program010_SwitchingProductPage switchWin = new Program010_SwitchingProductPage(driver);
		switchWin.enterPrdName(prodName);
		switchWin.searchPrdName();

		// Dynamic Xpath
		switchWin.selectExpPrdName(driver, prodName);

		wlib.switchToWindow(driver, "Campaigns&action");
		//4. click on create campaign lookup image
				//5. Enter campaignName
				String CampName = elib.getExcelData("Campaigns",0,0) + ranNum;
				System.out.println(CampName);
		campPage.enterCampName(CampName);
		campPage.clickSaveButton();

		//7. Handle the PopUp
//		
////		
//		//8. Product name should be added to campaign create page

//	    //9. click on save Btn

//		10. verify whether the campaign is created in campaign Information page and Logout from the application.
//		Logout from the application
		
	    Program005_ValidateCampaigns valid = new Program005_ValidateCampaigns(driver);
	    Program008_ValidateProducts valid1 = new Program008_ValidateProducts(driver);
		valid.validateCampName(driver,CampName);
		valid1.validateProdName(driver,prodName);
		home.logoutFromApp();
		
	}

}
