package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class LoginPage extends GeneralPage{

	// Elements

	// Methods
	public void inputEmail (String email) {
		getBox("email").clear();
		getBox("email").sendKeys(email);
		clickFormActionButton();
	}
	
	public String getLoginErrorMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']")).getText();
	}
	
	public void openForgotPasswordLink() {
		Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
	}

	public void login(String username, String password) {
		getBox("username").clear();
		getBox("password").clear();
		getBox("username").sendKeys(username);
		getBox("password").sendKeys(password);
		clickFormActionButton();
	}

	public void login(String username, String password, int times) {
		for (int i = 1; i <= times; i++) {
			login(username, password);
		}
	}

}
