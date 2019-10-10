package com.hubspot.apppages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends Page  {

	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	// gerneric util wrapping

	@Override
	public void doClick(By locator) {
		try {
			boolean elementIsClickable = getElement(locator).isEnabled();
			while (elementIsClickable) {
				getElement(locator).click();
				break;
			}

		} catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}

	}

	@Override
	public void doClear(By locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSendKeys(By locator, String text) {
		try {
			boolean elementIsClickable = getElement(locator).isEnabled();
			while (elementIsClickable) {
				getElement(locator).sendKeys(text);
				break;
			}

		} catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}

	}

	@Override
	public String doGetText(By locator) {

		return getElement(locator).getText();
	}

	@Override
	public String getPagetitle(String text) {
		waitforPageTitle(text);
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitforElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Element not created " + locator.toString());
			e.printStackTrace();
		}
		return element;

	}

	@Override
	public void waitforElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("some error occured at " + locator.toString());
		}

	}

	@Override
	public void waitforPageTitle(String text) {
		try {
			wait.until(ExpectedConditions.titleContains(text));
		} catch (Exception e) {
			System.out.println("some error occured finding title");
		}

	}

	

}
