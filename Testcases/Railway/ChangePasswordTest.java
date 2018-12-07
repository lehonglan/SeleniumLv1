package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Constant.Constant.ChangePassword;
import Constant.Constant.FormBox;
import Constant.Constant.ResetPassword;
import Constant.Constant.TabName;
import Utilities.EmailUtils;

public class ChangePasswordTest extends TestBase {

	@Test(description = "User can change password")
	public void TC09() {
		SoftAssert softAssertion = new SoftAssert();
		
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.CHANGEPASSWORD);
		changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		softAssertion.assertEquals(changePasswordPage.getSuccessMessage(), ChangePassword.SUCCESS_MESSAGE);
		homePage.logOut();
		
		loginPage.resetPasswordToDefault(Constant.USERNAME_BACKUP);
		
		softAssertion.assertAll();
	}

	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		SoftAssert softAssertion = new SoftAssert();
		
		loginPage.sendMailResetPassword(Constant.USERNAME_BACKUP);
		EmailUtils.openValidateLink("Please reset your password");
		softAssertion.assertTrue(loginPage.isFormTitleDisplay());

		loginPage.resetPassword(Constant.NEW_PASSWORD, Constant.EMPTY, Constant.EMPTY);
		softAssertion.assertEquals(changePasswordPage.getErrorMessage(),
				ResetPassword.INVALID_TOKEN_ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(changePasswordPage.getMessageErrorNextTheBox(Constant.FormBox.RESET_TOKEN),
				ResetPassword.INVALID_TOKEN_ERROR_BOX_MESSAGE);
		
		softAssertion.assertAll();
	}

	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		SoftAssert softAssertion = new SoftAssert();
		
		loginPage.sendMailResetPassword(Constant.USERNAME_BACKUP);
		EmailUtils.openValidateLink("Please reset your password");

		loginPage.resetPassword(Constant.NEW_PASSWORD, Constant.EMPTY);
		softAssertion.assertEquals(changePasswordPage.getErrorMessage(),
				ResetPassword.DIFFERENT_PASSWORD_ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheBox(FormBox.CONFIRM_PASSWORD),
				ResetPassword.DIFFERENT_PASSWORD_ERROR_BOX_MESSAGE);
		
		softAssertion.assertAll();
	}
}
