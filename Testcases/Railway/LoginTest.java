package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Utilities;
import Constant.Constant;
import Messages.LoginMessages;
import Messages.ChangePasswordMessages;
import Messages.LogoutMessages;
import Messages.MyTicketMessages;

public class LoginTest {

	private static final HomePage homePage = new HomePage();
	private static final GeneralPage general = new GeneralPage();
	private static final LoginPage submit = new LoginPage();

	@BeforeMethod
	public void beforeMethod() {
		Utilities.openChrome();
		homePage.open();
	}

	@AfterMethod
	public void afterMethod() {
		Utilities.closeBrowser();
	}

	@Test (description = "User can log into Railway with valid username and password")
	public void TC01() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, Constant.PASSWORD);
		String actual = general.getWelcomeMessage();
		String expected = LoginMessages.SUCCESS;
		Assert.assertEquals(actual, expected,"\nExpected is: " + expected + "\nActual is: " + actual +"\n");
	}

	@Test (description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		general.gotoLoginPage();
		submit.login("", Constant.PASSWORD);
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL;
		Assert.assertEquals(actual, expected,"\nExpected is: " + expected + "\nActual is: " + actual +"\n");
	}

	@Test (description = "User cannot log into Railway with invalid password")
	public void TC03() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, "INVALIDPASS");
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL;
		Assert.assertEquals(actual, expected,"\nExpected is: " + expected + "\nActual is: " + actual +"\n");
	}

	@Test (description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		general.gotoBookTicket();
		String actual = general.getTitle();
		String expected = LoginMessages.TITLE;
		Assert.assertEquals(actual, expected,"\nExpected is: " + expected + "\nActual is: " + actual +"\n");
	}

	@Test (description = "System shows message when user enters wrong password several times")
	public void TC05() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, "INVALIDPASS",4);
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL4TIMES;
		Assert.assertEquals(actual, expected,"\nExpected is: " + expected + "\nActual is: " + actual +"\n");
	}

	@Test (description = "Additional pages display once user logged in")
	public void TC06() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, Constant.PASSWORD);
		boolean actualLogout = general.getTabLogout().isDisplayed();
		boolean actualChangePassword = general.getTabChangePassword().isDisplayed();
		boolean actualMyTicket = general.getTabMyTicket().isDisplayed();
		Assert.assertTrue(actualLogout, LogoutMessages.TABNAME + " tab is not displayed"); 
		Assert.assertTrue(actualChangePassword, ChangePasswordMessages.TITLE + " tab is not displayed");
		Assert.assertTrue(actualMyTicket, MyTicketMessages.TITLE + " tab is not displayed");
	}
	
}
