package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Constant.Constant.ListType;

public class RandomdropDownValue {

	public String randomdValues(ListType listing) {
		List<WebElement> se = new Select(
				Constant.WEBDRIVER.findElement(By.xpath(String.format("//select[@name='%s']", listing.getValue()))))
						.getOptions();
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < se.size(); i++) {
			String dvalues = se.get(i).getText();
			al.add(dvalues);
		}

		Random foo = new Random();
		int randomNumber = foo.nextInt(al.size() - 0) + 0;

		return al.get(randomNumber);
	}
}
