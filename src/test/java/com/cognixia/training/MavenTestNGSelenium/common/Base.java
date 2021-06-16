package com.cognixia.training.MavenTestNGSelenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;

	static void setProperties() {
	       System.setProperty("webdriver.chrome.driver","C:\\Tools\\Selenium\\chromedriver.exe");
	       // valid for mc and linux os
	       //System.setProperty("webdriver.chrome.driver", "/Users/ameya/Tools/Selenium/ChromeDriver91/chromedriver");
	       System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Selenium\\geckodriver");
	}
	
protected static void openBrowser(String browser) {
		
		setProperties();
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
	}
}
