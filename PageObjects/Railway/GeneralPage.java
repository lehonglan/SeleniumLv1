package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.errorForField;

public class GeneralPage {

	// Elements
	public WebElement getBox(String boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname));
	}
	
	public WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']"));
	}

	public WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(By.xpath("//h1"));
	}

	// Methods
	public String getMessageErrorNextTheInputField(errorForField boxname) {
		return Constant.WEBDRIVER
				.findElement(By.xpath(String.format("//label[@class='validation-error' and @for='%s']", boxname.getValue()))).getText();
	}
	
	public String getWelcomeMessage() {
		return getLblWelcomeMessage().getText();
	}

	public String getCurrentPageTitle() {
		return getPageTitle().getText();
	}
	
	public void clickFormActionButton() {
		Constant.WEBDRIVER.findElement(By.xpath("//p[@class= 'form-actions']")).click();;
	}
}