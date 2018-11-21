package Utilities;

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
		}
		catch (Exception e) {
		}
	}
	
//	public static WebElement fluentWait(final By locator) {
//	    Wait<WebDriver> wait = new FluentWait<WebDriver>(Constant.WEBDRIVER)
//	            .withTimeout(30, TimeUnit.SECONDS)
//	            .pollingEvery(5, TimeUnit.SECONDS)
//	            .ignoring(NoSuchElementException.class);
//
//	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//	        public WebElement apply(WebDriver driver) {
//	            return driver.findElement(locator);
//	        }
//	    });
//
//	    return  foo;
//	}

}
