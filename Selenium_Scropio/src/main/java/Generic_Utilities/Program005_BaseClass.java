package Generic_Utilities;

//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ObjectRepository.Program001_LoginPage;
import ObjectRepository.Program002_HomePage;

public class Program005_BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
//	public static TakesScreenshot sdriver;
	
    @BeforeSuite(groups = {"SmokeTest","RegressionTest"})
    public void bs()
    {
	    System.out.println("DataBase Connection");
    }

    @BeforeTest(groups = {"SmokeTest","RegressionTest"})
    public void bt()
    {
	    System.out.println("Parallel Execution");
    }

    @Parameters("BROWSER")
    @BeforeClass(groups = {"SmokeTest","RegressionTest"})
    public void bc(@Optional("Chrome") String BROWSER) throws Throwable
    {
//	    Program002_File_Utility flib = new Program002_File_Utility();
//	    String BROWSER = flib.getKeyAndValuePair("browser");
	
	    if (BROWSER.equalsIgnoreCase("chrome")) 
	    {
		    driver = new ChromeDriver();
	    }
	    else if (BROWSER.equalsIgnoreCase("edge")) 
	    {
		    driver = new EdgeDriver();
	    }
        else if (BROWSER.equalsIgnoreCase("firefox")) 
        {
		    driver = new FirefoxDriver();
	    } 
        else 
        {
		driver = new EdgeDriver();
	}
	System.out.println("Launching Browser");
}

    @Parameters({"URL","USERNAME","PASSWORD"})
    @BeforeMethod(groups = {"SmokeTest","RegressionTest"})
    public void bm(@Optional("http://localhost:8888") String URL,
    		@Optional("admin") String USERNAME,
    		@Optional("admin") String PASSWORD) throws Throwable
    {
		Program001_WebDriver_Utility wlib = new Program001_WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForElementsToLoad(driver);
//		Program002_File_Utility flib = new Program002_File_Utility();
//		String URL = flib.getKeyAndValuePair("url");
//		String username = flib.getKeyAndValuePair("username");
//		String password = flib.getKeyAndValuePair("password");
		
		driver.get(URL);
		Program001_LoginPage loginPage = new Program001_LoginPage(driver);
		loginPage.loginToVtiger(USERNAME, PASSWORD);
    	System.out.println("Login to Application");
    }

    @AfterMethod(groups = {"SmokeTest","RegressionTest"})
    public void am()
    {
	    Program002_HomePage home = new Program002_HomePage(driver);
	    home.logout(driver);
    	System.out.println("Logout from Application");
    }

    @AfterClass(groups = {"SmokeTest","RegressionTest"})
    public void ac()
    {
    	driver.quit();
    	System.out.println("Close the Browser");
    }

    @AfterTest(groups = {"SmokeTest","RegressionTest"})
    public void at()
    {
	    System.out.println("Parallel Execution Done");
    }

    @AfterSuite(groups = {"SmokeTest","RegressionTest"})
    public void as()
    {
	    System.out.println("Close Database Connection");
    }

}
