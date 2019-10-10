
/*
 * hubspot username/email : jayeshvc777@gmail.com password : Jayesh@007 URL :
 * jayeshcrm.com Company name : jayesh
 * 
 * Plan of Action
 * 
 * 1) creating a sample code structure
 * 2) Adding of utilities, screenshot
 * 3) Adding log4j2
 * 4) Adding extentreports3
 */

package com.hubspot.appTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hubspot.apppages.BasePage;
import com.hubspot.apppages.Page;
import com.hubspot.utility.capturescreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

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

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Linux");
		extent.setSystemInfo("Host Name", "Jayesh");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Jayesh Chhapwale");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("CareTime Report");
		htmlReporter.config().setReportName("CareTime Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			String screenshotpath = Basetest.screenshot(driver, result.getName());
			test.log(Status.FAIL, "Screenshot :"+test.addScreenCaptureFromPath(screenshotpath));
			driver.quit();

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			driver.quit();
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			driver.quit();
		}

	}
	
	public static String screenshot(WebDriver driver, String Screenshot) throws Exception
	{
		
				String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source1 = ts.getScreenshotAs(OutputType.FILE);
				Thread.sleep(2000);
				String dest = System.getProperty("user.dir") + "/FailedtestScreenshots/" + Screenshot + datename + ".png";
				File Destination = new File(dest);
				FileUtils.copyFile(source1, Destination);
				return dest;
	}	
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
