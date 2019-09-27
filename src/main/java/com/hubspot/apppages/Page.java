package com.hubspot.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriver driver;
	WebDriverWait wait;
	// page class constructor

	public Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	// Create a method with Java Generics and return a new page
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver,
					this.wait);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public abstract void doClick(By locator);
	
	public abstract void doClear(By locator);
	
	public abstract void doSendKeys(By locator, String text);
	
	public abstract String doGetText(By locator);
	
	public abstract String getPagetitle(String text);
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void  waitforElementPresent(By locator);
	
	public abstract void waitforPageTitle(String text);
	
	
	
	

}
