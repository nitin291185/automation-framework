package com.flexbus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flexBusPrice {
	
	@Test
	
	public void getPriceOfBuses() throws InterruptedException {
		
	
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.flixbus.in/");
	
	Thread.sleep(3000);
	
	 SearchContext shadowhost = driver.findElement(By.id("usercentrics-root")).getShadowRoot();
	shadowhost.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']")).click();
	
	 driver.findElement(By.xpath("//input[@placeholder='Delhi']")).click();
	 WebElement ele = driver.findElement(By.xpath("//div[@class='mBw5g' and text()='Hyderabad']"));

	 ele.click();
	 
	 driver.findElement(By.xpath("//input[@placeholder='Rishikesh']")).sendKeys("Benguluru");
//	 WebElement ele1 = driver.findElement(By.xpath("//div[@class='mBw5g' and text()='Benguluru']"));
//	 ele1.click();

driver.findElement(By.id("dateInput-from")).click();
driver.findElement(By.xpath("//button[@aria-label='Wed, 8 Jul']"));
driver.findElement(By.xpath("//button[text()='Search']")).click();

	
	
	
	}
}
