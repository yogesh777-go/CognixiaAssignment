package com.cognixia.training.MavenTestNGSelenium.tests;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment2_Slider extends UtilityClass {
	// Taking finalprice as global variable
	   protected double finalcalculatedprice;
	
	   
	// Opening flipkart , entering fitbit and sliding the handle
	    @Test
	    public void testA() throws IOException
	    {	
	     driver.get("https://www.flipkart.com");
		WebElement pop = driver.findElement(By.xpath("//div[@class = '_2QfC02']/button[contains(text(),x)]"));
     pop.click();
		WebElement searchbox = driver.findElement(By.className("_3704LK"));
		searchbox.sendKeys("fitbit");
		searchbox.sendKeys(Keys.ENTER);
		handlingslider(3, 3);
	    }
	
	 //  Checking if results are more than 900
	    @Test
		 public void testB()
		 {
		WebElement pricerange = driver.findElement(By.className("_10Ermr"));
		WebDriverWait myWait = new WebDriverWait(driver,30);
		myWait.until(ExpectedConditions.textToBePresentInElement(pricerange, pricerange.getText()));
		String str = pricerange.getText().trim();
		String arr[] = str.split(" ");
		String testData = arr[5];

		if (Integer.parseInt(testData) > 900)
		{
			System.out.println("Test Passed , there are more than 900 products\n");
		} 
		else
		{
			System.out.println();
			System.out.println("Test Failed,   there are less than 900 products\n");
		}
	 }
		
	// Taking Screenshot of first product page	
	   @Test
	   public void testC() throws IOException
	   {
		WebElement link = driver.findElement(By.xpath("//a[@class='s1Q9rs']"));
		link.click();
		UtilityClass.takeScreenshot();
	   }
	   
		
	// Capturing all prices and checking if the discount amount is correct by 
	   //calling calculatefinalprice() function from utility class
		@Test
		public void  testD()
		{
		WebElement originalprice = driver.findElement(By.xpath("//div[@class = '_25b18c']/div[2]"));
		String original = originalprice.getText();
		original = original.substring(1).replace(",", "");
		System.out.println("Original Price : " + original);
		
		
		WebElement availableprice = driver.findElement(By.xpath("//div[@class='_25b18c']/div"));
		String price = availableprice.getText();
		price = price.substring(1).replace(",", "");
		System.out.println("Available Price : " + price);
		
		
		WebElement discountper = driver.findElement(By.xpath("//div[@class = '_25b18c']/div[3]"));
		String discount = discountper.getText();
		System.out.println("Discount : " + discount);
		
		double discountedprice = calculatefinalprice(discount , original, price);
		finalcalculatedprice = discountedprice;
		}


		//  Clicking on Add To Cart
		
		@Test
		public void testE()
		{
	    Set<String> handles = driver.getWindowHandles();
		int count = 0;
		for(String handle : handles)
		{
	 		 count ++;
		     if(count == 2)
		     {
				driver.switchTo().window(handle);
				break;
		     }
	    
		}	
		driver.findElement(By.xpath("//div[@class  = '_1p3MFP dTTu2M']/ul/li/button")).click();
		String handle2 = driver.getWindowHandle();
		driver.switchTo().window(handle2);
		}

  // Comparing final price with calculated amount 
		
		@Test
		public void testF()
		{
	    String finalprice = driver.findElement(By.xpath("//div[@class ='Ob17DV _3X7Jj1']/span")).getText();
	    finalprice = finalprice.substring(1).replace(",", "");
	    compareFinalpriceAccuracy(finalprice ,  finalcalculatedprice);
	    
	}		
	
}



