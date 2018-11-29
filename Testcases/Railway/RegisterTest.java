package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.Register;
import Constant.Constant.errorForField;
import Constant.Constant.tabName;
import Utilities.Utilities;

public class RegisterTest extends TestBase {

	private static Utilities utilities = new Utilities();

	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail("@mailinator.com"), Register.PASSWORD, Register.PASSWORD,
				Register.PID);
		assertEquals(generalPage.getCurrentPageTitle(), Register.SUCCESS_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
	public void TC10() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail("@mailinator.com"), Constant.Register.PASSWORD,
				Constant.Register.NEW_PASSWORD, Constant.Register.PID);
		assertEquals(registerPage.getRegisterMessageError(), Register.ERROR_FORM_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail("@mailinator.com"), "", "", "");
		softAssertion.assertEquals(registerPage.getRegisterMessageError(), Register.ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(
				registerPage.getMessageErrorNextTheInputField(errorForField.PASSWORD),
				Register.ERROR_PASSWORD_MESSAGE);
		softAssertion.assertEquals(registerPage.getMessageErrorNextTheInputField(errorForField.PID),
				Register.ERROR_PID_MESSAGE);
		homePage.logOut();
		softAssertion.assertAll();
	}
	

	@Test(description = "test")
	public void TC000() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(utilities.generateMail("@gmail.com"), Constant.Register.PASSWORD,
				Constant.Register.PASSWORD, Constant.Register.PID);
		utilities.navigateToURLFromMail();
		homePage.logOut();
	}
}