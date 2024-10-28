package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import Generic_Utilities.Program005_BaseClass;
import ObjectRepository.Program002_HomePage;
import ObjectRepository.Program003_CampaignCreateNavigationPage;
import ObjectRepository.Program004_CreateCampaignPage;
import ObjectRepository.Program005_ValidateCampaigns;

public class Program003_CreateCampaignUsingBaseClassTest extends Program005_BaseClass{
	@Test(groups = "RegressionTest")
	public void createCampaignsTest() throws Throwable 
	{
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();


		Program002_HomePage home = new Program002_HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		Program003_CampaignCreateNavigationPage camp = new Program003_CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();

		int ranNum = jlib.getRandomNum();

		String CampName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(CampName);

		Program004_CreateCampaignPage campPage = new Program004_CreateCampaignPage(driver);
		campPage.enterCampName(CampName);
		campPage.clickSaveButton();

		Program005_ValidateCampaigns valid = new Program005_ValidateCampaigns(driver);
		String actData = valid.validateCampName(driver, CampName);
		Assert.assertEquals(actData, CampName,"Product not Created");
		System.out.println("Campaign Created! " +driver);
//		home.logout(driver);
	}
	
	@Test
	public void m1()
	{
		System.out.println("hello!");
	}

}
