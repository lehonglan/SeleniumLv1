package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "http://192.168.189.206:8888";

	public class InactiveAccount {
		public static final String USERNAME = "lan.le+99@logigear.com";
		public static final String PASSWORD = "12345678";
	}
	
	public class ChangePassword {
		public static final String TITLE = "Change password";
		public static final String SUCCESS = "Your password has been updated";
	}

	public class Login {
		//Input
		public static final String USERNAME = "lan.le@logigear.com";
		public static final String PASSWORD = "Boom02122015";
		//Expected
		public static final String TITLE = "Login page";
		public static final String SUCCESS = "Welcome " + USERNAME;
		public static final String FAIL = "There was a problem with your login and/or errors exist in your form.";
		public static final String FAIL4TIMES = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static final String INACTIVE_ACCOUNT = "Invalid username or password. Please try again.";
	}

	public class MyTicket {
		public static final String TITLE = "Manage ticket";
	}

	public class Register{
		//Input
		public static final String PASSWORD = "12345678";
		public static final String PID = "0123456789";
		//Expected
		public static final String SUCCESS = "Thank you for registering your account";
		public static final String ERROR = "There're errors in the form. Please correct the errors and try again.";
	}

	public enum tabNameString {
		tabLogin("Login"),
		tabLogout("Log out"),
		tabBookTicket("Book ticket"),
		tabMyTicket("My ticket"),
		tabChangePassword("Change password"),
		tabRegister("Register");

		 private String value;
		 public String getText() {
		    return value;
		 }
		 private tabNameString(String value) {
		  this.value = value;
		 } 
	}
	
	public static class returnFailMessage{
		
		public static String ElementIsNotShown (String element)	{
			return (element + " is not shown as expected");
		}
		
		public static String CompareText (String actual, String expected) {
			return ("\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
		}
	}
}
