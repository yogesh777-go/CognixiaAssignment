package com.cognixia.training.MavenTestNGSelenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
	
	@Test
	
	public void testFirst() {
		
		System.out.println("Inside test first");
	}

	@BeforeTest
	public void setUp() {
		System.out.println("Inside setUp");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Inside tearDown");
	}
	@Test
	public void testSecond() {
		System.out.println("Inside testSecond");
	}
}
