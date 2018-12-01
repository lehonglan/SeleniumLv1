package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.FormButton;
import Constant.Constant.ListType;
import Constant.Constant.ticketColumn;
import Constant.InfoTicket;

public class BookTicketPage extends GeneralPage{
	
	public void selectFromList (ListType listing, String item) {
	Select list = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']",listing.getValue()))));
	list.selectByVisibleText(item);
	}
	
	public void selectFromList (ListType listing, int number) {
	Select list = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']",listing.getValue()))));
	list.selectByIndex(number);
	}
	
	public String getCellContent(int row, ticketColumn column) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//tr[%s]/td[%s]",row,column.getValue()))).getText();
	}
	
	public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int amount) {
		selectFromList(ListType.DEPART_DATE, departDate);
		selectFromList(ListType.DEPART_FROM, departFrom);
		selectFromList(ListType.ARRIVE_AT, arriveAt);
		selectFromList(ListType.SEAT_TYPE, seatType);
		selectFromList(ListType.TICKET_AMOUNT, amount);		
		setTicketInfo(departDate, departFrom, arriveAt, seatType, amount);
		generalPage.clickFormActionButton(FormButton.BOOK_TICKET);
	}
	
	public String bookRandomDate () {
		LocalDate baseDate = LocalDate.now().plusDays(3);
		Integer maxRandomValue = 30;
		Integer randomDays = (int)(maxRandomValue*Math.random());
		LocalDate randomDate = baseDate.plusDays(randomDays);
		return DateTimeFormatter.ofPattern("dd-MMM-yy").format(randomDate);
	}
	
	public void setTicketInfo(String departDate, String departFrom, String arriveAt, String seatType, int amount) {
		InfoTicket info = new InfoTicket(departDate, departFrom, arriveAt, seatType, amount);
		info.setDepartDate(departDate);
		info.setDepartFrom(departFrom);
		info.setArriveAt(arriveAt);
		info.setSeatType(seatType);
		info.setAmount(amount);
	}
}
