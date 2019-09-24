package com.hubspot.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	
	// page locators
	
	By emailid = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	
	// page Actions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void doLogin(String username, String pwd) {
		doSendKeys(emailid, username);
		doSendKeys(password, pwd);
		doClick(loginButton);
	}
	
}
