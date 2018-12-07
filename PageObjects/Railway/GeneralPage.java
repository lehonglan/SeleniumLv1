package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;
import Constant.Constant.TabName;
import Utilities.Utilities;

public class GeneralPage {

	protected static HomePage homePage = new HomePage();
	protected static RegisterPage registerPage = new RegisterPage();
	protected static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	protected static Utilities utilities = new Utilities();
	protected static LoginPage loginPage = new LoginPage();
	protected static BookTicketPage bookTicketPage = new BookTicketPage();
	protected static GeneralPage generalPage = new GeneralPage();

	public WebElement getTab(String name) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", name)));
	}

	public WebElement getBox(FormBox boxname) {
		return Constant.WEBDRIVER.findElement(By.id(boxname.getValue()));
	}

	public WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']"));
	}

	public WebElement getPageTitle() {
		return Constant.WEBDRIVER.findElement(By.xpath("//h1"));
	}

	public void openTab(TabName name) {
		getTab(name.getValue()).click();
	}

	public void getTabName(TabName name) {
		getTab(name.getValue()).getText();
	}

	public void logOut() {
		try {
			openTab(TabName.LOGOUT);
		} catch (Exception e) {
		}
	}

	public String getErrorMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[contains(@class,'error')]")).getText();
	}

	public String getSuccessMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//p[contains(@class,'success')]")).getText();
	}

	public String getMessageErrorNextTheBox(FormBox boxname) {
		return Constant.WEBDRIVER
				.findElement(By.xpath(String.format("//input[@id='%s']/following-sibling::label", boxname.getValue())))
				.getText();
	}

	public String getWelcomeMessage() {
		return getLblWelcomeMessage().getText();
	}

	public String getCurrentHeader() {
		return getPageTitle().getText();
	}

	public void clickFormActionButton(FormButton button) {
		Constant.WEBDRIVER
				.findElement(By.xpath(String.format("//input[@type='submit' and @value='%s']", button.getValue())))
				.click();
	}
}
