package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program006_CreateProductNavigationPage {
	public Program006_CreateProductNavigationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement prodLink;
	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement plusSign;
	
	public WebElement getPlusSign()
	{
		return plusSign;
	}
	
	public void clickProdPlus()
	{
		plusSign.click();
	}
	
	public void getProdLink()
	{
		prodLink.click();
	}

}
