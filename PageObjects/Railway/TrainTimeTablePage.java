package Railway;

import org.openqa.selenium.By;

import Constant.Constant;
import Constant.Constant.TimeTableLink;

public class TrainTimeTablePage extends GeneralPage{
	
	public void selectLink(String from, String to, TimeTableLink link) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format("//tr/td[contains(text(),'%s')]/following-sibling::td//a[contains(text(),'%s')]",
						from,to,link.getValue())));
	}
}
