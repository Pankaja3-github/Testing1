package Product;


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
import ObjectRepository.Program006_CreateProductNavigationPage;
import ObjectRepository.Program007_CreateProductPage;
import ObjectRepository.Program008_ValidateProducts;

//1. Login to vtiger application
//2. click on products link
//3. click on create product lookup image
//4. Enter product name
//5. click on save Btn
//6. verify whether the product is created in product Information page and Logout from the application. 

public class Program001_CreateProduct
{
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
		valid.validateProdName(driver,prodName);
		Thread.sleep(5000);
		
		//7. Logout from the application
		Program002_HomePage home = new Program002_HomePage(driver);
		home.logout(driver);
	}

}
