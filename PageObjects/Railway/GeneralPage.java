package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

	// Locators
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By pageTitle = By.xpath("//h1");

	// Elements
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}

	protected WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(pageTitle);
	}

	// Methods
	public String getWelcomeMessage() {
		return getLblWelcomeMessage().getText();
	}

	public String getTitle() {
		return getPageTitle().getText();
	}

	public static WebElement getTab(String tabname) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", tabname)));
	}

}