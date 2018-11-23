package Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import Railway.HomePage;

public class Utilities {

private static final HomePage homePage = new HomePage();

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static String generateMail() {
		String t = String.valueOf(System.currentTimeMillis());
		return String.format("username%s@logigiear.com", t.substring(5,t.length()));
	}

	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	public static boolean isTabDisplay(String tabname) {
		try {
			return homePage.getTab(tabname).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
