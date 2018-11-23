package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

	// Locators
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");

	// Elements
	public WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}

	public WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(By.xpath("//h1"));
	}

	// Methods
	public String getWelcomeMessage() {
		return getLblWelcomeMessage().getText();
	}

	public String getCurrentTitle() {
		return getPageTitle().getText();
	}

}