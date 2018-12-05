package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static String USERNAME_WITHOUT_DOMAIN = "lan.le.test.01";
	public static String USERNAME = "lan.le.test.01@gmail.com";
	public static String USERNAME_BACKUP = "lan.le.test.01+1@gmail.com";
	public static String USERNAME_BACKUP_2 = "lan.le.test.01+2@gmail.com";
	public static String USERNAME_INACTIVE = "lan.le+99@logigear.com";
	public static String PASSWORD = "12345678";
	public static String NEW_PASSWORD = PASSWORD + "1";
	public static String EMPTY = "";

	public static WebDriver WEBDRIVER;
	public static String RAILWAY_URL = /*"http://localhost:8888";*/ "http://192.168.189.206:8888";
	
	public enum FormButton {
		BOOK_TICKET("Book ticket"),
		REGISTER("Register"), 
		LOGIN("login"), 
		CHANGE_PASSWORD("Change Password"),
		RESET_PASSWORD("Reset Password"),
		SEND_INSTRUCTIONS("Send Instructions");

		private String value;

		public String getValue() {
			return value;
		}

		private FormButton(String value) {
			this.value = value;
		}
	}
	
	public enum TimeOut {
		DEFAULT(5),
		LONG(20);

		private int value;

		public int getValue() {
			return value;
		}

		private TimeOut(int value) {
			this.value = value;
		}
	}
	
	public enum ListType {
		DEPART_DATE("Date"),
		DEPART_FROM("DepartStation"),
		ARRIVE_AT("ArriveStation"),
		SEAT_TYPE("SeatType"),
		TICKET_AMOUNT("TicketAmount");

		private String value;

		public String getValue() {
			return value;
		}

		private ListType(String value) {
			this.value = value;
		}
	}
	
	public enum FormBox {
		USERNAME("username"),
		EMAIL("email"),
		PASSWORD("password"),
		CURRENT_PASSWORD("currentPassword"),
		NEW_PASSWORD("newPassword"),
		CONFIRM_PASSWORD("confirmPassword"),
		RESET_TOKEN("resetToken"),
		PID("pid");

		private String value;

		public String getValue() {
			return value;
		}

		private FormBox(String value) {
			this.value = value;
		}
	}

	public static class ChangePassword {
		public static String SUCCESS_MESSAGE = "Your password has been updated";
	}
	
	public static class ResetPassword {
		public static String DIFFERENT_PASSWORD_ERROR_FORM_MESSAGE = "Could not reset password. Please correct the errors and try again.";
		public static String DIFFERENT_PASSWORD_ERROR_BOX_MESSAGE = "The password confirmation did not match the new password.";
		public static String INVALID_TOKEN_ERROR_FORM_MESSAGE = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
		public static String INVALID_TOKEN_ERROR_BOX_MESSAGE = "The password reset token is invalid.";
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

	public enum PageHeader{
		LOGIN("Login page"), 
		CHANGEPASSWORD("Change password"), 
		MYTICKET("Manage ticket"),
		BOOKTICKET("Book ticket");

		private String value;

		public String getValue() {
			return value;
		}

		private PageHeader(String value) {
			this.value = value;
		}
	}

	public static class Register {
		public static String SUCCESS_MESSAGE = "Thank you for registering your account";
		public static String ERROR_FORM_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
		public static String ERROR_PASSWORD_MESSAGE = "Invalid password length.";
		public static String ERROR_PID_MESSAGE = "Invalid ID length.";
	}
	
	public static class BookTicket {
		public static String SUCCESS_MESSAGE = "Ticket booked successfully!";
	}
	
	public enum MyTicketColumn {
		DEPART_STATION("1"), 
		ARRIVE_STATION("2"), 
		SEAT_TYPE("3"), 
		DEPART_DATE("4"),
		AMOUNT("7"); 

		private String value;

		public String getValue() {
			return value;
		}

		private MyTicketColumn(String value) {
			this.value = value;
		}
	}
	
	public enum TimeTableLink {
		CHECK_PRICE("check price"),
		BOOK_TICKET("book ticket");

		private String value;

		public String getValue() {
			return value;
		}

		private TimeTableLink(String value) {
			this.value = value;
		}
	}

	public enum TabName {
		LOGIN("Login"), 
		LOGOUT("Log out"), 
		BOOKTICKET("Book ticket"), 
		MYTICKET("My ticket"),
		CHANGEPASSWORD("Change password"), 
		REGISTER("Register"),
		TIMETABLE("Timetable");

		private String value;

		public String getValue() {
			return value;
		}

		private TabName(String value) {
			this.value = value;
		}
	}

	public static class ReturnFailMessage {

		public static String tabIsNotShown(TabName element) {
			return (element + " is not shown as expected");
		}

	}
}
