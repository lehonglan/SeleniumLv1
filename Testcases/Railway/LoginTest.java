package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.ReturnFailMessage;
import Constant.Constant.pageTitle;
import Constant.Constant.tabName;
import Utilities.Utilities;

public class LoginTest extends TestBase {

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertEquals(generalPage.getWelcomeMessage(), Constant.Login.welcomeMessage(Constant.USERNAME));
		homePage.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.ERROR_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME, "INVALIDPASSWORD");
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.ERROR_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		homePage.openTab(tabName.BOOKTICKET);
		assertEquals(generalPage.getCurrentPageTitle(), pageTitle.LOGIN.getValue());
		homePage.logOut();
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME, "INVALIDPASSWORD", 4);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.ERROR_4TIMES_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);

		softAssertion.assertTrue(Utilities.isTabDisplay(tabName.LOGOUT),
				ReturnFailMessage.tabIsNotShown(tabName.LOGOUT));
		softAssertion.assertTrue(Utilities.isTabDisplay(tabName.MYTICKET),
				ReturnFailMessage.tabIsNotShown(tabName.MYTICKET));
		softAssertion.assertTrue(Utilities.isTabDisplay(tabName.CHANGEPASSWORD),
				ReturnFailMessage.tabIsNotShown(tabName.CHANGEPASSWORD));

		homePage.openTab(tabName.MYTICKET);
		softAssertion.assertEquals(generalPage.getCurrentPageTitle(), pageTitle.MYTICKET.getValue());

		homePage.openTab(tabName.CHANGEPASSWORD);
		softAssertion.assertEquals(generalPage.getCurrentPageTitle(), pageTitle.CHANGEPASSWORD.getValue());

		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_INACTIVE, Constant.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.USERNAME_INACTIVE);
		homePage.logOut();
	}
}