package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.ChangePassword;
import Constant.Constant.FormBox;
import Constant.Constant.ResetPassword;
import Constant.Constant.TabName;
import Utilities.Utilities;

public class ChangePasswordTest extends TestBase {

	@BeforeClass
	public void beforeClass() {
		utilities.openURLInBrowser(Constant.RAILWAY_URL, "chrome");
		homePage.openTab(TabName.LOGIN);
	}

	@AfterClass
	public void afterClass() {
		Utilities.closeBrowser();

	}

	@Test(description = "User can change password")
	public void TC09() {
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.CHANGEPASSWORD);
		changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		softAssertion.assertEquals(changePasswordPage.getMessageSuccess(), ChangePassword.SUCCESS_MESSAGE);
		homePage.logOut();
		
		loginPage.resetPasswordToDefault(Constant.USERNAME_BACKUP);
		
		softAssertion.assertAll();
	}

	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		loginPage.sendMailResetPassword(Constant.USERNAME_BACKUP);
		utilities.openValidateLink("Please reset your password");
		softAssertion.assertTrue(loginPage.isFormTitleDisplay());

		loginPage.resetPassword(Constant.NEW_PASSWORD, Constant.EMPTY, Constant.EMPTY);
		softAssertion.assertEquals(loginPage.getResetPasswordErrorMessage(),
				ResetPassword.INVALID_TOKEN_ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheBox(Constant.FormBox.RESET_TOKEN),
				ResetPassword.INVALID_TOKEN_ERROR_BOX_MESSAGE);
		
		loginPage.resetPasswordToDefault(Constant.USERNAME_BACKUP);
		
		softAssertion.assertAll();
	}

	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		loginPage.sendMailResetPassword(Constant.USERNAME_BACKUP);
		utilities.openValidateLink("Please reset your password");
		softAssertion.assertTrue(loginPage.isFormTitleDisplay());

		loginPage.resetPassword(Constant.NEW_PASSWORD, Constant.EMPTY);
		softAssertion.assertEquals(loginPage.getResetPasswordErrorMessage(),
				ResetPassword.DIFFERENT_PASSWORD_ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheBox(FormBox.CONFIRM_PASSWORD),
				ResetPassword.DIFFERENT_PASSWORD_ERROR_BOX_MESSAGE);

		loginPage.resetPasswordToDefault(Constant.USERNAME_BACKUP);
		
		softAssertion.assertAll();
	}
}
