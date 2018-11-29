package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ChangePasswordPage extends GeneralPage{
	
	public WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}
	
	public String getMessageSuccess() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message success']")).getText();
	}
	
	public String getMessageError() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']")).getText();
	}
	
	public boolean isFormTitleDisplay() {
		try {
			WebElement x = Constant.WEBDRIVER.findElement(By.xpath("//legend[text()='Password Change Form']"));
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void changePassword(String currentpass, String newpass, String confirmpass) {
		getBox("currentPassword").clear();
		getBox("newPassword").clear();
		getBox("confirmPassword").clear();
		getBox("currentPassword").sendKeys(currentpass);
		getBox("newPassword").sendKeys(newpass);
		getBox("confirmPassword").sendKeys(confirmpass);
		clickFormActionButton();
	}
	
	public void resetPassword(String newpass, String confirmpass, String resettoken) {
		getBox("newPassword").clear();
		getBox("confirmPassword").clear();
		getBox("resetToken").clear();
		getBox("newPassword").sendKeys(newpass);
		getBox("confirmPassword").sendKeys(confirmpass);
		getBox("resetToken").sendKeys(resettoken);
		clickFormActionButton();
	}
}