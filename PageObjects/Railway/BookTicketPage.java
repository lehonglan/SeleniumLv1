package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.FormButton;
import Constant.Constant.ListType;
import Constant.Constant.MyTicketColumn;
import Constant.Constant.TabName;
import Constant.InfoTicket;
import Utilities.RandomdropDownValue;

public class BookTicketPage extends GeneralPage {

	public void bookTickets(int tickets) {
		for (int i = 1; i <= tickets; i++) {
			RandomdropDownValue random = new RandomdropDownValue();
			InfoTicket infoTicket = new InfoTicket(bookRandomDate(), random.randomdValues(ListType.DEPART_FROM),
					random.randomdValues(ListType.ARRIVE_AT), "Soft bed with air conditioner", "1");
			bookTicket(infoTicket);
			bookTicketPage.openTab(TabName.BOOKTICKET);
		}
	}

	public void selectFromList(ListType listing, String item) {
		Select list = new Select(
				Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']", listing.getValue()))));
		list.selectByVisibleText(item);
	}

	public String getTextOfCurrentSelectedItem(ListType listing) {
		return Constant.WEBDRIVER
				.findElement(By
						.xpath(String.format("//select[@name='%s']//option[@selected='selected']", listing.getValue())))
				.getText();
	}

	public void clickCancelButton() {
		WebElement button = Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Cancel']"));
		button.click();
	}

	public void cancelTicket(String from, String to) {
		homePage.openTab(TabName.MYTICKET);
		Constant.WEBDRIVER.findElement(By.xpath(String.format(
				"//tr/td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//input[@value='Cancel']",
				from, to))).click();
		utilities.confirmPromt();
	}

	public boolean isTicketDisplayed(String from, String to) {
		try {
			WebElement x = Constant.WEBDRIVER.findElement(By.xpath(String.format(
					"//tr/td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//input[@value='Cancel']",
					from, to)));
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getCellContent(int row, MyTicketColumn column) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//tr[%s]/td[%s]", row, column.getValue())))
				.getText();
	}

	public void bookTicket(InfoTicket infoTicket) {
		selectFromList(ListType.DEPART_DATE, infoTicket.getDepartDate());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectFromList(ListType.DEPART_FROM, infoTicket.getDepartFrom());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
			homePage.openTab(TabName.MYTICKET);
			for (int i = 0; i < amount; i++) {
				clickCancelButton();
				utilities.confirmPromt();
			}
		} catch (NoSuchElementException e) {
		}
	}
}
