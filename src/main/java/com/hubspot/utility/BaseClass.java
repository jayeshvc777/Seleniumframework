package com.hubspot.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public WebDriver startbrowser() throws IOException {
		

	prop = new Properties();
	FileInputStream fis = new FileInputStream("//home//jayesh//d_drive//workspace_eclipse//Caretime//resources//Config.properties"); 
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","//home//jayesh//d_drive//driver//chromedriver");
			driver = new ChromeDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.chrome.driver","//home//jayesh//d_drive//driver//geckodriver");
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;			

}
	

	
	public void initiatecaretime() throws AWTException, InterruptedException {
		//To start Dreamfactory site
		driver.navigate().to(prop.getProperty("url1"));
		//driver.get(prop.getProperty("url1"));
		driver.findElement(By.id("df-login-email")).sendKeys("sandeep@osplabs.com");
		driver.findElement(By.id("df-login-password")).sendKeys("17ct#!m3");
		driver.findElement(By.id("submit-login")).click();
		//Use robot class to press Ctrl+t keys  // to open new tab  		
		
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);

		//Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// To start target site : Caretime 
		driver.navigate().to(prop.getProperty("url2"));
		//driver.get(prop.getProperty("url2"));
		driver.findElement(By.name("username")).sendKeys("ANNHAR889511");
		driver.findElement(By.name("password")).sendKeys("AHmilc#030518");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		
	}
}
	
