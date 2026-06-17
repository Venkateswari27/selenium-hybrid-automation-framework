package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.base.DriverManager;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class AddToCartTest extends BaseTest
{
	@Test
	public void verifyAddToCart()
	{
		LoginPage login = new LoginPage(DriverManager.getDriver());
		login.login(config.getProperty("username"), config.getProperty("password"));
        
        HomePage home = new HomePage(driver);
        home.addProductToCart("Sauce Labs Bike Light");
        home.addProductToCart("Sauce Labs Fleece Jacket");
        //Assert.assertEquals(home.getCartCount(),"1","Cart count mismatch");
        Assert.assertEquals(home.getCartCount(),"2","Cart count mismatch");
        home.clickCartIcon();

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(cart.isProductPresent("Sauce Labs Bike Light"),"Product not found in cart");
        Assert.assertTrue(cart.isProductPresent("Sauce Labs Fleece Jacket"),"Product not found in cart");
        Assert.assertEquals(cart.getCartItemCount(), 2);
	}
}
