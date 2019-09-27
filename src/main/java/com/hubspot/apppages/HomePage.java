package com.hubspot.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub		
	}
	
	private By welcomeHeader = By.xpath("//*[contains(text(),'Great job')]");
		
	// methods
	 
	public WebElement getwelcomeHeader() {
		return getElement(welcomeHeader);
	}
	
	public String getwelcomePageHeader() {
		return getPageHeader(welcomeHeader);
	}
	
}
