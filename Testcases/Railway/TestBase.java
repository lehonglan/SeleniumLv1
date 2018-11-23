package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.Utilities;

public class TestBase {
	
	protected static final HomePage homePage = new HomePage();
	protected static final RegisterPage registerPage = new RegisterPage();
	protected static final GeneralPage generalPage = new GeneralPage();
	
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
