package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;
import Utilities.Utilities;

public class GeneralPage {
	
	protected static HomePage homePage = new HomePage();
	protected static RegisterPage registerPage = new RegisterPage();
	protected static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	protected static Utilities utilities = new Utilities();
	protected static LoginPage loginPage = new LoginPage();
	protected static BookTicketPage bookTicketPage = new BookTicketPage();
	protected static GeneralPage generalPage = new GeneralPage();
	
	// Elements
	public WebElement getBox(FormBox boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname.getValue()));
	}
	
	public WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']"));
	}

	public WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(By.xpath("//h1"));
	}

	// Methods
	public String getMessageErrorNextTheBox(FormBox boxname) {
		return Constant.WEBDRIVER
				.findElement(By.xpath(String.format("//label[@class='validation-error' and @for='%s']", boxname.getValue()))).getText();
	}
	
	public String getWelcomeMessage() {
		return getLblWelcomeMessage().getText();
	}

	public String getCurrentHeader() {
		return getPageTitle().getText();
	}
	
	public void clickFormActionButton(FormButton button) {
		Constant.WEBDRIVER.findElement(By.xpath(String.format("//input[@type='submit' and @value='%s']",button.getValue()))).click();
	}
}