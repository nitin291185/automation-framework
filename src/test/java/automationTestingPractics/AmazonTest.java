package automationTestingPractics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonTest {
	
	@Test
	
	public void amazon() {
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[text()='EN']/.."));
		action.moveToElement(ele);
		
		WebElement elem = driver.findElement(By.xpath("(//span[text()='ML'])[1]/.."));
		

		elem.click();
	}

}
