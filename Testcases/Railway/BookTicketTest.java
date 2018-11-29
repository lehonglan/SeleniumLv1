package Railway;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.BookTicket;
import Constant.Constant.FormButton;
import Constant.Constant.ListType;
import Constant.Constant.tabName;
import Constant.Constant.ticketColumn;

public class BookTicketTest extends TestBase {

	@Test(description = "Errors display if password and confirm password don't match when resetting password")
	public void TC14() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.BOOKTICKET);
		bookTicketPage.selectFirstItemInList(ListType.DEPART_DATE);
		bookTicketPage.selectFromList(ListType.DEPART_FROM, "Sài Gòn");
		bookTicketPage.selectFromList(ListType.ARRIVE_AT, "Nha Trang");
		bookTicketPage.selectFromList(ListType.SEAT_TYPE, "Soft bed with air conditioner");
		bookTicketPage.selectFromList(ListType.TICKET_AMOUNT, "1");
		generalPage.clickFormActionButton(FormButton.BOOK_TICKET);
		softAssertion.assertEquals(generalPage.getCurrentPageTitle(), BookTicket.SUCCESS_MESSAGE);
		softAssertion.assertEquals(bookTicketPage.selectCell(2, ticketColumn.DEPART_DATE),
				bookTicketPage.getTextFirstItemInList(ListType.DEPART_DATE));
		softAssertion.assertEquals(bookTicketPage.selectCell(2, ticketColumn.DEPART_STATION),"Sài Gòn");
		softAssertion.assertEquals(bookTicketPage.selectCell(2, ticketColumn.ARRIVE_STATION),"Nha Trang");
		softAssertion.assertEquals(bookTicketPage.selectCell(2, ticketColumn.SEAT_TYPE),"Soft bed with air conditioner");
		softAssertion.assertEquals(bookTicketPage.selectCell(2, ticketColumn.AMOUNT),"1");
	}
}
