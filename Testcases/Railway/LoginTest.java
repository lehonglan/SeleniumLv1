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
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Lv1"
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
		
		String actualMsg = loginPage.loginfail("", Constant.PASSWORD).getLoginErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
			
		Assert.assertEquals(actualMsg, expectedMsg, "User can login with blank 'Username'");
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.loginfail(Constant.USERNAME, Constant.WRONG_PASS).getLoginErrorMessage();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
			
		Assert.assertEquals(actualMsg, expectedMsg, "User can login with wrong 'Password'");
	}
	
	@Test
	public void TC04() {
		System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPageFromBookTicket();
		
		String actualMsg = loginPage.getTextLoginFormTitle();
		String expectedMsg = "Log in to your account";
			
		Assert.assertEquals(actualMsg, expectedMsg, "Login page doesn't show when selecting 'Book ticket' tab");
	}
	
	@Test
	public void TC05() {
		System.out.println("TC05 - System shows message when user enters wrong password several times");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.loginfail(Constant.USERNAME, Constant.WRONG_PASS);
		loginPage.loginfail(Constant.USERNAME, Constant.WRONG_PASS);
		loginPage.loginfail(Constant.USERNAME, Constant.WRONG_PASS);
		
		String actualMsg = loginPage.loginfail(Constant.USERNAME, Constant.WRONG_PASS).getLoginErrorMessage();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
			
		Assert.assertEquals(actualMsg, expectedMsg, "The correct message doesn't show");
	}
	
}
