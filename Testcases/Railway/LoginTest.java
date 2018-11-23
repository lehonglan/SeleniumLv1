package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Utilities.Utilities;

public class LoginTest extends TestBase {

	private static final LoginPage loginPage = new LoginPage();
	private static final SoftAssert softAssertion = new SoftAssert();

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.Login.USERNAME, Constant.Login.PASSWORD);
		assertEquals(generalPage.getWelcomeMessage(), Constant.Login.SUCCESS);
		homePage.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login("", Constant.Login.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.FAIL);
		homePage.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.Login.USERNAME, "INVALIDPASSWORD");
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.FAIL);
		homePage.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		homePage.openTab(Constant.tabNameString.tabBookTicket.getText());
		assertEquals(generalPage.getCurrentTitle(), Constant.Login.TITLE);
		homePage.logOut();
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.Login.USERNAME, "INVALIDPASSWORD", 4);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.FAIL4TIMES);
		homePage.logOut();
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.Login.USERNAME, Constant.Login.PASSWORD);

		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabLogout.getText()),
				Constant.returnFailMessage.ElementIsNotShown(Constant.tabNameString.tabLogout.getText()));
		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabMyTicket.getText()),
				Constant.returnFailMessage.ElementIsNotShown(Constant.tabNameString.tabMyTicket.getText()));
		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabChangePassword.getText()),
				Constant.returnFailMessage.ElementIsNotShown(Constant.tabNameString.tabChangePassword.getText()));

		homePage.openTab(Constant.tabNameString.tabMyTicket.getText());
		softAssertion.assertEquals(generalPage.getCurrentTitle(), Constant.MyTicket.TITLE);

		homePage.openTab(Constant.tabNameString.tabChangePassword.getText());
		softAssertion.assertEquals(generalPage.getCurrentTitle(), Constant.ChangePassword.TITLE);

		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.InactiveAccount.USERNAME, Constant.InactiveAccount.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Login.INACTIVE_ACCOUNT);
		homePage.logOut();
	}

	@Test(description = "User can change password")
	public void TC09() {
		homePage.openTab(Constant.tabNameString.tabLogin.getText());
		loginPage.login(Constant.Login.USERNAME, Constant.Login.PASSWORD);
		homePage.openTab(Constant.tabNameString.tabChangePassword.getText());
		changePasswordPage.changePassword(Constant.Login.PASSWORD, Constant.Login.PASSWORD, Constant.Login.PASSWORD);
		assertEquals(changePasswordPage.getMessageSuccess(), Constant.ChangePassword.SUCCESS);
		homePage.logOut();
	}

}