package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.base.DriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;


public class LoginTest extends BaseTest
{
	 @Test
	 public void loginTest()
	 {
		 LoginPage login = new LoginPage(driver);
	
		 login.login(config.getProperty("username"), config.getProperty("password"));
		 
		 Assert.assertEquals(driver.getTitle(), "Swag Labs");
		 System.out.println(driver.getTitle());
		 
		 HomePage home = new HomePage(driver);
		 Assert.assertTrue(home.isProductsDisplayed());
	 }
	 
}
