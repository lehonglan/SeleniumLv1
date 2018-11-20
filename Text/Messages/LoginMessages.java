package Messages;

import Constant.Constant;

public class LoginMessages {
	public static final String TITLE = "Login page";
	public static final String SUCCESS = "Welcome " + Constant.USERNAME;
	public static final String FAIL = "There was a problem with your login and/or errors exist in your form.";
	public static final String FAIL4TIMES = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
}