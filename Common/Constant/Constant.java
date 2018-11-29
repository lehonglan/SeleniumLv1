package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static String USERNAME_WITHOUT_DOMAIN = "lan.le.test.01";
	public static String USERNAME = "lan.le.test.01@gmail.com";
	public static String USERNAME_BACKUP = "lan.le.test.01+1@gmail.com";
	public static String USERNAME_INACTIVE = "lan.le+99@logigear.com";
	public static String PASSWORD = "12345678";
	public static String NEW_PASSWORD = PASSWORD + "1";

	public static WebDriver WEBDRIVER;
	public static String RAILWAY_URL = "http://192.168.189.206:8888";
	
	public enum errorForField {
		PASSWORD("password"),
		NEW_PASSWORD("newPassword"),
		CONFIRM_PASSWORD("confirmPassword"),
		RESET_TOKEN("resetToken"),
		PID("pid");

		private String value;

		public String getValue() {
			return value;
		}

		private errorForField(String value) {
			this.value = value;
		}
	}

	public static class ChangePassword {
		public static String SUCCESS_MESSAGE = "Your password has been updated";
		public static String INVALID_TOKEN_ERROR_FORM_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
		public static String ERROR_RESET_TOKEN_MESSAGE = "The password reset token is invalid.";
	}

	public static class Login {
		// Input
		public static String ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
		public static String ERROR_4TIMES_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static String INACTIVE_ACCOUNT_MESSAGE = "Invalid username or password. Please try again.";

		public static String welcomeMessage(String username) {
			return "Welcome " + username;
		}
	}

	public enum pageTitle {
		LOGIN("Login page"), CHANGEPASSWORD("Change password"), MYTICKET("Manage ticket");

		private String value;

		public String getValue() {
			return value;
		}

		private pageTitle(String value) {
			this.value = value;
		}
	}

	public static class Register {
		// Input
		public static String PASSWORD = "12345678";
		public static String NEW_PASSWORD = PASSWORD + "1";
		public static String PID = "0123456789";
		// Expected
		public static String SUCCESS_MESSAGE = "Thank you for registering your account";
		public static String ERROR_FORM_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
		public static String ERROR_PASSWORD_MESSAGE = "Invalid password length.";
		public static String ERROR_PID_MESSAGE = "Invalid ID length.";

	}

	public enum tabName {
		LOGIN("Login"), LOGOUT("Log out"), BOOKTICKET("Book ticket"), MYTICKET("My ticket"),
		CHANGEPASSWORD("Change password"), REGISTER("Register");

		private String value;

		public String getValue() {
			return value;
		}

		private tabName(String value) {
			this.value = value;
		}
	}

	public static class ReturnFailMessage {

		public static String tabIsNotShown(tabName element) {
			return (element + " is not shown as expected");
		}

//		public static String CompareText (String actual, String expected) {
//			return ("\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
//		}
	}
}
