package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Constant.Constant;
import Messages.ChangePasswordMessages;
import Messages.LoginMessages;
import Messages.MyTicketMessages;
import Messages.RegisterMessages;
import Messages.TabName;
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
		GeneralPage.getTab(TabName.tabLogin).click();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		Utilities.assertCheckTextElement(generalPage.getWelcomeMessage(), LoginMessages.SUCCESS);
		Utilities.logOut();
	}

	@Test(description = "User can't login with blank 'Username' textbox")
	public void TC02() {
		GeneralPage.getTab(TabName.tabLogin).click();
		loginPage.login("", Constant.PASSWORD);
		Utilities.assertCheckTextElement(loginPage.getLoginErrorMessage(), LoginMessages.FAIL);
		Utilities.logOut();
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		GeneralPage.getTab(TabName.tabLogin).click();
		loginPage.login(Constant.USERNAME, "INVALIDPASS");
		Utilities.assertCheckTextElement(loginPage.getLoginErrorMessage(), LoginMessages.FAIL);
		Utilities.logOut();
	}

	@Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
	public void TC04() {
		GeneralPage.getTab(TabName.tabBookTicket).click();
		Utilities.assertCheckTextElement(generalPage.getTitle(), LoginMessages.TITLE);
		Utilities.logOut();
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		GeneralPage.getTab(TabName.tabLogin).click();
		loginPage.login(Constant.USERNAME, "INVALIDPASS", 4);
		Utilities.assertCheckTextElement(loginPage.getLoginErrorMessage(), LoginMessages.FAIL4TIMES);
		Utilities.logOut();
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		GeneralPage.getTab(TabName.tabLogin).click();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		
		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.tabLogout), Fail.ElementIsNotShown(TabName.tabLogout));
		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.tabMyTicket), Fail.ElementIsNotShown(TabName.tabMyTicket));
		softAssertion.assertTrue(Utilities.isTabDisplay(TabName.tabChangePassword),	Fail.ElementIsNotShown(TabName.tabChangePassword));

		GeneralPage.getTab(TabName.tabMyTicket).click();
		softAssertion.assertEquals(generalPage.getPageTitle().getText(), MyTicketMessages.TITLE,
				Fail.CompareText(generalPage.getPageTitle().getText(), MyTicketMessages.TITLE));

		GeneralPage.getTab(TabName.tabChangePassword).click();
		softAssertion.assertEquals(generalPage.getPageTitle().getText(), ChangePasswordMessages.TITLE,
				Fail.CompareText(generalPage.getPageTitle().getText(), ChangePasswordMessages.TITLE));

		Utilities.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can create new account")
	public void TC07() {
		GeneralPage.getTab(TabName.tabRegister).click();
		registerPage.register("username" + Utilities.randomNumber(9999999) + "@logigiear.com", Constant.REGISTER_PASS,
				Constant.REGISTER_PASS, Constant.REGISTER_PID);
		Utilities.assertCheckTextElement(registerPage.getRegisterSuccessMessage().getText(), RegisterMessages.TITLE);
		Utilities.logOut();
	}
}