package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Utilities.Utilities;

public class RegisterTest extends TestBase{
	@Test(description = "User can create new account")
	public void TC07() {
		homePage.openTab(Constant.tabNameString.tabRegister.getValue());
		registerPage.register(Utilities.generateMail(), Constant.REGISTER_PASS, Constant.REGISTER_PASS, Constant.REGISTER_PID);
		assertEquals(generalPage.getCurrentTitle(), Constant.Register.TITLE);
		homePage.logOut();
	}
}