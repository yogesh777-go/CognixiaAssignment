package com.cognixia.training.MavenTestNGSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cognixia.training.MavenTestNGSelenium.common.Base;

public class Screenshot extends Base {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		openBrowser("Chrome");
		driver.get("http://www.cleartrip.com");
		
		File f;
		f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File("D:\\python course\\CollaberaTraining\\SeleniumTraining\\Screenshot\\cleartripfirst.png"));
	}

}
