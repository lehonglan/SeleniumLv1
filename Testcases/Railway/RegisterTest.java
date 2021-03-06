package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Constant.Constant.FormBox;
import Constant.Constant.Register;
import Constant.Constant.TabName;
import Utilities.Utilities;

public class RegisterTest extends TestBase {

	private static Utilities utilities = new Utilities();

	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(TabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.PASSWORD, Constant.PASSWORD,
				Constant.PASSWORD);
		assertEquals(generalPage.getCurrentHeader(), Register.SUCCESS_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
	public void TC10() {
		homePage.openTab(TabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.PASSWORD,
				Constant.NEW_PASSWORD, Constant.PASSWORD);
		assertEquals(registerPage.getErrorMessage(), Register.ERROR_FORM_MESSAGE);
		homePage.logOut();
	}

	@Test(description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		SoftAssert softAssertion = new SoftAssert();
		
		homePage.openTab(TabName.REGISTER);
		registerPage.register(utilities.generateMail(), Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
		softAssertion.assertEquals(registerPage.getErrorMessage(), Register.ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(
				registerPage.getMessageErrorNextTheBox(FormBox.PASSWORD),
				Register.ERROR_PASSWORD_MESSAGE);
		softAssertion.assertEquals(registerPage.getMessageErrorNextTheBox(FormBox.PID),
				Register.ERROR_PID_MESSAGE);
		homePage.logOut();
		softAssertion.assertAll();
	}
	
}
