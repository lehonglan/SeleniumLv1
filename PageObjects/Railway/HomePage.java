package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class HomePage extends GeneralPage {
	
	//Locators
	
	//Elements
	public WebElement getTab(String tabname)
	{
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", tabname)));
	}
	
	//Methods
	public HomePage open()
	{
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
	
	public void openTab(String tabname) {
		getTab(tabname).click();
	}
	
	public void getTabName(String tabname) {
		getTab(tabname).getText();
	}
	
	public void logOut() {
		try {
			openTab(Constant.tabNameString.tabLogout.getText());
		} catch (Exception e) {
		}
	}
}
