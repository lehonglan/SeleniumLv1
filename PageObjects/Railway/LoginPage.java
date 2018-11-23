package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage {

	// Elements
	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='login']"));
	}

	public WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']"));
	}

	public WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}

	// Methods
	public String getLoginErrorMessage() {
		return this.getLblLoginErrorMsg().getText();
	}

	public void login(String username, String password) {
		getBox("username").clear();
		getBox("password").clear();
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
