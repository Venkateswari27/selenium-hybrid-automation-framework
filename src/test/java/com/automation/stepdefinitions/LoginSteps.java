package com.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.actions.TestActions;
import com.automation.base.DriverManager;
import com.automation.context.TestContext;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginPage login;
	WebDriver driver = DriverManager.getDriver();
	ConfigReader config = new ConfigReader();
	
	// Used as setup/helper for other scenarios
	@Given("User is logged in")
	public void user_is_logged_in() {
	TestContext.setHomePage(TestActions.loginAsStandardUser());
	}
	
    @Given("User is on login page")
    public void user_is_on_login_page() {
    	login = new LoginPage(driver);
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        login.enterUsername(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        login.enterPassword(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        login.clickLogin();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
    	TestContext.setHomePage(new HomePage(DriverManager.getDriver()));
    	Assert.assertTrue(TestContext.getHomePage().isProductsDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),config.getProperty("inventory.url"));
    }
    
    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage)
    {
        Assert.assertEquals(login.getErrorMessage(),expectedMessage);
    }
    
    @When("User clicks on menu button")
	public void user_clicks_on_menu_button()
	{
    	TestContext.setHomePage(new HomePage(DriverManager.getDriver()));
    	 TestContext.getHomePage().clickMenu();
	}
	
	@And("User clicks on logout button")
	public void user_clicks_on_logout_button()
	{
		TestContext.getHomePage().clickLogout();
	}
	
	@Then("User should logout successfully")
	    public void user_should_logout_successfully() {
			login = new LoginPage(driver);
			Assert.assertEquals(driver.getCurrentUrl(),
	        		    config.getProperty("base.url"));
	    }
}