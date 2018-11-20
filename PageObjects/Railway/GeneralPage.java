package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	
	//Locators
	private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
	private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
	private final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	private final By pageTitle = By.xpath("//h1");
	
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
	
	protected WebElement getTabMyTicket() {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
	}
	
	protected WebElement getTabChangePassword() {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
	}
	
	protected WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(pageTitle);
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
	
	public void gotoBookTicket()
	{
		getTabBookTicket().click();
	}
	
	public String getTitle()
	{
		return getPageTitle().getText();
	}
	
	public String getTabLogoutText()
	{
		return getTabLogout().getText();
	}
	
	public String getTabMyTicketText()
	{
		return getTabBookTicket().getText();
	}
	
	public String getTabChangePasswordText()
	{
		return getTabChangePassword().getText();
	}
	
}