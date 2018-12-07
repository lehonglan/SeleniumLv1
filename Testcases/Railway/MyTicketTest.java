package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.Constant.ListType;
import Constant.Constant.MyTicket;
import Constant.Constant.TabName;

public class MyTicketTest extends TestBase{
	
	MyTicketPage myTicketPage = new MyTicketPage();
	
	@Test(description = "User can filter 'Manager ticket' table with Depart Station")
	public void FTTC01() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.BOOKTICKET);
		bookTicketPage.bookTickets(7);
		bookTicketPage.openTab(TabName.MYTICKET);
		myTicketPage.applyFilter(ListType.FILTER_DEPART_STATION,myTicketPage.getDepartStationFirstTicket());
		
		Assert.assertTrue(myTicketPage.isFilteredTicketsDisplay(ListType.FILTER_DEPART_STATION));
		
		bookTicketPage.cleanMyTickets(7);
		homePage.logOut();
	}
	
	@Test(description = "User can filter 'Manager ticket' table with Depart Station")
	public void FTTC02() {
		homePage.openTab(TabName.LOGIN);
		loginPage.login(Constant.USERNAME_BACKUP, Constant.PASSWORD);
		homePage.openTab(TabName.BOOKTICKET);
		bookTicketPage.bookTickets(7);
		bookTicketPage.openTab(TabName.MYTICKET);
		myTicketPage.applyFilter(ListType.FILTER_STATUS,"Paid");
		
		Assert.assertEquals(myTicketPage.getErrorMessage(), MyTicket.FILTER_ERROR_MESSAGE);
		
		bookTicketPage.cleanMyTickets(7);
		homePage.logOut();
	}

}
