package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program004_CreateCampaignPage {
	public Program004_CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campName;	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement prodPlus;
	
	public WebElement getcampName()
	{
		return campName;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	public WebElement getProdPlus()
	{
		return prodPlus;
	}
	
	public void clickProdPlus()
	{
		prodPlus.click();
	}
	
	public void enterCampName(String Name)
	{
		campName.sendKeys(Name);
	}
	public void clickSaveButton() {
		saveButton.click();
		
	}
	

}
