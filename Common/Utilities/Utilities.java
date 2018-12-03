package Utilities;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import Constant.Constant.ListType;
import Constant.Constant.TabName;
import Constant.Constant.TimeOut;
import Railway.HomePage;

public class Utilities {

	private static HomePage homePage = new HomePage();
	private static EmailUtils emailUtils;

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public void openURLInBrowser(String url, String browser) {
		switch (browser) {
		case "chrome":
			openChrome();
			Constant.WEBDRIVER.navigate().to(url);
			break;
		default:
			openChrome();
			Constant.WEBDRIVER.navigate().to(url);
			break;
		}
	}

	public String generateMail() {
		String t = String.valueOf(System.currentTimeMillis());	
		return (Constant.USERNAME_WITHOUT_DOMAIN + "+" + t.substring(5, t.length())) + "@gmail.com";
	}

	public void connectToMail() {
		try {
			emailUtils = new EmailUtils("lan.le.test.01@gmail.com", "Lehonglan8180", "smtp.gmail.com",
					EmailUtils.EmailFolder.INBOX);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openValidateLink(String mailsubject) {
		connectToMail();
		try {
			Message email = emailUtils.getMessagesBySubject(mailsubject, true, 1)[0];
			String content = emailUtils.getMessageContent(email);
			String link = extractUrls(content).get(0);

			Constant.WEBDRIVER.get(link);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	public static boolean isTabDisplay(TabName name) {
		try {
			WebElement x = homePage.getTab(name.getValue());
			return x.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void selectRandomItemFromList (ListType listing) {
		List<WebElement> list = Constant.WEBDRIVER.findElements(By.xpath(String.format("//select[@name='%s']/option",listing)));
		Random r = new Random();
		int randomValue = r.nextInt(list.size());
		list.get(randomValue).click();
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
	
	public void confirmPromt() {
	    try {
	        Constant.WEBDRIVER.switchTo().alert().accept();
	    } catch (NoAlertPresentException e) {
	    }
	}
	
	public Writer convertUTF8 (Writer text) {
		return text = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public void waitForElementDisplays(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,TimeOut.DEFAULT.getValue());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (NoSuchElementException e) {
		}
	}
}
