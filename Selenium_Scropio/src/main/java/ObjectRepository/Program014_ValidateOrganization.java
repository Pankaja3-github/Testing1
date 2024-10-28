package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Program014_ValidateOrganization {
	public Program014_ValidateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrgName(WebDriver driver, String OrgName)
	{
//		String actData = 
//		if(actData.contains(OrgName))
//		{
//			System.out.println("Organization Name is Created");
//		}
//		else
//		{
//			System.out.println("Organization Name not created");
//		}
		return driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	}

}
