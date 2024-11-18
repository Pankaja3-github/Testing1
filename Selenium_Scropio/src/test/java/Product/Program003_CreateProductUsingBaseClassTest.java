package Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Program003_Java_Utility;
import Generic_Utilities.Program004_Excel_Utility;
import Generic_Utilities.Program005_BaseClass;
import ObjectRepository.Program006_CreateProductNavigationPage;
import ObjectRepository.Program007_CreateProductPage;
import ObjectRepository.Program008_ValidateProducts;

public class Program003_CreateProductUsingBaseClassTest extends Program005_BaseClass{
	@Test(groups = "RegressionTest")
	public void createProductTest() throws Throwable {
		//Step1:-Login to vtiger application		
		//reading data from File_Utility
		Program003_Java_Utility jlib = new Program003_Java_Utility();
		Program004_Excel_Utility elib = new Program004_Excel_Utility();
		
		
		//2. click on products link 
		Program006_CreateProductNavigationPage prod = new Program006_CreateProductNavigationPage(driver);
		prod.getProdLink();
		
		//3. click on create product lookup image 
		prod.clickProdPlus();
		int ranNum = jlib.getRandomNum();
		
		//4. Enter product name		
		String prodName = elib.getExcelDataForProduct("Product",0,0) + ranNum;
		System.out.println(prodName);
		
		//5. click on save Btn
		Program007_CreateProductPage prod2 = new Program007_CreateProductPage(driver);
		prod2.enterProdName(prodName);
		prod2.clickSaveButton();
		
		//6. verify whether the product is created in product Information page
		Program008_ValidateProducts valid = new Program008_ValidateProducts(driver);
//		valid.validateProdName(driver,prodName);
		String actData = valid.validateProdName(driver, prodName);
		Assert.assertEquals(actData, prodName,"Product not Created");
		System.out.println("Product Created! " +driver);
		Thread.sleep(5000);
		
		//7. Logout from the application
//		Program002_HomePage home = new Program002_HomePage(driver);
//		home.logout(driver);
	}
}
