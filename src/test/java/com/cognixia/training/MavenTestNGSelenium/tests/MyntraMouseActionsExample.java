package com.cognixia.training.MavenTestNGSelenium.tests;

	import org.openqa.selenium.By;
	import org.openqa.selenium.interactions.Actions;

import com.cognixia.training.MavenTestNGSelenium.common.Base;


	public class MyntraMouseActionsExample extends Base {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	openBrowser("Firefox");
	driver.get("https://www.myntra.com/");
	//move the mouse to home and living menu item\

	//1.create the object of actions class

	Actions myActions = new Actions(driver);
	myActions.moveToElement(driver.findElement(By.xpath("//a[text()='Home & Living' and @class = 'desktop-main']")));
	myActions.pause(5000);
	myActions.moveToElement(driver.findElement(By.xpath("//a[text()='Men' and @class = 'desktop-main']")));


	//2.  Create the object of Action class and build the actions
	org.openqa.selenium.interactions.Action myAction = myActions.build();

	//3. perform the action
	myAction.perform();
		}

	}
