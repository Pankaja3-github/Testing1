package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Program001_WebDriver_Utility;

public class Program015_DebuggingEx2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		Program001_WebDriver_Utility wlib =  new Program001_WebDriver_Utility();
		wlib.maximizeWindow(driver);
		
		driver.findElement(By.name("field-keywords")).sendKeys("puma");
		driver.close();
	}

}
