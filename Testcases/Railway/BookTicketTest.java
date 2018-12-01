package Railway;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.BookTicket;
import Constant.Constant.tabName;

public class BookTicketTest extends TestBase {

	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC14() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.BOOKTICKET);
		bookTicketPage.bookTicket(bookTicketPage.bookRandomDate(), "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", 1);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), BookTicket.SUCCESS_MESSAGE);
		softAssertion.assertEquals(actual, expected);
	}
}
