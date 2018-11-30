package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;

public class ChangePasswordPage extends GeneralPage{
	
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
		getBox(FormBox.CURRENT_PASSWORD).clear();
		getBox(FormBox.NEW_PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.CURRENT_PASSWORD).sendKeys(currentpass);
		getBox(FormBox.NEW_PASSWORD).sendKeys(newpass);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(confirmpass);
		clickFormActionButton(FormButton.CHANGE_PASSWORD);
	}

}