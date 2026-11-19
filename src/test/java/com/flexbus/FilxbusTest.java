package com.flexbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FilxbusTest {
	@Test
	
	public void searchBus() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flixbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement shadowhost = driver.findElement(By.xpath("//div[@id='usercentrics-root']"));
		SearchContext shadowElement = shadowhost.getShadowRoot();
		shadowElement.findElement(By.cssSelector("button[data-testid='uc-deny-all-button']")).click();
		driver.findElement(By.xpath("//input[@id='searchInput-from']")).sendKeys("Bengaluru");
		Thread.sleep(Duration.ofSeconds(4));
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(Duration.ofSeconds(4));
	    driver.findElement(By.xpath("//input[@id='searchInput-to']")).sendKeys("Pune");
	    Thread.sleep(Duration.ofSeconds(4));
	    action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='dateInput-from']")).click();
		Thread.sleep(Duration.ofSeconds(4));
	    driver.findElement(By.xpath("//button[@aria-label='Sat, 10 Sep']")).click();
		driver.findElement(By.xpath("//input[@id='productSummary']")).click();
	driver.findElement(By.xpath("//button[@id='lastPlus' and @aria-label='Add Adults']")).click();
	driver.findElement(By.xpath("//button[text()='Search']")).click();
	Thread.sleep(Duration.ofSeconds(5));
	List<WebElement> prices = driver.findElements(By.xpath("//div[@class=\"SearchResult__rowRideAndPrice___u0TJA\"]/descendant::span[@data-e2e=\"search-result-prices\"]"));
	for(WebElement price:prices) {
	System.out.println(price.getText());	
	}
	Thread.sleep(Duration.ofSeconds(5));
		driver.quit();	
		
	}

}


