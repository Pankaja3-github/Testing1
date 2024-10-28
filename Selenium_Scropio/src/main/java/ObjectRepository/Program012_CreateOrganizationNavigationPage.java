package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program012_CreateOrganizationNavigationPage {
	public Program012_CreateOrganizationNavigationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement plusSign;
	
	public WebElement getPluSign()
	{
		return plusSign;
	}
	
	public void clickOrgPlus()
	{
		plusSign.click();
	}
	
	public void getOrgLink()
	{
		orgLink.click();
	}

}
