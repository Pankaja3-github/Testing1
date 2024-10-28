package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Program008_ValidateProducts {
	public Program008_ValidateProducts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateProdName(WebDriver driver, String ProdName)
	{
		return driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
//		if(actData.contains(ProdName))
//		{
//			System.out.println("Product Name is Created");
//		}
//		else
//		{
//			System.out.println("Product name not created");
//		}
		 
	}

}
