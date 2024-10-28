package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Program001_WebDriver_Utility;
import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import Generic_Utilities.Program005_BaseClass;
import ObjectRepository.Program002_HomePage;
import ObjectRepository.Program003_CampaignCreateNavigationPage;
import ObjectRepository.Program004_CreateCampaignPage;
import ObjectRepository.Program005_ValidateCampaigns;
import ObjectRepository.Program006_CreateProductNavigationPage;
import ObjectRepository.Program007_CreateProductPage;
import ObjectRepository.Program008_ValidateProducts;
import ObjectRepository.Program010_SwitchingProductPage;

public class Program004_CeateCampaignWithProductUsingBaseClass extends Program005_BaseClass
{
	@Test
	public void createCampaignWithProduct() throws Throwable {
//		Step1:-Login to vtiger application
		
		//reading data from File_Utility
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();
		
		
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
		
		Program001_WebDriver_Utility wlib = new Program001_WebDriver_Utility();
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
	    String actData = valid.validateCampName(driver, CampName);
		Assert.assertEquals(actData, CampName,"Product not Created");
		System.out.println("Campaign Created! " +driver);
		
	    Program008_ValidateProducts valid1 = new Program008_ValidateProducts(driver);
//		valid.validateCampName(driver,CampName);
	    String actData2 = valid1.validateProdName(driver, prodName);
		Assert.assertEquals(actData2, prodName,"Product not Created");
		System.out.println("Product Created! " +driver);
//		Thread.sleep(5000);
//		valid1.validateProdName(driver,prodName);
//		home.logoutFromApp();
	}

}
