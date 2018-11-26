package Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import Constant.Constant;
import Railway.HomePage;

public class Utilities {

	private static final HomePage homePage = new HomePage();
	private static final Faker fake = new Faker();

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static String generateMail() {
//		String t = String.valueOf(System.currentTimeMillis());
//		return String.format("username%s@logigear.com", t.substring(5,t.length()));		
		return (fake.name().name().toString().substring(0, 6).replaceAll(" ", "").toLowerCase() + fake.number().digits(4).toString()
				+ "@logigear.com");
	}

	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	public static boolean isTabDisplay(String tabname) {
		try {
			WebElement x = homePage.getTab(tabname);
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
