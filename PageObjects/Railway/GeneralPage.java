package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	
	//Locators
	private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	
	//Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}
	
	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}
	
	//Methods
	public String getWelcomeMessage()
	{
		return getLblWelcomeMessage().getText();
	}
	
	public void gotoLoginPage()
	{
		getTabLogin().click();
	}
	
	public void gotoLoginPageFromBookTicket()
	{
		getTabBookTicket().click();
	}
}