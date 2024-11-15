package Sample;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program003_Graph 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://emicalculator.net/");
		 List<WebElement> ele = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-markers highcharts-series-2 "
				+ "highcharts-spline-series highcharts-tracker']/*"));
		Actions act = new Actions(driver);
		for (WebElement web : ele) 
		{
			act.moveToElement(web).perform();
			List<WebElement> tooltips = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-label highcharts-tooltip "
					+ "highcharts-color-undefined']//*[name()='text']//*"));
			for (WebElement webEl : tooltips) 
			{
				String text = webEl.getText();
				System.out.println(text);
			}
		}
	}
}

