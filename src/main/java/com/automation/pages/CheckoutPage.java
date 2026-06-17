package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class CheckoutPage extends BasePage{
	
	WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
	
	By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By cancelBtn = By.id("cancel");
    By continueBtn = By.id("continue");
    By errorMessage = By.xpath("//h3[@data-test='error']");
    
    public void enterFirstName(String fName)
    {
    	type(firstName, fName);
    }
    
    public void enterLastName(String LName)
    {
    	type(lastName, LName);
    }
    
    public void enterZipCode(String zipCode)
    {
    	type(zip, zipCode);
    }
    
    public void clickContinue() 
    {
        click(continueBtn);
    }
    
    public void clickCancel()
    {
    	click(cancelBtn);
    }
    
    public void enterUserInfo(String fName, String lName, String zipCode)
    {
    	enterFirstName(fName);
    	enterLastName(lName);
    	enterZipCode(zipCode);
    	clickContinue();
    }
    
    public String getErrorMessage()
    {
        return getText(errorMessage);
    }
}
