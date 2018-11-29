package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.ChangePassword;
import Constant.Constant.FormBox;
import Constant.Constant.FormButton;
import Constant.Constant.tabName;
import Utilities.Utilities;

public class ChangePasswordTest extends TestBase{
	
	@BeforeClass
	public void beforeClass() {
		utilities.connectToMail();
		utilities.openURLInBrowser(Constant.RAILWAY_URL, "chrome");
		utilities.resetPasswordToDefault(Constant.USERNAME_BACKUP);
	}
	
	@AfterClass
	public void afterClass() {
		utilities.resetPasswordToDefault(Constant.USERNAME_BACKUP);
		Utilities.closeBrowser();

	}
	
	@Test(description = "User can change password")
	public void TC09() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.CHANGEPASSWORD);
		changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		softAssertion.assertEquals(changePasswordPage.getMessageSuccess(), ChangePassword.SUCCESS_MESSAGE);
		
		homePage.logOut();
		softAssertion.assertAll();
	}
	
	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		homePage.openTab(tabName.LOGIN);
		loginPage.openForgotPasswordLink();
		loginPage.inputEmail(Constant.USERNAME_BACKUP);
		changePasswordPage.clickFormActionButton(FormButton.SEND_INSTRUCTIONS);
		utilities.navigateToURLFromMail("Please reset your password");
		/*Check if "Password Change Form" page displays*/
		softAssertion.assertTrue(changePasswordPage.isFormTitleDisplay());
		
		changePasswordPage.inputNewPassword(Constant.NEW_PASSWORD, "");
		changePasswordPage.clearToken();
		generalPage.clickFormActionButton(FormButton.RESET_PASSWORD);
		/*Check if Error message displays above the form.*/
		softAssertion.assertEquals(changePasswordPage.getMessageError(), ChangePassword.INVALID_TOKEN_ERROR_FORM_MESSAGE);
		
		/*Check if Error message displays next to the "Password Reset Token" field.*/
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheBox(Constant.FormBox.RESET_TOKEN), ChangePassword.INVALID_TOKEN_ERROR_BOX_MESSAGE);
		
		softAssertion.assertAll();
	}
	
	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		homePage.openTab(tabName.LOGIN);
		loginPage.openForgotPasswordLink();
		loginPage.inputEmail(Constant.USERNAME_BACKUP);
		generalPage.clickFormActionButton(FormButton.SEND_INSTRUCTIONS);
		utilities.navigateToURLFromMail("Please reset your password");
		/*Check if "Password Change Form" page displays*/
		softAssertion.assertTrue(changePasswordPage.isFormTitleDisplay());
		
		changePasswordPage.inputNewPassword(Constant.NEW_PASSWORD, "");
		generalPage.clickFormActionButton(FormButton.RESET_PASSWORD);
		/*Check if Error message displays above the form.*/
		softAssertion.assertEquals(changePasswordPage.getMessageError(), ChangePassword.DIFFERENT_PASSWORD_ERROR_FORM_MESSAGE);
		
		/*Check if Error message displays next to the  confirm password field.*/
		softAssertion.assertEquals(generalPage.getMessageErrorNextTheBox(FormBox.CONFIRM_PASSWORD), ChangePassword.DIFFERENT_PASSWORD_ERROR_BOX_MESSAGE);
		
		softAssertion.assertAll();
	}
}
