package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognixia.training.MavenTestNGSelenium.common.Base;

public class TestGoogleSuggestions extends Base {
	
	public static void main(String[] args) throws InterruptedException {

		openBrowser("Chrome");
		
		driver.get("http://www.google.com");
		
		String searchstring = "selenium";
		
		driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys(searchstring);
	
		WebElement e = driver.findElement(By.xpath("//li[@data-view-type='1']//div[@role='option']"));
		
		//Explicit Wait
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.textToBePresentInElement(e, searchstring));
		
		
		List<WebElement> suggestionslist = driver.findElements(By.xpath("//li[@data-view-type='1']//div[@role='option']"));
		
		System.out.println(suggestionslist.size());
		
		for (WebElement suggestion : suggestionslist) {
			
			System.out.print(suggestion.getText());
			
			if(suggestion.getText().contains("selenium")) {
				System.out.println(": Test Passed");
			}
			else {
				System.out.println(": Test Failed");
			}
		}
		
	}


}
