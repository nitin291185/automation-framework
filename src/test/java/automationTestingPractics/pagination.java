package com.Automation_test_practice.baseClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class pagination {
	

@Test
public void searchRouterInPagination() {
WebDriver driver=new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    for (int i = 1; ; i++) {

        // Get all rows from the current page
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='productTable']/tbody/tr"));

        boolean routerFound = false;

        for (WebElement row : rows) {

            // Get product name
            String productName = row.findElement(
                    By.xpath("./td[2]")).getText();

            if (productName.equalsIgnoreCase("Router")) {

                // Get product price
                String price = row.findElement(
                        By.xpath("./td[3]")).getText();

                System.out.println("Product Found: " + productName);
                System.out.println("Product Price: " + price);

                // Click the corresponding checkbox
                WebElement checkbox = row.findElement(
                        By.xpath(".//input[@type='checkbox']"));

                if (!checkbox.isSelected()) {
                    checkbox.click();
                }

                routerFound = true;
                break;
            }
        }

        // Stop execution if Router is found
        if (routerFound) {
            System.out.println("Router found on page: " + i);
            break;
        }

        // Find the Next pagination button
        List<WebElement> nextButtons = driver.findElements(
                By.xpath("//ul[@id='pagination']//a[text()='Next']"));

        if (nextButtons.isEmpty() || !nextButtons.get(0).isEnabled()) {
            System.out.println("Router not found. No more pages.");
            break;
        }

        // Navigate to next page
        nextButtons.get(0).click();

        // Wait for the next page's table to load
        wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
    }
}


}
