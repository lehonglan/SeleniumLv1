package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.ListType;
import Constant.Constant.ticketColumn;

public class BookTicketPage extends GeneralPage{
	
	public void selectFromList (ListType listing, String item) {
	Select list = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']/option",listing.getValue()))));
	list.selectByVisibleText(item);
	}
	
	public void selectFromListByIndex (ListType listing, int index) {
		Select list = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']",listing))));
		list.selectByIndex(index);
		}
	
	public void selectFirstItemInList (ListType listing) {
		Select item = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']/option",listing.getValue()))));
		item.getFirstSelectedOption();
		}
	
	public String getTextFirstItemInList (ListType listing) {
		Select item = new Select(Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']/option",listing.getValue()))));
		return item.getFirstSelectedOption().getText();
		}
	
	public String selectCell(int row, ticketColumn column) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//tr[%s]/td[%s]",row,column.getValue()))).getText();
	}
}
