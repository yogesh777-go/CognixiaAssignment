	package com.cognixia.training.MavenTestNGSelenium.tests;

	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import com.cognixia.training.MavenTestNGSelenium.common.Base;

	public class FlipkartTeamBAssign extends Base
	{
		
		public static void main(String args[]) throws IOException
		{
			openBrowser("Chrome");
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Tool\\Selenium\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("https://flipkart.com");
			
			WebElement element = driver.findElement(By.className("_2QfC02"));
			
			WebElement child = element.findElement(By.tagName("button"));
			child.click();
			
			WebElement results = driver.findElement(By.className("_3704LK"));
		     results.sendKeys("fitbit");
		     results.sendKeys(Keys.ENTER);
		       
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     
		       WebElement ele = driver.findElement(By.className("_10Ermr"));
		       
		       //Checking if results are more than  900
		     
		       String  str = ele.getText().trim();
		     
		       System.out.println(str);
		       String arr[] = str.split(" ");
		       String testData = arr[5];
		      
		       if(Integer.parseInt(testData)>900)
		       {
		    	  
		    	   System.out.println("Test Passed");
		       }
		       else
		       { System.out.println();
		    	   System.out.println("Test Failed");
		       }
		       
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     WebElement link  =  driver.findElement(By.xpath("//a[@class='s1Q9rs' and contains(@title, 'Versa Special Edition')]"));
		     link.click();
		       
		     
		     // Taking ScreenShot
		     File f;
		       
		        f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		       
		        FileUtils.copyFile(f, new File("D:\\python course\\CollaberaTraining\\SeleniumTraining\\Screenshot\\imagefitbit.png"));
		        
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        
		      WebElement availableprice = driver.findElement(By.xpath("//div[@class='_25b18c']/div"));
		     
		      String price = availableprice.getText();
		      System.out.println("Available Price : "+ price);
		      
		      
		      WebElement originalprice = driver.findElement(By.className("_3I9_wc _2p6lqe"));
		      String original = originalprice.getText();
		      System.out.println("Actual Price : "+ original);
		      
//		      WebElement discountedprice = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/span[1]"));
//		      String discount = discountedprice.getText();
//		      System.out.println("Discounted Price : "+ discount);
//		       
		}

	}
