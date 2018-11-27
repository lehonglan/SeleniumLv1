package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.tabName;
import Utilities.Utilities;

public class RegisterTest extends TestBase {
	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(Utilities.generateMail(), Constant.Register.PASSWORD, Constant.Register.PASSWORD,
				Constant.Register.PID);
		assertEquals(generalPage.getCurrentTitle(), Constant.Register.SUCCESS);
		homePage.logOut();
	}

	@Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
	public void TC10() {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(Utilities.generateMail(), Constant.Register.PASSWORD, Constant.Register.PASSWORD + "1",
				Constant.Register.PID);
		assertEquals(registerPage.getMessageError(), Constant.Register.ERROR);
		homePage.logOut();
	}
}