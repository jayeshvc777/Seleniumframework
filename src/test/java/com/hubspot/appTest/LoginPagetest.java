package com.hubspot.appTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hubspot.apppages.LoginPage;

public class LoginPagetest extends Basetest {
	@Test
	public void verifyLogingpagetitle() throws InterruptedException {
		Thread.sleep(6000);
		String loginpagetitle = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(loginpagetitle);
		Assert.assertEquals(loginpagetitle, "HubSpot Login");
	}
}
