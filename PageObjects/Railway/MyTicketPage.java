package Railway;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.ListType;

public class MyTicketPage {
	
	public String getErrorMessage() {
		return Constant.WEBDRIVER.findElement(By.xpath("//div[contains(@class,'error')]")).getText();
	}
	
	public void applyFilter(ListType listing,String item) {
		selectFromList(listing,item);
		Constant.WEBDRIVER.findElement(By.xpath(String.format("//input[@value='Apply filter']"))).click();
	}
	
	public void selectFromList(ListType listing, String item) {
		Select list = new Select(
				Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']", listing.getValue()))));
		list.selectByVisibleText(item);
	}

	public String getDepartStationFirstTicket() {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//table[@class='MyTable']//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)]"))).getText();
	}
	
	public String getTextOfCurrentSelectedItem(ListType listing) {
		return Constant.WEBDRIVER
				.findElement(By
						.xpath(String.format("//select[@name='%s']//option[@selected='selected']", listing.getValue())))
				.getText();
	}
	
	public boolean isFilteredTicketsDisplay(ListType listing) {
		List<WebElement> expectedTickets = Constant.WEBDRIVER.findElements(By.xpath(String.format("//table[@class='MyTable']//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)][normalize-space()='%s']",getTextOfCurrentSelectedItem(listing))));
		List<WebElement> unExpectedTicket = Constant.WEBDRIVER.findElements(By.xpath(String.format("//table[@class='MyTable']//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)][normalize-space()!='%s']",getTextOfCurrentSelectedItem(listing))));
		int expected = expectedTickets.size();
		int unexpected = unExpectedTicket.size();
		if (expected >= 1 && unexpected == 0) {
			return true;
		} else {
			return false;
		}
	}

}
