package com.cognixia.training.MavenTestNGSelenium.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	static WebDriver driver;

	public static void setProperties()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Tools\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Selenium\\geckodriver");
	}
	
	public static void openBrowser(String browser)
	{
		setProperties();
		if(browser.equalsIgnoreCase("Chrome"))
		{
		 driver = new ChromeDriver(); 
	}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
		  driver = new FirefoxDriver(); 
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
