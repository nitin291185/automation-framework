package automationTestingPractics;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Automation_test_practice.ObjectRepository.WelcomePage;
import com.Automation_test_practice.WebDriverUtility.WebDriverUtility;
import com.Automation_test_practice.baseClass.BaseClass;
import com.Automation_test_practice.genericUtility.ExcelUtility;

public class E2ESerarioTest extends BaseClass{
	
	WelcomePage ep=new WelcomePage(driver);
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	String data;
	
	@Test(priority=1)
	
	public void enterTextTest() throws Throwable {
		String data="data";
		wp.getNameTextField().sendKeys(elib.getDataFromExcelAsString(data, 0, 0));
		wp.getEmailIdTextField().sendKeys(elib.getDataFromExcelAsString(data, 1, 0));
		wp.getPhoneNotextField().sendKeys(elib.getDataFromExcelAsString(data, 2, 0));
		wp.getAdddresstField().sendKeys(elib.getDataFromExcelAsString(data, 3, 0));
		System.out.println("Scenario 1 passed");
		
		
		
		
	}
	
	@Test(priority=2)
	
	public void simpleAlert() {
		wp.getAlertButton().click();
		wlib.switchToAlertAndAccept(driver);
		System.out.println("Alert handeled");
		System.out.println("Scenario 2 passed");
		
	}
	
	@Test(priority=3)
	public void confirmentionAlert() {
		wp.getConfirmButton().click();
		wlib.switchToAlertAndCancel(driver);
		System.out.println("Alert handeled");
		System.out.println("Scenario 3 passed");
	}
	
	@Test(priority=4)
	public void pagination() {
		
		for(int i=2;;i++) {
			List<WebElement> elements = wp.getList();
			for(WebElement eles:elements) {
				System.out.println(eles.getText());
				if(eles.getText().equals("Television")) {
					break;
				}
		}
		
		}
		
	}

}
