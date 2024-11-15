package Sample;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Program002_TakeScreenShotEx {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
			driver.get("https://www.flipkart.com");

			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
		    File dest = new File("./ScreenShotImgs.png");
		    FileUtils.copyFile(src, dest);
		}

}
