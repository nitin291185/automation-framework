package cricbuzz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ratingTest {
	
	@Test
	public void testRatingTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.cricbuzz.com");
		
		
	}


}