package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import Constant.Constant;
import Constant.Constant.BackupAccount;
import Constant.Constant.tabName;
import Railway.HomePage;

public class Utilities {

	private static HomePage homePage = new HomePage();
	private static Faker fake = new Faker();
	private static EmailUtils emailUtils;

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	// chua co driver for firefox
	public void openFirefox() {
		System.setProperty("webdriver.firefox.driver", "abc");
		Constant.WEBDRIVER = new FirefoxDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public void openURLInBrowser(String url, String browser) {
		switch (browser) {
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

	public String generateMail(String domain) {
//		String t = String.valueOf(System.currentTimeMillis());
//		return String.format("username%s@logigear.com", t.substring(5,t.length()));		
		return (BackupAccount.USERNAME + "+"
				+ fake.name().name().toString().substring(0, 4).replaceAll(" ", "").toLowerCase()
				+ fake.number().digits(3).toString() + domain);
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void connectToMail() {
		try {
			emailUtils = new EmailUtils(BackupAccount.USERNAME, BackupAccount.PASSWORD, "smtp.gmail.com",
					EmailUtils.EmailFolder.INBOX);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToURLFromMail() {
		try {
			Message email = emailUtils.getMessagesBySubject("Please confirm your account", true, 1)[0];
			String content = emailUtils.getMessageContent(email);
			String link = extractUrls(content).get(0);

			Constant.WEBDRIVER.get(link);

			// TODO: continue testing
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * Returns a list with all links contained in the input
	 */
	public static List<String> extractUrls(String text) {
		List<String> containedUrls = new ArrayList<String>();
		String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
		Matcher urlMatcher = pattern.matcher(text);

		while (urlMatcher.find()) {
			containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
		}

		return containedUrls;
	}
}
