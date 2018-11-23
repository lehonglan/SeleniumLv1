package Utilities;

import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Constant.Constant;
import Constant.Constant.tabNameString;
import Railway.HomePage;

public class Utilities {

private static final HomePage homePage = new HomePage();

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static int randomNumber(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
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

	public static void assertCheckTextElement(String actual, String expected) {
		Assert.assertEquals(actual, expected,
				"\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
	}

}
