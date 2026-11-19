package myntra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Carpet {
	
	@Test
	
	public void getCarpetBelowThousands() throws InterruptedException{
		
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@data-group='home']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Carpets'and@class='desktop-categoryLink']")).click();
		Thread.sleep(3000);
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='PRESTO']/following-sibling::div"));
		action.moveToElement(checkbox1);
		checkbox1.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Blue']/following-sibling::div")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='product-discountedPrice'][number(translate(normalize-space(.),'Rs. ','')) < 1000]"));
		System.out.println("Price of the carppet which are less then Rs1000 are");
		for(WebElement element:elements) {
			System.out.println(element.getText());
			
		}
		driver.quit();
	}

}
