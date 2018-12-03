package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;
import Constant.Constant.TabName;

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
	
	public String getResetPasswordSuccessMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message success']")).getText();
	}
	
	public String getResetPasswordErrorMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']")).getText();
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

	public void resetPasswordToDefault(String username) {
		sendMailResetPassword(username);
		utilities.openValidateLink("Please reset your password");
		getBox(FormBox.NEW_PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.NEW_PASSWORD).sendKeys(Constant.PASSWORD);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(Constant.PASSWORD);
		clickFormActionButton(FormButton.RESET_PASSWORD);
	}
	
	public void resetPassword(String newpass, String confirmpass) {
		getBox(FormBox.NEW_PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.NEW_PASSWORD).sendKeys(newpass);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(confirmpass);
		clickFormActionButton(FormButton.RESET_PASSWORD);		
	}
	
	public void resetPassword(String newpass, String confirmpass, String resettoken) {
		getBox(FormBox.NEW_PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.RESET_TOKEN).clear();
		getBox(FormBox.NEW_PASSWORD).sendKeys(newpass);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(confirmpass);
		getBox(FormBox.RESET_TOKEN).sendKeys(resettoken);
		clickFormActionButton(FormButton.RESET_PASSWORD);		
	}
	
	public void sendMailResetPassword(String email) {
		homePage.openTab(TabName.LOGIN);
		loginPage.openForgotPasswordLink();
		loginPage.inputEmail(email);
		changePasswordPage.clickFormActionButton(FormButton.SEND_INSTRUCTIONS);
	}
	
	public boolean isFormTitleDisplay() {
		try {
			WebElement x = Constant.WEBDRIVER.findElement(By.xpath("//legend[text()='Password Change Form']"));
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
