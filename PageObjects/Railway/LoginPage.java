package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage {

	// Locators
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

	// Elements
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(btnLogin);
	}

	public WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
	}

	public static WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}

	// Methods
	public String getLoginErrorMessage() {
		// Get Error message login form
		return this.getLblLoginErrorMsg().getText();
	}

	public void login(String username, String password) {
		// Clear text box before inputting
		getBox("username").clear();
		getBox("password").clear();
		// Submit login credentials
		getBox("username").sendKeys(username);
		getBox("password").sendKeys(password);
		getBtnLogin().click();
	}

	public void login(String username, String password, int times) {
		for (int i = 1; i <= times; i++) {
			login(username, password);
		}
	}

}
