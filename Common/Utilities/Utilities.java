package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import Railway.GeneralPage;

public class Utilities {

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	public static void logOut() {
		try {
			GeneralPage.getTab("Log out").click();
		} catch (Exception e) {
		}
	}

	public static boolean isButtonDisplay(String tabname) {
		try {
			return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[text()='%s']", tabname)))
					.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
