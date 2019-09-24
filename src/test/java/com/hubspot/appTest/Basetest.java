package com.hubspot.appTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hubspot.apppages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	
	@BeforeMethod
	public void setup() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver,15);
		 driver.get("https://app.hubspot.com/login");
		 driver.manage().window().fullscreen();
		 // create  the object of page class  : Instantiate page class
		 page = new Page(driver, wait);		 		 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
