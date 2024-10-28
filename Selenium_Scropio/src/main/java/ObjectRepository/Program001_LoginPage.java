package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Program001_LoginPage {
	//constructor for Element initialization
	public Program001_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); // all findBys will get executed using initElement
	}
	
	//Element Declaration
	@FindBy(name = "user_name")
	private WebElement userTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	
	//getter methods
	public WebElement getUserTextField()
	{
		return userTextField;
	}
	public WebElement getPasswordTextField()
	{
		return passwordTextField;
	}
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	
	//Business logic -> this method is used to login into application
	public void loginToVtiger(String username,String password)
	{
		userTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
