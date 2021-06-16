package com.cognixia.training.MavenTestNGSelenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.Base;
import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

import java.io.IOException;

public class GoogleFromFile extends Base {

	@Test(dataProvider = "getDataFromExcel")
	public void test(String Searchstring, String Expectedstring) throws IOException

	{
		WebElement searchbox;
		openBrowser("Chrome");
		driver.navigate().to("https://google.com");
		searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys(Searchstring);
//		
		WebElement searchgooglebutton = driver.findElement(By.className("gNO89b"));
		searchgooglebutton.submit();
		String actual = driver.getTitle();
		if (actual.equals(Expectedstring)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
//			
//		
	}

//		
	// Taking test data from file
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		return ReadFromExcel.readExcelData("resourcesmv/datadriventestdata.xlsx");

	}

}
