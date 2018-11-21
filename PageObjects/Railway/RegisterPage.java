package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class RegisterPage {
	// Locators
	private final By registerButton = By.xpath("//input[@value='Register']");
	private final By registerSuccessMessage = By.xpath("//h1");
	
	// Elements
	public WebElement getRegisterButton() {
		return Constant.WEBDRIVER.findElement(registerButton);
	}
	
	public WebElement getRegisterSuccessMessage() {
		return Constant.WEBDRIVER.findElement(registerSuccessMessage);
	}
	
	// Methods
	public static WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}
	
	public void register(String email, String password, String confirmpassword, String pidnumber) {
		// Clear text box before inputting
		getBox("email").clear();
		getBox("password").clear();
		getBox("confirmPassword").clear();
		getBox("pid").clear();
		// Submit login credentials
		getBox("email").sendKeys(email);
		getBox("password").sendKeys(password);
		getBox("confirmPassword").sendKeys(confirmpassword);
		getBox("pid").sendKeys(pidnumber);
		getRegisterButton().click();
	}
}