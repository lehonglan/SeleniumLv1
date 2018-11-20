package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage {
	
	//Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By loginFormTitle = By.xpath("//form[@class='LoginForm']//legend");
	
	//Elements
	public WebElement getTxtUsername()
	{
		return Constant.WEBDRIVER.findElement(txtUsername);
	}
	
	public WebElement getTxtPassword()
	{
		return Constant.WEBDRIVER.findElement(txtPassword);
	}
	
	public WebElement getBtnLogin()
	{
		return Constant.WEBDRIVER.findElement(btnLogin);
	}
	
	public WebElement getLblLoginErrorMsg()
	{
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
	}
	
	public WebElement getLoginFormTitle()
	{
		return Constant.WEBDRIVER.findElement(loginFormTitle);
	}
	
	
	//Methods
	
	public String getLoginErrorMessage()
	{
		//Get Error message login form
		return this.getLblLoginErrorMsg().getText();
	}

	public String getTextLoginFormTitle()
	{
		//Get Login form title
		return this.getLoginFormTitle().getText();
	}
	
	public void login(String username, String password)
	{
		//Submit login credentials
		getTxtUsername().sendKeys(username);
		getTxtPassword().sendKeys(password);
		getBtnLogin().click();
	}
	
	public void loginfail(String username, String password)
	{
		//Submit login credentials
		getTxtUsername().sendKeys(username);
		getTxtPassword().sendKeys(password);
		getBtnLogin().click();
	}

}
