package com.hubspot.appTest;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.hubspot.apppages.BasePage;
import com.hubspot.apppages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setup(String browser) {
		
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("ff")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Browser is not defined in Xml file");
			}
			wait = new WebDriverWait(driver, 15);
			driver.get("https://app.hubspot.com/login");
			driver.manage().window().fullscreen();
			// create the object of basepage class : cannot instantiate page class because
			// page class is abstract so create instance of BasePage class
			page = new BasePage(driver, wait);
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

	/*
	 * hubspot username/email : jayeshvc777@gmail.com password : Jayesh@007 URL :
	 * jayeshcrm.com Company name : jayesh
	 */
}
