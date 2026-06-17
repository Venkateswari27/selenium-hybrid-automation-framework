package com.automation.stepdefinitions;

import org.testng.Assert;

import com.automation.actions.TestActions;
import com.automation.base.DriverManager;
import com.automation.context.TestContext;
import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
	LoginPage login;
    CartPage cart;
    

    @When("User adds product {string} to cart")
    public void user_adds_product_to_cart(String productName) {
    	 //home.addProductToCart(productName);
    	TestContext.getHomePage().addProductToCart(productName);
    }

    @Then("Cart badge show {string}")
    public void cart_badge_should_show(String count) {
    	 Assert.assertEquals(TestContext.getHomePage().getCartCount(),count);
    }
    
    @Given("User has product {string} in cart")
    public void user_has_product_in_cart(String productName) {

    	// login using reusable action
    	TestContext.setHomePage(TestActions.loginAsStandardUser());
    	// add product
        TestContext.getHomePage().addProductToCart(productName);
        //open cart
        TestContext.getHomePage().clickCartIcon();   // assuming this method exists

        cart = new CartPage(DriverManager.getDriver());
    }
    
    @When("User removes product {string} from cart")
    public void user_removes_product_from_cart(String productName) {

        cart.removeProduct(productName);
    }
    @Then("Cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertEquals(cart.getCartItemCount(), 0);
    }
}
