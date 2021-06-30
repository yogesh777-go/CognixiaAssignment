package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognixia.training.MavenTestNGSelenium.common.Base;


public class RediffAssign extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        openBrowser("Chrome");
		
		driver.get("https://register.rediff.com/register/register.php");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Name Field
				driver.findElement(By.xpath("//*[starts-with(@name, 'name')]")).sendKeys("Ameya");
				
				//Password Field
				driver.findElement(By.xpath("//*[starts-with(@name,'passwd')]")).sendKeys("mypassword");
				
				WebElement day_select = driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Day')]"));
				Select day = new Select(day_select);
				day.selectByVisibleText("05");
				
				new Select(driver.findElement(By.xpath("//*[starts-with(@name,'DOB_Day')]"))).selectByVisibleText("12");
				new Select(driver.findElement(By.xpath("//*[starts-with(@name,'DOB_Month')]"))).selectByVisibleText("APR");
				new Select(driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Year')]"))).selectByValue("1999");
				
				//new Select(driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Day')]"))).selectByVisibleText("05");
				
				//DAY - Using XPath
				//driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Day')]/option[text()='05']")).click();
				
				Select month = new Select(driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Month')]")));
				month.selectByIndex(4); //April
				
				//MONTH - Using Xpath
				//driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Month')]/option[text()='FEB']")).click();
				
				//YEAR
				driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Year')]/option[text()='1998']")).click();
				
				//Country
				new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
				
				//Format of Select Statement
				//new Select(<Element>).selectByVisibleText(<Text to be selected>)
				
				//CITY
				driver.findElement(By.xpath("//*[starts-with(@name, 'city')]/option[text()='Pune']")).click();
				
				//GENDER
				driver.findElement(By.xpath("//*[starts-with(@name, 'gender') and @value='m']")).click();
				
				WebElement altemail = driver.findElement(By.xpath("//*[starts-with(@name, 'altemail')]"));
				
				//CheckBox
				WebElement checkbox = driver.findElement(By.xpath("//*[starts-with(@name, 'chk_altemail')]"));
				if(!checkbox.isSelected()) {
					checkbox.click();
				} else {
					System.out.println("Checkbox already selected");
				}
				
				//Verify that the altemail field disappears
				if(!altemail.isDisplayed()) {
					System.out.println("Alt Email Disappeared");
				}
				
				//Click on Button
				driver.findElement(By.id("Register")).click();
				
				String expected = "ID cannot be blank";
				
				//Javascript popups - There is no HTML code
				
				Alert myalert = driver.switchTo().alert();
				
				String actual = myalert.getText(); //Get the text from the Alert
				
				System.out.println("Text on Alert box is: \n"+actual);
				
				if(actual.contains(expected)) {
					System.out.println("Test Passed");
					myalert.accept(); //OK button
					//myalert.dismiss(); //Cancel
					//myalert.sendKeys("Some text"); //If alert has a text box
				} else {
					System.out.println("Test Failed");
				}
				
		
	}

}
