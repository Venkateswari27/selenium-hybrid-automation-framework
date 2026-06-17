package com.automation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutCompletePage;
import com.automation.pages.CheckoutOverviewPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelUtility;

public class CheckoutTest extends BaseTest{
	@Test(dataProvider = "CheckoutData")
	public void VerifyCheckout(String firstname, String lastname, String postalcode)
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
//      checkout.enterUserInfo("first", "last", "12345" );
        checkout.enterUserInfo(firstname, lastname, postalcode);
        
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
        //Checkout Overview
        CheckoutOverviewPage overview =new CheckoutOverviewPage(driver);
        overview.clickFinish();
        
        //Checkout Confirmation
        CheckoutCompletePage complete =new CheckoutCompletePage(driver);
        
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
        
        Assert.assertEquals(complete.getSuccessTitle(), 
        		"Checkout: Complete!");
        
        Assert.assertEquals(complete.getSuccessHeader(), 
        		"Thank you for your order!");
        
        Assert.assertEquals(complete.getSuccessCompleteText(), 
        		"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        
        complete.clickBackHome();
        Assert.assertTrue(home.isProductsDisplayed(), "HomePage Not Displayed");
	}
	
	@DataProvider(name = "CheckoutData")
	public Object[][] invalidcheckoutData() throws IOException
	{
		return ExcelUtility.getTestData("Data.xlsx","CheckoutData");
	}
	
}
