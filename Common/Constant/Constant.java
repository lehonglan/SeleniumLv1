package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static String RAILWAY_URL = "http://localhost:8888";
	public static String GUERRILLAMAI_URL = "https://www.guerrillamail.com/inbox";

	public static class InactiveAccount {
		public static String USERNAME = "lan.le+99@logigear.com";
		public static String PASSWORD = "12345678";
	}

	public static class ChangePassword {
		public static String SUCCESS = "Your password has been updated";
	}
	
	public static class BackupAccount {
		public static String USERNAME = "lan.le.test.01";
		public static String EMAIL = "lan.le.test.01@gmail.com";
		public static String PASSWORD = "Lehonglan8180";
		public static String NEW_PASSWORD = PASSWORD + "1";
	}

	public static class Login {
		// Input
		public static String USERNAME = "lan.le@logigear.com";
		public static String PASSWORD = "Boom02122015";
		public static String FAIL = "There was a problem with your login and/or errors exist in your form.";
		public static String FAIL4TIMES = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static String INACTIVE_ACCOUNT = "Invalid username or password. Please try again.";

		public static String welcomeMessage(String username) {
			return "Welcome " + username;
		}
	}

	public enum pageTitle {
		LOGIN("Login page"),
		CHANGEPASSWORD("Change password"),
		MYTICKET("Manage ticket");

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
		public static String PID = "0123456789";
		// Expected
		public static String SUCCESS = "Thank you for registering your account";
		public static String ERROR = "There're errors in the form. Please correct the errors and try again.";
	}

	public enum tabName {
		LOGIN("Login"), 
		LOGOUT("Log out"), 
		BOOKTICKET("Book ticket"), 
		MYTICKET("My ticket"),
		CHANGEPASSWORD("Change password"), 
		REGISTER("Register");

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
