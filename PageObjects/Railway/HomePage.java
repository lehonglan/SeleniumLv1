package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Constant.Constant.TabName;



public class HomePage {
	//Locators
	
	//Elements
	public WebElement getTab(String name)
	{
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", name)));
	}
	
	//Methods
	public HomePage open()
	{
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
	
	public void openTab(TabName	name) {
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
}
