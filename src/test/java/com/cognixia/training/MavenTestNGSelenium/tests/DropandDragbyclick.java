package com.cognixia.training.MavenTestNGSelenium.tests;

import com.cognixia.training.MavenTestNGSelenium.common.Base;

public class DropandDragbyclick extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		openBrowser("Chrome");
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(2);

	}

}
