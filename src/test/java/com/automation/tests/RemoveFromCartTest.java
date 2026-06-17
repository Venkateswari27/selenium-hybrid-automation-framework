package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class RemoveFromCartTest extends BaseTest
{
	@Test
	public void VerifyRemoveProduct() throws InterruptedException
	{
		//login
		LoginPage login = new LoginPage(driver);
		login.login(config.getProperty("username"), config.getProperty("password"));
		//Thread.sleep(15000);
        //Add Product
        HomePage home = new HomePage(driver);
        home.addProductToCart("Sauce Labs Backpack");
        home.addProductToCart("Sauce Labs Bike Light");
        //getCount in HomePage
        Assert.assertEquals(home.getCartCount(), "2" );
        
        //navigate to CartPage
        home.clickCartIcon();
        
        //remove product
        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getCartItemCount(), 2);
		cart.removeProduct("Sauce Labs Bike Light");
		
		//check count after removing
		Assert.assertEquals(cart.getCartItemCount(), 1);
		Assert.assertFalse(cart.isProductPresent("Sauce Labs Bike Light"), 
				"Product still present in Cart");
		Assert.assertTrue(cart.isProductPresent("Sauce Labs Backpack"),
			    "Expected product missing");
	}
}
