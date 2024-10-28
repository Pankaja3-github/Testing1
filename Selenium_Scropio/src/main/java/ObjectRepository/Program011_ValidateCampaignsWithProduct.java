package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Program011_ValidateCampaignsWithProduct {
	public Program011_ValidateCampaignsWithProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCampName(WebDriver driver, String CampName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(actData.contains(CampName))
		{
			System.out.println("Campaigns Name is created");
		}
		else 
		{
			System.out.println("Campaigns Name is not created");
		}
	}
		
		
		public void validatePrdName(WebDriver driver, String CampName)
		{
			String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
			if(actData.contains(CampName))
			{
				System.out.println("Product Name is created");
			}
			else 
			{
				System.out.println("Product Name is not created");
			}
		
	}

}
