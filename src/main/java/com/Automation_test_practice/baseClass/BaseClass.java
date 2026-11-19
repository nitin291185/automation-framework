package com.Automation_test_practice.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Automation_test_practice.ObjectRepository.WelcomePage;
import com.Automation_test_practice.WebDriverUtility.JavaUtility;
import com.Automation_test_practice.WebDriverUtility.WebDriverUtility;
import com.Automation_test_practice.genericUtility.ExcelUtility;
import com.Automation_test_practice.genericUtility.FileUtility;
import com.Automation_test_practice.listenerutility.threadLocalClass;

public class BaseClass {
	public FileUtility flib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	protected WelcomePage wp;
	public static WebDriver driver = null;

	@BeforeSuite
	public void BeforeSuite() {

	}

	@AfterSuite
	public void AfterSuite() {

	}

	//@Parameters("browser")
	@BeforeTest
	public void ConfigureBrowser(@Optional("chrome") String browser,ITestContext context) throws Throwable {

		if (browser == null || browser.isEmpty()) {
			browser = flib.getDataFromPropertyFile("browser");
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
			
			
		}
		
		
		wlib.Maximize(driver);
		
		

		wp = new WelcomePage(driver);

		
	}

	@AfterTest
	public void AfterClass() {

		driver.quit();
	}



	@BeforeMethod
	
	
	public void BeforeMethod() throws Throwable {

		
		String url = System.getProperty("url", flib.getDataFromPropertyFile("url"));
		
		driver.get(url);
		wlib.waitForPageToLoad(driver);
		
		


		

	}

	@AfterMethod
	
	
	
	public void AfterMethod() {
		
		
	
		

	}
	
}
