package Railway;

import Constant.Constant.FormBox;
import Constant.Constant.FormButton;

public class RegisterPage extends GeneralPage {

	public void register(String email, String password, String confirmpassword, String pidnumber) {
		getBox(FormBox.EMAIL).clear();
		getBox(FormBox.PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.PID).clear();
		getBox(FormBox.EMAIL).sendKeys(email);
		getBox(FormBox.PASSWORD).sendKeys(password);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(confirmpassword);
		getBox(FormBox.PID).sendKeys(pidnumber);
		clickFormActionButton(FormButton.REGISTER);
	}
}
