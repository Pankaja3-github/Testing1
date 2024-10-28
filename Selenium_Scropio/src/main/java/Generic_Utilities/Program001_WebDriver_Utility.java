package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program001_WebDriver_Utility 
{
	public void  maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void waitForCondition(WebDriver driver, String Title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(Title));
	}
	
//	public void customizedWait(WebDriver driver, String Title)
//	{
//		FluentWait wait = new FluentWait(driver);
//		wait.pollingEvery(Duration.ofSeconds(1));
//		wait.withTimeout(Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.titleContains(Title));
//	}
	public void alertAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	public void moveToElementCursor(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		//6. Logout from the application
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> iterator = allWins.iterator();
		
		while(iterator.hasNext())
		{
			String win = iterator.next();
			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			if(title.contains("Products&action"));
//			{
//				break;
//			}
		}
	}
	
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
//	public void executeJavaScript(WebDriver driver , String javaScript) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeAsyncScript(javaScript, null);
//	}
	

	   public void passEnterKey(WebDriver driver) 
	   {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   }
	   
	   public void moveToElement(WebDriver driver,WebElement ele)
		{
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
		}
	
	

}
