package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Constant.Constant.BookTicket;
import Constant.Constant.ListType;
import Constant.Constant.MyTicketColumn;
import Constant.Constant.PageHeader;
import Constant.Constant.TabName;
import Constant.Constant.TimeTableLink;
import Constant.InfoTicket;

public class BookTicketTest extends TestBase {

	InfoTicket infoTicket = new InfoTicket(bookTicketPage.bookRandomDate(), "Sài Gòn", "Nha Trang",
			"Soft bed with air conditioner", "1");

	@Test(description = "User can book 1 ticket at a time")
	public void TC14() {
		SoftAssert softAssertion = new SoftAssert();
		
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.BOOKTICKET);
		bookTicketPage.bookTicket(infoTicket);
		softAssertion.assertEquals(generalPage.getCurrentHeader(), BookTicket.SUCCESS_MESSAGE);
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, MyTicketColumn.DEPART_DATE),
				infoTicket.getDepartDate());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, MyTicketColumn.DEPART_STATION),
				infoTicket.getDepartFrom());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, MyTicketColumn.ARRIVE_STATION),
				infoTicket.getArriveAt());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, MyTicketColumn.SEAT_TYPE),
				infoTicket.getSeatType());
		softAssertion.assertEquals(bookTicketPage.getCellContent(2, MyTicketColumn.AMOUNT), infoTicket.getAmount());
		bookTicketPage.cleanMyTickets(1);
		homePage.logOut();
		softAssertion.assertAll();
	}

	@Test(description = "User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
	public void TC15() {
		SoftAssert softAssertion = new SoftAssert();
		
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.TIMETABLE);
		trainTimeTablePage.selectLink("Sài Gòn", "Huế", TimeTableLink.BOOK_TICKET);
		softAssertion.assertEquals(bookTicketPage.getCurrentHeader(), PageHeader.BOOKTICKET.getValue());
		softAssertion.assertEquals(bookTicketPage.getTextOfCurrentSelectedItem(ListType.DEPART_FROM), "Sài Gòn");
		softAssertion.assertEquals(bookTicketPage.getTextOfCurrentSelectedItem(ListType.ARRIVE_AT), "Huế");
		homePage.logOut();
		softAssertion.assertAll();
	}
}
