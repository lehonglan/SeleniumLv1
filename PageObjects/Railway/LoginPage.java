package Railway;

import org.openqa.selenium.By;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;

public class LoginPage extends GeneralPage{

	// Elements

	// Methods
	public void inputEmail (String email) {
		getBox(FormBox.EMAIL).clear();
		getBox(FormBox.EMAIL).sendKeys(email);
	}
	
	public String getLoginErrorMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']")).getText();
	}
	
	public void openForgotPasswordLink() {
		Constant.WEBDRIVER.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
	}

	public void login(String username, String password) {
		getBox(FormBox.USERNAME).clear();
		getBox(FormBox.PASSWORD).clear();
		getBox(FormBox.USERNAME).sendKeys(username);
		getBox(FormBox.PASSWORD).sendKeys(password);
		clickFormActionButton(FormButton.LOGIN);
	}

	public void login(String username, String password, int times) {
		for (int i = 1; i <= times; i++) {
			login(username, password);
		}
	}

}
