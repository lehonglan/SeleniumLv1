package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.ChangePassword;
import Constant.Constant.tabName;

public class ChangePasswordTest extends TestBase{
	
	@Test(description = "User can change password")
	public void TC09() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.CHANGEPASSWORD);
		changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		assertEquals(changePasswordPage.getMessageSuccess(), Constant.ChangePassword.SUCCESS_MESSAGE);
		changePasswordPage.changePassword(Constant.NEW_PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
		homePage.logOut();
	}
	
	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		homePage.openTab(tabName.LOGIN);
		loginPage.openForgotPasswordLink();
		loginPage.inputEmail(Constant.USERNAME_BACKUP);
		utilities.navigateToURLFromMail();
		softAssertion.assertTrue(changePasswordPage.isFormTitleDisplay());
		changePasswordPage.resetPassword(Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, "");
		generalPage.clickFormActionButton();
		softAssertion.assertEquals(changePasswordPage.getMessageError(), ChangePassword.INVALID_TOKEN_ERROR_FORM_MESSAGE);
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheInputField(Constant.errorForField.RESET_TOKEN), ChangePassword.ERROR_RESET_TOKEN_MESSAGE);
		homePage.logOut();
		softAssertion.assertAll();
	}
}
