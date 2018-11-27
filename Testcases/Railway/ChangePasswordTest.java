package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.BackupAccount;
import Constant.Constant.tabName;

public class ChangePasswordTest extends TestBase{
	
	@Test(description = "User can change password")
	public void TC09() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(BackupAccount.USERNAME, BackupAccount.PASSWORD);
		homePage.openTab(tabName.CHANGEPASSWORD);
		changePasswordPage.changePassword(BackupAccount.PASSWORD, BackupAccount.NEW_PASSWORD, BackupAccount.NEW_PASSWORD);
		assertEquals(changePasswordPage.getMessageSuccess(), Constant.ChangePassword.SUCCESS);
		changePasswordPage.changePassword(BackupAccount.NEW_PASSWORD, BackupAccount.PASSWORD, BackupAccount.PASSWORD);
		homePage.logOut();
	}
}
