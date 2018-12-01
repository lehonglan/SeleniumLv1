package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Utilities.Utilities;

public class TestBase {

	protected static HomePage homePage = new HomePage();
	protected static RegisterPage registerPage = new RegisterPage();
	protected static GeneralPage generalPage = new GeneralPage();
	protected static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	protected static Utilities utilities = new Utilities();
	protected static LoginPage loginPage = new LoginPage();
	protected static BookTicketPage bookTicketPage = new BookTicketPage();
	protected static SoftAssert softAssertion = new SoftAssert();

	@BeforeClass
	public void beforeClass() {
		utilities.openURLInBrowser(Constant.RAILWAY_URL, "chrome");
	}

//	@AfterClass
//	public void afterClass() {
//		Utilities.closeBrowser();
//	}
}
