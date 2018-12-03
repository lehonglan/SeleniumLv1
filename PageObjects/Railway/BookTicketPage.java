package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.FormButton;
import Constant.Constant.ListType;
import Constant.Constant.myTicketColumn;
import Constant.Constant.tabName;
import Constant.InfoTicket;

public class BookTicketPage extends GeneralPage {

	public void selectFromList(ListType listing, String item) {
		Select list = new Select(
				Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']", listing.getValue()))));
		list.selectByVisibleText(item);
	}
	
	public String getTextOfCurrentSelectedItem(ListType listing) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']", listing.getValue()))).getText();
	}

	public void clickCancelButton() {
		WebElement button = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Cancel']"));
		button.click();
	}

	public String getCellContent(int row, myTicketColumn column) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//tr[%s]/td[%s]", row, column.getValue())))
				.getText();
	}

//	public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int amount) {
//		selectFromList(ListType.DEPART_DATE, departDate);
//		selectFromList(ListType.DEPART_FROM, departFrom);
//		selectFromList(ListType.ARRIVE_AT, arriveAt);
//		selectFromList(ListType.SEAT_TYPE, seatType);
//		selectFromList(ListType.TICKET_AMOUNT, amount);
//		generalPage.clickFormActionButton(FormButton.BOOK_TICKET);
//	}

	public void bookTicket(InfoTicket infoTicket) {
		selectFromList(ListType.DEPART_DATE, infoTicket.getDepartDate());
		selectFromList(ListType.DEPART_FROM, infoTicket.getDepartFrom());
		selectFromList(ListType.ARRIVE_AT, infoTicket.getArriveAt());
		selectFromList(ListType.SEAT_TYPE, infoTicket.getSeatType());
		selectFromList(ListType.TICKET_AMOUNT, infoTicket.getAmount());
		generalPage.clickFormActionButton(FormButton.BOOK_TICKET);
	}
	public String bookRandomDate() {
		LocalDate baseDate = LocalDate.now().plusDays(3);
		Integer maxRandomValue = 27;
		Integer randomDays = (int) (maxRandomValue * Math.random());
		LocalDate randomDate = baseDate.plusDays(randomDays);
		return DateTimeFormatter.ofPattern("M/d/yyyy").format(randomDate);
	}

	public void cleanMyTickets(int amount) {
		try {
			homePage.openTab(tabName.MYTICKET);
			for (int i = 0; i < amount; i++) {
				clickCancelButton();
				utilities.confirmPromt();
			}
		} catch (NoSuchElementException e) {
		}
	}
	
}
