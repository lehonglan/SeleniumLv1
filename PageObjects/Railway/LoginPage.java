package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage {
	
	//Locators
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _loginFormTitle = By.xpath("//form[@class='LoginForm']//legend");
	
	//Elements
	public WebElement getTxtUsername()
	{
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	
	public WebElement getTxtPassword()
	{
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	public WebElement getBtnLogin()
	{
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	
	public WebElement getLblLoginErrorMsg()
	{
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
	}
	
	public WebElement getLoginFormTitle()
	{
		return Constant.WEBDRIVER.findElement(_loginFormTitle);
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
	
	public HomePage login(String username, String password)
	{
		//Submit login credentials
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		//Land on Home page
		return new HomePage();
	}
	
	public LoginPage loginfail(String username, String password)
	{
		//Submit login credentials
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		//Land on Login page
		return new LoginPage();
	}

}
