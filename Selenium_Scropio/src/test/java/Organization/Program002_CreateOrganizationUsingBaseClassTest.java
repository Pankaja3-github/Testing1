package Organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import Generic_Utilities.Program005_BaseClass;
import ObjectRepository.Program012_CreateOrganizationNavigationPage;
import ObjectRepository.Program013_CreateOrganizationPage;
import ObjectRepository.Program014_ValidateOrganization;

public class Program002_CreateOrganizationUsingBaseClassTest extends Program005_BaseClass 
{
	@Test
	public void createOrganizationTest() throws Throwable {
		//Step1:-Login to vtiger application		
		//reading data from File_Utility
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();
		
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
//		valid.validateOrgName(driver,orgName);
		String actData = valid.validateOrgName(driver, orgName);
		Assert.assertEquals(actData, orgName,"Product not Created");
		System.out.println("Organization Created! " +driver);
        
        //6. Logout
//		Program002_HomePage home = new Program002_HomePage(driver);
//		home.logout(driver);
		System.out.println("Successfully logged out");
		}

}
