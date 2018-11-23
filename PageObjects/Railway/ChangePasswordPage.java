package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ChangePasswordPage {
	
	public WebElement getBtnChangePassword() {
		return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Change Password']"));
	}
	
	public WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}
	
	public String getMessageSuccess() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message success']")).getText();
	}
	
	public String getMessageError() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']")).getText();
	}
	
	public void changePassword(String currentpass, String newpass, String confirmpass) {
		getBox("currentPassword").clear();
		getBox("newPassword").clear();
		getBox("confirmPassword").clear();
		getBox("currentPassword").sendKeys(currentpass);
		getBox("newPassword").sendKeys(newpass);
		getBox("confirmPassword").sendKeys(confirmpass);
		getBtnChangePassword().click();
	}
}