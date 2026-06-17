package com.automation.stepdefinitions;

import org.testng.Assert;

import com.automation.base.DriverManager;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutCompletePage;
import com.automation.pages.CheckoutOverviewPage;
import com.automation.pages.CheckoutPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	CartPage cart;
	CheckoutPage checkout;
	CheckoutOverviewPage overview;
	CheckoutCompletePage complete;
	
	@When("User clicks checkout button")
	public void user_clicks_checkout_button()
	{
		cart = new CartPage(DriverManager.getDriver());
		
		cart.clickCheckout();
		checkout = new CheckoutPage(DriverManager.getDriver());
	}
	
	@When("User enters firstName {string}")
	public void user_enters_first_name(String firstName){

	    checkout.enterFirstName(firstName);
	}
	@When("User enters lastName {string}")
	public void user_enters_last_name(String lastName){

	    checkout.enterLastName(lastName);
	}
	@When("User enters zipCode {string}")
	public void user_enters_zipCode(String zipCode){

	    checkout.enterZipCode(zipCode);
	}
	@When("User clicks continue button")
	public void user_clicks_continue_button()
	{
		checkout.clickContinue();

		overview = new CheckoutOverviewPage(DriverManager.getDriver());
	}
	@When("User clicks finish button")
	public void user_clicks_finish_button()
	{
		overview.clickFinish();

		complete = new CheckoutCompletePage(DriverManager.getDriver());
	}
	@Then("Order should be placed successfully")
	public void Order_should_be_placed_successfully()
	{
		   Assert.assertEquals(complete.getSuccessHeader(),"Thank you for your order!");
	}
	@Then("Checkout error message {string}")
	 public void Checkout_error_message(String expectedMessage)
    {
		Assert.assertEquals(checkout.getErrorMessage(),expectedMessage);
    }
}
