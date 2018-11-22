package Utilities;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Railway.GeneralPage;

public class Utilities {

	private static final SoftAssert softAssertion = new SoftAssert();

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static int randomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(1000);
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

	public static boolean isTabDisplay(String tabname) {
		try {
			return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", tabname)))
					.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void assertCheckTextElement(String actual, String expected) {
		Assert.assertEquals(actual, expected,
				"\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
	}

	public static void softAssertCheckTextElement(String actual, String expected) {
		softAssertion.assertEquals(actual, expected,
				"\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
		softAssertion.assertAll();
	}

}
