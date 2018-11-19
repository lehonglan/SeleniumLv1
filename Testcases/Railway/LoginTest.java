package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Utilities;
import Constant.Constant;

public class LoginTest {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Download\\Selenium_JAVA_L1\\SeleniumLv1"
				+ "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		
		Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02 - User can't login with blank 'Username' textbox");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.loginfail("", Constant.PASSWORD).getErrorMessage();
		String expectedMsg = "You must specify a username.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message displays correct when user login with blank 'Username'");
		
	}

}
