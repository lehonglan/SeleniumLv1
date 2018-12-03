package Railway;

import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.BookTicket;
import Constant.Constant.ListType;
import Constant.Constant.TimeTableLink;
import Constant.Constant.myTicketColumn;
import Constant.Constant.pageHeader;
import Constant.Constant.tabName;
import Constant.InfoTicket;

public class BookTicketTest extends TestBase {

	InfoTicket infoTicket = new InfoTicket(bookTicketPage.bookRandomDate(), "Sài Gòn", "Nha Trang",
			"Soft bed with air conditioner", "1");

	@Test(description = "User can book 1 ticket at a time")
	public void TC14() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.BOOKTICKET);
		bookTicketPage.bookTicket(infoTicket);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), BookTicket.SUCCESS_MESSAGE);
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, myTicketColumn.DEPART_DATE),
				infoTicket.getDepartDate());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, myTicketColumn.DEPART_STATION),
				infoTicket.getDepartFrom());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, myTicketColumn.ARRIVE_STATION),
				infoTicket.getArriveAt());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, myTicketColumn.SEAT_TYPE),
				infoTicket.getSeatType());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, myTicketColumn.AMOUNT), infoTicket.getAmount());
		bookTicketPage.cleanMyTickets(1);
		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
	public void TC15() {
		homePage.openTab(tabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(tabName.TIMETABLE);
		trainTimeTablePage.selectLink("Sài Gòn", "Huế", TimeTableLink.BOOK_TICKET);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), pageHeader.BOOKTICKET.getValue());
		softAssertion.assertEquals(bookTicketPage.getTextOfCurrentSelectedItem(ListType.DEPART_FROM), "Sài Gòn");
		softAssertion.assertEquals(bookTicketPage.getTextOfCurrentSelectedItem(ListType.ARRIVE_AT), "Huế");
		softAssertion.assertAll();
	}
}
