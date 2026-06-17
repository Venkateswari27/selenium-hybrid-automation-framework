package com.automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelUtility;

public class InvalidLoginTest extends BaseTest{
	@Test(dataProvider = "LoginData")
	public void verifyInvalidLogin(String username, String password, String expectedMessage)
	{
		//Login
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		Assert.assertEquals(login.getErrorMessage(), expectedMessage);
	}
	
//	@DataProvider(name = "LoginData")
//	public Object[][] LoginData()
//	{
//		return new Object[][] 
//		{
//			{"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
//            {"wrong_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
//            {"wrong_user","wrong_password", "Epic sadface: Username and password do not match any user in this service"},
//            {"", "secret_sauce", "Epic sadface: Username is required"},
//	        {"standard_user", "", "Epic sadface: Password is required"},
//	        {"", "", "Epic sadface: Username is required"}
//		};
//	}
	@DataProvider(name="LoginData")
	public Object[][] LoginData() throws IOException
	{
		return ExcelUtility.getTestData("Data.xlsx","LoginData");
	}
}

