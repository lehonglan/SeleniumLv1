package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Utilities.Utilities;

public class TestBase {
	
	protected static final HomePage homePage = new HomePage();
	protected static final RegisterPage registerPage = new RegisterPage();
	protected static final GeneralPage generalPage = new GeneralPage();
	protected static final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	
//	@BeforeSuite
//    public void suiteStart() {
//    }
//	
//	@AfterSuite
//	public void suiteEnd() {
//    }
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChrome();
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
		Utilities.closeBrowser();
	}
	
}
