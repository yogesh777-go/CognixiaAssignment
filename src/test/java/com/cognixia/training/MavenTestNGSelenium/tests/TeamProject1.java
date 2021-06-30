package com.cognixia.training.MavenTestNGSelenium.tests;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamProject1 extends DataClass {

	@BeforeTest
	public void beforeTest() {
		openSite();
		signIn();
	}

	@Test
	public void mainTest() throws IOException {
		// Search product
		searchProduct();

		// clicking dropdown
		clickDropdown();

		// Hovering on first product
		hoverOver();

		// Printing Intial pricenof first product
		checkInitialPrice();

		// Capturing screenshots of corresponding images of first product
		captureImages();

		// Capturing and Comparing add to cart price and total final price
		checkTotalPrice();

		// navigating to summary, sign-In, Address, Shipping, Payment
		checkOut();

		// capturing reference ID of the selected product
		findReference();
	}

	@AfterTest
	public void tearDown() {
		signOut();
		driver.close();
		driver.quit();
	}
}
