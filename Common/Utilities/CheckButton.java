package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import Constant.Constant;

public class CheckButton {
	public static boolean isButtonDisplay(String tabname) {
		try {
			return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[text()='%s']", tabname))).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
