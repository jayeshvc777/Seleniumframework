package com.hubspot.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	
	// page locators
	
	private By emailid = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	
	
	// page Actions
	
	public WebElement getEmailid(  ) {
		return getElement(emailid);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}
	
	public String getLoginPageTitle() {
		return getPagetitle("HubSpot Login");
	}
	
	public HomePage doLogin(String username, String pwd) {
		doSendKeys(emailid, username);
		doSendKeys(password, pwd);
		doClick(loginButton);
		
		
		return getInstance(HomePage.class);
	}
//	public HomePage doLogin(String username, String pwd) {
//		getElement(emailid).sendKeys(username);
//		getElement(password).sendKeys(pwd);
//		getElement(loginButton).click();
//		
//		return getInstance(HomePage.class);
//	}
	
	public void doLogin() {
		doSendKeys(emailid, "");
		doSendKeys(password, "");
		doClick(loginButton);				
	}
	
	public void doLogin(String username) {
		doSendKeys(emailid, username);
		doSendKeys(password, "");
		doClick(loginButton);				
	}
	
}
