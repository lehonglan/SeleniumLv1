package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.Register;
import Constant.Constant.tabName;
import Utilities.Utilities;

public class RegisterTest extends TestBase {

	private static Utilities utilities = new Utilities();

	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.PASSWORD, Constant.PASSWORD,
				Constant.PASSWORD);
		assertEquals(generalPage.getCurrentHeader(), Register.SUCCESS_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
	public void TC10() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.PASSWORD,
				Constant.NEW_PASSWORD, Constant.PASSWORD);
		assertEquals(registerPage.getRegisterMessageError(), Register.ERROR_FORM_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
		softAssertion.assertEquals(registerPage.getRegisterMessageError(), Register.ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(
				registerPage.getMessageErrorNextTheBox(FormBox.PASSWORD),
				Register.ERROR_PASSWORD_MESSAGE);
		softAssertion.assertEquals(registerPage.getMessageErrorNextTheBox(FormBox.PID),
				Register.ERROR_PID_MESSAGE);
		homePage.logOut();
		softAssertion.assertAll();
	}
	
}