package com.cognixia.training.MavenTestNGSelenium.tests;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.cognixia.training.MavenTestNGSelenium.common.Base;
public class MultipleView  extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		openBrowser("Chrome");
		
		driver.get("https://register.rediff.com/register/register.php");
String mainwindowhandle = driver.getWindowHandle();
		
		driver.findElement(By.linkText("privacy policy")).click();
		//still, driver is pointing to main window
		
		driver.findElement(By.linkText("terms and conditions")).click();
		//still, driver is pointing to main window
		
		//Switch the control to New Window
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println("No. of windows open: "+handles.size());
		
		Iterator<String> iter = handles.iterator();
		
		while(iter.hasNext()) {
			String handle = iter.next();
			
			driver.switchTo().window(handle);
			
			if(driver.getTitle().contains("Terms and Conditions")) {
				break;
			}
		}
		
		//driver is pointing to terms and conditions window
		
		String header = driver.findElement(By.xpath("//div[@class='header']/div")).getText();
		
		String expected = "Terms and Conditions";
		
		if(header.equals(expected)) {
			System.out.println("I am happy!");
		} else {
			System.out.println("I am not happy!");
		}
		
		
		//before this line, driver is pointing to terms and conditions window
		
		//If I want to point driver to privacy window
		handles = driver.getWindowHandles();
		iter = handles.iterator();
		while(iter.hasNext()) {
			String handle = iter.next();
			
			driver.switchTo().window(handle);
			
			if(driver.getTitle().contains("Welcome")) {
				break;
			}
		}
		
		//Now driver is pointing to privacy window
		driver.close(); //this will close the privacy window only
		//driver.quit(); //this will close all open windows
		
		driver.switchTo().window(mainwindowhandle);
		//now it is pointing to main window
		
		
	}

}
//div[@class='_3Ay6Sb _31Dcoz'] discount
//div[@class='_30jeq3 _16Jk6d'] price
//div[@class='_3I9_wc _2p6lqe'] actual