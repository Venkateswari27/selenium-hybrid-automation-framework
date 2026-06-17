package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private String addProductXpath = "//div[text()='PRODUCT_NAME']";
    private String removeProductXpath = "//div[text()='PRODUCT_NAME']/ancestor::div[@class='cart_item']//button";
    By cartItems = By.xpath("//div[@class='cart_item']");
    By CheckoutBtn = By.xpath("//button[@id='checkout']");
    
    public boolean isProductPresent(String productName)
    {
    	String dynamicXpath = addProductXpath.replace("PRODUCT_NAME", productName);
    	return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
    }
    public int getCartItemCount() {
    	return driver.findElements(cartItems).size();
    }
    public void removeProduct(String productName) {
    	String removeBtn = removeProductXpath.replace("PRODUCT_NAME", productName);
    	driver.findElement(By.xpath(removeBtn)).click();
    }
    public void clickCheckout()
    {
    	click(CheckoutBtn);
    }
}