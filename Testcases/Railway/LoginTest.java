package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Constant.Constant;
import Messages.Fail;
import Utilities.Utilities;

public class LoginTest {

	private static final HomePage homePage = new HomePage();
	private static final GeneralPage generalPage = new GeneralPage();
	private static final LoginPage loginPage = new LoginPage();
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
		homePage.openTab(Constant.tabNameString.tabLogin.getValue());
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		assertEquals(generalPage.getWelcomeMessage(),Constant.Login.SUCCESS);
		homePage.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		homePage.openTab(Constant.tabNameString.tabLogin.getValue());
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getLoginErrorMessage(),Constant.Login.FAIL);
		homePage.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.openTab(Constant.tabNameString.tabLogin.getValue());
		loginPage.login(Constant.USERNAME, "INVALIDPASS");
		assertEquals(loginPage.getLoginErrorMessage(),Constant.Login.FAIL);
		homePage.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		homePage.openTab(Constant.tabNameString.tabBookTicket.getValue());
		assertEquals(generalPage.getCurrentTitle(),Constant.Login.TITLE);
		homePage.logOut();
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.openTab(Constant.tabNameString.tabLogin.getValue());
		loginPage.login(Constant.USERNAME, "INVALIDPASS", 4);
		assertEquals(loginPage.getLoginErrorMessage(),Constant.Login.FAIL4TIMES);
		homePage.logOut();
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.openTab(Constant.tabNameString.tabLogin.getValue());
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabLogin.getValue()), 
				Fail.ElementIsNotShown(Constant.tabNameString.tabLogin.getValue()));
		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabMyTicket.getValue()), 
				Fail.ElementIsNotShown(Constant.tabNameString.tabMyTicket.getValue()));
		softAssertion.assertTrue(Utilities.isTabDisplay(Constant.tabNameString.tabChangePassword.getValue()), 
				Fail.ElementIsNotShown(Constant.tabNameString.tabChangePassword.getValue()));

		homePage.openTab(Constant.tabNameString.tabMyTicket.getValue());
		softAssertion.assertEquals(generalPage.getCurrentTitle(), Constant.tabNameString.tabMyTicket.getValue(),
				Fail.CompareText(generalPage.getCurrentTitle(), Constant.tabNameString.tabMyTicket.getValue()));

		homePage.openTab(Constant.tabNameString.tabChangePassword.getValue());
		softAssertion.assertEquals(generalPage.getCurrentTitle(), Constant.tabNameString.tabChangePassword.getValue(),
				Fail.CompareText(generalPage.getCurrentTitle(), Constant.tabNameString.tabChangePassword.getValue()));

		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(Constant.tabNameString.tabRegister.getValue());
		registerPage.register("username" + Utilities.randomNumber(9999999) + "@logigiear.com", Constant.REGISTER_PASS,
				Constant.REGISTER_PASS, Constant.REGISTER_PID);
		assertEquals(generalPage.getCurrentTitle(), Constant.Register.TITLE);
		homePage.logOut();
	}
}