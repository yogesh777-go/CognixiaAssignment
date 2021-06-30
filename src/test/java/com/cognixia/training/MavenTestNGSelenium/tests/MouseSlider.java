package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cognixia.training.MavenTestNGSelenium.common.Base;
public class MouseSlider extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		openBrowser("Chrome");
		driver.get("https://jqueryui.com/slider/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//1.create the object of actions class
		
		driver.switchTo().frame(0);
		//pointer(driver) changes to frame area
		
		WebElement Slider =driver.findElement(By.id("slider"));
		
		int maxXoffset =Slider.getSize().width;
		System.out.println(maxXoffset);
		
		WebElement handle = Slider.findElement(By.tagName("span"));
		
		Actions myaction =new Actions(driver);
		myaction.dragAndDropBy(handle, maxXoffset/2,0).build().perform();
	
		
	}
	

}
