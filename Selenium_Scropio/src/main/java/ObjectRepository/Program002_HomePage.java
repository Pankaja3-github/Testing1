package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program002_HomePage {
	//constructor for Element initialization
	public Program002_HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Element Declaration
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	
	@FindBy(linkText = "Products")
	private WebElement prdLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdmLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	
//	getter methods
	public WebElement getMoreLink() 
	{
		return moreLink;
	}
	public WebElement getCampaignsLink() 
	{
		return campaignsLink;
	}
	
	
//	Business Logic
	public void clickMoreLink()
	{
		moreLink.click();
	}
	public void clickCampLink()
	{
		campaignsLink.click();
	}
	
	public void clickProductLink()
	{
		prdLink.click();
	}
	public void logoutFromApp() 
	{
		AdmLink.click();
		signOutLink.click();
	}
	public void logout(WebDriver driver) 
	{
		Actions act = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act.moveToElement(AdmLink).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
		signOutLink.click();
	}
}
