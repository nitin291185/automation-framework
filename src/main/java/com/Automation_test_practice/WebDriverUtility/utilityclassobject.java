package com.Automation_test_practice.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class utilityclassobject {
	public static ThreadLocal<ExtentTest> test =new ThreadLocal<ExtentTest>();

	public static ExtentReports reports;

	   public static ThreadLocal<WebDriver>  driver= new ThreadLocal<WebDriver>();

	   

	   public static ExtentTest gettest()

	   {

		   return test.get();

	   }

	   public static void setTest(ExtentTest actTest)

	   {

		   test.set(actTest);

	   }

	   public static void setDriver(WebDriver actDriver)

	   {

		   driver.set(actDriver);

	   }

	   public static WebDriver getDriver() {

		   return driver.get();

	   }
}
