package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program013_CreateOrganizationPage {
	public Program013_CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(id="phone")
	private WebElement phone;
	@FindBy(id="email1")
	private WebElement email;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	
	public WebElement getOrgName()
	{
		return orgName;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	
	
	public void enterOrgName(String Name)
	{
		orgName.sendKeys(Name);
	}
	public void enterPhone(String Number)
	{
		phone.sendKeys(Number);
	}
	public void enterEmail(String Email)
	{
		email.sendKeys(Email);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}

}
