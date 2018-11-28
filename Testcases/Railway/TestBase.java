package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Constant.Constant;
import Utilities.Utilities;

public class TestBase {

	protected static HomePage homePage = new HomePage();
	protected static RegisterPage registerPage = new RegisterPage();
	protected static GeneralPage generalPage = new GeneralPage();
	protected static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	protected static Utilities utilities = new Utilities();
	protected static LoginPage loginPage = new LoginPage();
//	protected static Constant.Text text = new Constant.Text();

//	@BeforeSuite
//    public void suiteStart() {
//    }
//	
//	@AfterSuite
//	public void suiteEnd() {
//    }

	@BeforeClass
	public void beforeClass() {
		utilities.connectToMail();
		utilities.openURLInBrowser(Constant.RAILWAY_URL, "chrome");
	}

	@AfterClass
	public void afterClass() {
		Utilities.closeBrowser();

	}
}
