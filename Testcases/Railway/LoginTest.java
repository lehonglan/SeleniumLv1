package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.Utilities;
import Constant.Constant;
import Messages.ChangePasswordMessages;
import Messages.LoginMessages;
import Messages.MyTicketMessages;
import Messages.RegisterMessages;
import Utilities.CheckButton;

public class LoginTest {

	private static final HomePage homePage = new HomePage();
	private static final GeneralPage general = new GeneralPage();
	private static final LoginPage submit = new LoginPage();
	private static final RegisterPage registerPage = new RegisterPage();
	private static final SoftAssert softAssertion = new SoftAssert();

	@BeforeClass
	public void beforeClass() {
		Utilities.openChrome();
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
		Utilities.closeBrowser();
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, Constant.PASSWORD);
		String actual = general.getWelcomeMessage();
		String expected = LoginMessages.SUCCESS;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
		Utilities.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		general.gotoLoginPage();
		submit.login("", Constant.PASSWORD);
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
		Utilities.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, "INVALIDPASS");
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
		Utilities.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		general.gotoBookTicket();
		String actual = general.getTitle();
		String expected = LoginMessages.TITLE;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, "INVALIDPASS", 4);
		String actual = submit.getLoginErrorMessage();
		String expected = LoginMessages.FAIL4TIMES;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		general.gotoLoginPage();
		submit.login(Constant.USERNAME, Constant.PASSWORD);

		softAssertion.assertTrue(CheckButton.isButtonDisplay("Logout"), "Logout tab is not displayed");
		softAssertion.assertTrue(CheckButton.isButtonDisplay("My ticket"), "My ticket tab is not displayed");
		softAssertion.assertTrue(CheckButton.isButtonDisplay("Change password"),"Change password tab is not displayed");

		GeneralPage.getTab("My ticket").click();
		String actualMyTicketTitle = general.getPageTitle().getText();
		String expectedMyTicketTitle = MyTicketMessages.TITLE;
		softAssertion.assertEquals(actualMyTicketTitle, expectedMyTicketTitle,
				"\nExpected is: " + expectedMyTicketTitle + "\nActual is: " + actualMyTicketTitle + "\n");

		GeneralPage.getTab("Change password").click();
		String actualChangePasswordTitle = general.getPageTitle().getText();
		String expectedChangePasswordTitle = ChangePasswordMessages.TITLE;
		softAssertion.assertEquals(actualChangePasswordTitle, expectedChangePasswordTitle,
				"\nExpected is: " + expectedChangePasswordTitle + "\nActual is: " + actualChangePasswordTitle + "\n");
		softAssertion.assertAll();
		Utilities.logOut();

	}

	@Test(description = "User can create new account")
	public void TC07() {
		GeneralPage.getTab("Register").click();
		registerPage.register("lan.le+12@logigiear.com", Constant.REGISTER_PASS, Constant.REGISTER_PASS,
				Constant.REGISTER_PID);
		String actual = registerPage.getRegisterSuccessMessage().getText();
		String expected = RegisterMessages.TITLE;
		Assert.assertEquals(actual, expected, "\nExpected is: " + expected + "\nActual is: " + actual + "\n");
		Utilities.logOut();
	}
}
