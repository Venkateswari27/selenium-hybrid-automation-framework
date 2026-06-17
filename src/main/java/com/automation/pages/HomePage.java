package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By lblProducts = By.xpath("//span[text()='Products']");
    //By btnAddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By cartBadge = By.className("shopping_cart_badge");
    By cartIcon = By.className("shopping_cart_link");
    By menuIcon = By.id("react-burger-menu-btn");
    By logoutOption = By.id("logout_sidebar_link");
    private static final String ADD_TO_CART_XPATH = "//div[text()='PRODUCT_NAME']/ancestor::div[@class='inventory_item']//button";
    
    
    public boolean isProductsDisplayed() { 
    	return isDisplayed(lblProducts);   
    }
    
    public void addProductToCart(String productName){
    	String dynamicXpath = ADD_TO_CART_XPATH.replace("PRODUCT_NAME", productName);
    	driver.findElement(By.xpath(dynamicXpath)).click();
    }
    
    public String getCartCount() {
    	  if(driver.findElements(cartBadge).size() == 0)
    	  {
    		  return "0";
    	  }
    	  return driver.findElement(cartBadge).getText();
    	}

    public void clickCartIcon() {
    	click(cartIcon);
    }
    public void clickMenu()
    {
    	click(menuIcon);
    	//WaitUtility.waitForVisibility(driver, menuIcon, 10).click();
    	//driver.findElement(menuIcon).click();
    }
    public void clickLogout()
    {
    	click(logoutOption);
    	//WaitUtility.waitForVisibility(driver, logoutOption, 10).click();
    	//driver.findElement(logoutOption).click();
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
}
