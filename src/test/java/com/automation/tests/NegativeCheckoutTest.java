package com.automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelUtility;

public class NegativeCheckoutTest extends BaseTest {
	@Test(dataProvider = "invalidCheckoutData")
	public void verifyNagativeCheckout(String firstname, String lastname, String postalcode, String expectedMessage)
	{
		//Login
		LoginPage login = new LoginPage(driver);
		login.login(config.getProperty("username"), config.getProperty("password"));
	
		//Add Products to cart
		HomePage home = new HomePage(driver);
        home.addProductToCart("Sauce Labs Backpack");
        home.addProductToCart("Sauce Labs Bike Light");
        home.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        
        //Navigate to cart Page
        home.clickCartIcon();
        
        //Checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();
        
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterUserInfo(firstname, lastname, postalcode);
        Assert.assertEquals(checkout.getErrorMessage(), expectedMessage);
        
	}
	
//	@DataProvider(name = "invalidCheckoutData")
//	public Object[][] invalidcheckoutData()
//	{
//		return new Object[][] {
//			{"", "Smith", "123", "Error: First Name is required"},
//			{"John", "", "123", "Error: Last Name is required"},
//			{"John", "Smith", "", "Error: Postal Code is required"},
//		};
//	}
	@DataProvider(name = "invalidCheckoutData")
	public Object[][] invalidcheckoutData() throws IOException
	{
		return ExcelUtility.getTestData("Data.xlsx","InvalidCheckoutData");
	}
}
