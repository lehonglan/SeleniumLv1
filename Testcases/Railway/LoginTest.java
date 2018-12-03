package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.Login;
import Constant.Constant.ReturnFailMessage;
import Constant.Constant.TabName;
import Constant.Constant.pageHeader;
import Utilities.Utilities;

public class LoginTest extends TestBase {

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertEquals(generalPage.getWelcomeMessage(), Login.welcomeMessage(Constant.USERNAME));
		homePage.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Login.ERROR_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME, "INVALIDPASSWORD");
		assertEquals(loginPage.getLoginErrorMessage(), Login.ERROR_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		homePage.openTab(TabName.BOOKTICKET);
		assertEquals(generalPage.getCurrentHeader(), pageHeader.LOGIN.getValue());
		homePage.logOut();
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME, "INVALIDPASSWORD", 4);
		assertEquals(loginPage.getLoginErrorMessage(), Login.ERROR_4TIMES_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);

		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.LOGOUT),
				ReturnFailMessage.tabIsNotShown(TabName.LOGOUT));
		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.MYTICKET),
				ReturnFailMessage.tabIsNotShown(TabName.MYTICKET));
		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.CHANGEPASSWORD),
				ReturnFailMessage.tabIsNotShown(TabName.CHANGEPASSWORD));

		homePage.openTab(TabName.MYTICKET);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), pageHeader.MYTICKET.getValue());

		homePage.openTab(TabName.CHANGEPASSWORD);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), pageHeader.CHANGEPASSWORD.getValue());

		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_INACTIVE, Constant.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Login.INACTIVE_ACCOUNT_MESSAGE);
		homePage.logOut();
	}
}