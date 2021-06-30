package com.cognixia.training.MavenTestNGSelenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cognixia.training.MavenTestNGSelenium.common.Base;

public class DragandDrop extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		openBrowser("Chrome");
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.switchTo().frame(2);
		
		WebElement imagedrag= driver.findElement(By.xpath("(//ul[@id='gallery']//img)[1]"));
		
		WebElement trash = driver.findElement(By.id("trash"));
		
		new Actions(driver).dragAndDrop(imagedrag, trash).build().perform();

	}

}
