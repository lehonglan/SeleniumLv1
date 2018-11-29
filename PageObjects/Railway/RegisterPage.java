package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class RegisterPage extends GeneralPage{
	// Locators

	// Elements

	// Methods
	public String getRegisterMessageError() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']")).getText();
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
		clickFormActionButton();
	}
}