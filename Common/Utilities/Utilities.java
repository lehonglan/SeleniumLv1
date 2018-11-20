package Utilities;

import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;

public class Utilities {

	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver","Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	public static void closeBrowser() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
}

