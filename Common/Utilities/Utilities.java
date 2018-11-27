package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import Constant.Constant;
import Constant.Constant.tabName;
import Railway.HomePage;
import Railway.RegisterPage;

public class Utilities {

	private static RegisterPage registerPage = new RegisterPage();
	private static HomePage homePage = new HomePage();
	private static Faker fake = new Faker();

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

	public String generateMail(String domain) {
//		String t = String.valueOf(System.currentTimeMillis());
//		return String.format("username%s@logigear.com", t.substring(5,t.length()));		
		return (fake.name().name().toString().substring(0, 6).replaceAll(" ", "").toLowerCase() + fake.number().digits(6).toString()
				+ domain);
	}
	
	public void waitForElement(WebElement element){
	     WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	        }
	
	public void activeAccount(String email) {
		homePage.openTab(tabName.REGISTER);
		registerPage.register(email, Constant.Register.PASSWORD, Constant.Register.PASSWORD,
				Constant.Register.PID);
		Constant.WEBDRIVER.navigate().to(Constant.MAILINATOR_URL);
//		openURLInBrowser(Constant.MAILINATOR_URL, "chrome");
		WebElement inputField = Constant.WEBDRIVER.findElement(By.id("inbox_field"));
		inputField.clear();
		inputField.sendKeys(email);
		WebElement searchBtn = Constant.WEBDRIVER.findElement(By.xpath("//span[@class='input-group-btn']"));
		searchBtn.click();
//		waitForElement(Constant.WEBDRIVER.findElement(By.xpath("//td[contains(text(),'Please confirm your account')]")));
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(By.xpath("//td[contains(text(),'Please confirm your account')]")).click();
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement activateLink = Constant.WEBDRIVER.findElement(By.xpath("//a[contains(@href,'confirmationCode')]"));
		activateLink.click();
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
