package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class RegisterPage {
	// Locators
	private final By registerButton = By.xpath("//input[@value='Register']");

	// Elements
	public WebElement getRegisterButton() {
		return Constant.WEBDRIVER.findElement(registerButton);
	}

	// Methods
	public static WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}

	public void register(String email, String password, String confirmpassword, String pidnumber) {
		getBox("email").clear();
		getBox("password").clear();
		getBox("confirmPassword").clear();
		getBox("pid").clear();
		getBox("email").sendKeys(email);
		getBox("password").sendKeys(password);
		getBox("confirmPassword").sendKeys(confirmpassword);
		getBox("pid").sendKeys(pidnumber);
		getRegisterButton().click();
	}
}