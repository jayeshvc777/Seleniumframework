package com.hubspot.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
        // gerneric util wrapping
	
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public void doClear(By locator) {
		driver.findElement(locator).clear();
	}
	
	public void doSendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
	}
}
