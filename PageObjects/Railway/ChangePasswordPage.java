package Railway;

import Constant.Constant.FormBox;
import Constant.Constant.FormButton;

public class ChangePasswordPage extends GeneralPage{
	
	public void changePassword(String currentpass, String newpass, String confirmpass) {
		getBox(FormBox.CURRENT_PASSWORD).clear();
		getBox(FormBox.NEW_PASSWORD).clear();
		getBox(FormBox.CONFIRM_PASSWORD).clear();
		getBox(FormBox.CURRENT_PASSWORD).sendKeys(currentpass);
		getBox(FormBox.NEW_PASSWORD).sendKeys(newpass);
		getBox(FormBox.CONFIRM_PASSWORD).sendKeys(confirmpass);
		clickFormActionButton(FormButton.CHANGE_PASSWORD);
	}

}