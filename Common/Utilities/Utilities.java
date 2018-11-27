package Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.javafaker.Faker;

import Constant.Constant;
import Constant.Constant.tabName;
import Railway.HomePage;

public class Utilities {

	private static final HomePage homePage = new HomePage();
	private static final Faker fake = new Faker();

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	public void openFirefox() {
		System.setProperty("webdriver.firefox.driver", "Chua co");
		Constant.WEBDRIVER = new FirefoxDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	public void openURLInBrowser(String url,String browser) {
		switch (browser)	{
		case "chrome":
			openChrome();
			Constant.WEBDRIVER.navigate().to(url);
			break;
		case "firefox":
			openFirefox();
			Constant.WEBDRIVER.navigate().to(url);
			break;
		default:
			openChrome();
			Constant.WEBDRIVER.navigate().to(url);
			break;
		}
	}

	public static String generateMail() {
//		String t = String.valueOf(System.currentTimeMillis());
//		return String.format("username%s@logigear.com", t.substring(5,t.length()));		
		return (fake.name().name().toString().substring(0, 6).replaceAll(" ", "").toLowerCase() + fake.number().digits(4).toString()
				+ "@logigear.com");
	}
	
	public void activeAccount() {
		openURLInBrowser(Constant.MAILINATOR_URL, "chrome");
		//dang lam
	}

	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	public static boolean isTabDisplay(tabName name) {
		try {
			WebElement x = homePage.getTab(name.getValue());
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
