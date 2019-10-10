package com.hubspot.appTest;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.hubspot.apppages.HomePage;
import com.hubspot.apppages.LoginPage;

public class LoginPagetest extends Basetest {
	
	
	@Test(priority =1)
	public void verifyLogingpagetitle() throws InterruptedException {
		
		test = extent.createTest("test");
		String loginpagetitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(loginpagetitle);
		Assert.assertEquals("HubSpot Login",loginpagetitle);
	}
	
	@Test(priority =2)
	public void verifyloginwithValiddata() {
		test = extent.createTest("test");
		HomePage home = page.getInstance(LoginPage.class).doLogin("jayeshvc777@gmail.com", "Jayesh@007");
		String str =  home.getwelcomePageHeader();
		//String str = page.getInstance(HomePage.class).getwelcomePageHeader();
		Assert.assertEquals("Great job", str);
	}
	@Test(priority =3)
	public void verifyloginwithNodata() {
		test = extent.createTest("test");
		page.getInstance(LoginPage.class).doLogin();
	}
}
