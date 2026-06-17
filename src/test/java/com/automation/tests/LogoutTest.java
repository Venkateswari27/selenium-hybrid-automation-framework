package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class LogoutTest extends BaseTest{
	@Test
	public void VerifyLogout()
	{
		LoginPage login = new LoginPage(driver);
		login.login(config.getProperty("username"), config.getProperty("password"));
		
		HomePage home = new HomePage(driver);
		home.clickMenu();
		home.clickLogout();
		Assert.assertTrue(login.isLoginButtonDisplayed(), "Login page is not displayed after logout");
	
		 // Try to access inventory page directly
        driver.get("https://www.saucedemo.com/inventory.html");

        // Verify user is redirected to login page
        Assert.assertTrue(login.isLoginButtonDisplayed(),
                "User was able to access inventory page after logout");

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/");
	}

}
