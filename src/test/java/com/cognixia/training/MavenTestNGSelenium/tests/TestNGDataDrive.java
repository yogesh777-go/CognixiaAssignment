package com.cognixia.training.MavenTestNGSelenium.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

public class TestNGDataDrive {
	

	@Test ( dataProvider ="getData")
	public void myTest(String firstname, String lastname, String city) {
	  System.out.print(firstname);
	  System.out.print(" ");
	  System.out.println(lastname);
	  System.out.print(" ");
	  System.out.println(city);
	
	  
}

@DataProvider
public Object[][] getDataFromExcel() throws IOException {
	return ReadFromExcel.readExcelData("resources/testdata.xlsx"); 
}

@DataProvider					// A data provider in TestNG needs to return a 2 dimensional Object Array
public Object[][] getData() {
								// Within this method we can hardcode data or read it from an external file if we want
	String [][] names=new String[5][3];
	//Row 1
	names [0][0] ="Yogesh";
	names [0][1] = "Goswami";
	names [0][2] ="lpur";
	
	//Row 2
	names [1][0] ="rohit";
	names [1][1] = "gosi";
	names [1][2] ="jaba";
	
	//Row 3
	names [2][0] ="mohit";
	names [2][1] = "Gos";
	names [2][2] ="pur";
		
	//Row 4
	names [3][0] ="mahesh";
	names [3][1] = "Go";
	names [3][2] ="jabal";
	
	//Row 5
	names [4][0] ="nipp";
	names [4][1] = "Gosw";
	names [4][2] ="jabalpur";
	return names;
  }
} 
