package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "https://1c5fcd6f.ngrok.io";
	public static final String USERNAME = "lan.le@logigear.com";
	public static final String PASSWORD = "Boom02122015";
	public static final String WRONG_PASS = "            ";
	public static final String WRONG_NAME = "111111111111";
	public static final String REGISTER_NAME = "lan.le+7@logigear.com";
	public static final String REGISTER_PASS = "12345678";
	public static final String REGISTER_PID = "0123456789";

	public class ChangePassword {
		public static final String TITLE = "Change password";
		public static final String TABNAME = "Change password";
	}

	public class Login {
		public static final String TITLE = "Login page";
		public static final String SUCCESS = "Welcome " + Constant.USERNAME;
		public static final String FAIL = "There was a problem with your login and/or errors exist in your form.";
		public static final String FAIL4TIMES = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	}

	public class Logout {
		public static final String TABNAME = "Logout";
	}

	public class MyTicket {
		public static final String TITLE = "Manage ticket";
		public static final String TABNAME = "My ticket";
	}

	public class Register{
		public static final String TITLE = "Thank you for registering your account";
	}

	public enum tabNameString {
		tabLogin("Login"),
		tabLogout("Logout"),
		tabBookTicket("Book ticket"),
		tabMyTicket("My ticket"),
		tabChangePassword("Change password"),
		tabRegister("Register");

		 private String value;
		 public String getValue() {
		    return value;
		   }
		 private tabNameString(String value) {
		  this.value = value;
		 } 
	}
}
