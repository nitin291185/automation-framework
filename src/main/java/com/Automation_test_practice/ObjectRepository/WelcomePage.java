package com.Automation_test_practice.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class WelcomePage {
	
	
	@FindBy(id="name")
	private WebElement nameTextField;
	
	@FindBy(id="email")
	private WebElement emailIdTextField;
	
	@FindBy(id="phone")
	private WebElement phoneNotextField;
	
	public WebElement getAlertButton() {
		return alertButton;
	}


	public List<WebElement> getList() {
		return list;
	}


	public WebElement getConfirmButton() {
		return confirmButton;
	}
@FindBy(xpath="//h2[text()='Pagination Web Table']/following-sibling::div[@class='widget-content']")
private List<WebElement> list;

	@FindBy(id="textarea")
	private WebElement adddresstField;
	
	@FindBy(id="alertBtn")
	private WebElement alertButton;
	
	@FindBy(id="confirmBtn")
	private WebElement confirmButton;
	
	
	public WelcomePage(WebDriver driver) {
		
		
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getNameTextField() {
		return nameTextField;
	}


	public WebElement getEmailIdTextField() {
		return emailIdTextField;
	}


	public WebElement getPhoneNotextField() {
		return phoneNotextField;
	}


	public WebElement getAdddresstField() {
		return adddresstField;
	}
	
	

}
