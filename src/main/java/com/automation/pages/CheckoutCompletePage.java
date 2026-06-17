package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage{
	WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    By title = By.xpath("//span[@class='title']");
    By header = By.xpath("//h2[@class='complete-header']");
    By completeText = By.xpath("//div[@class='complete-text']");
    By btnBackHome = By.id("back-to-products");
    
    public String getSuccessTitle() {
    	return driver.findElement(title).getText();
    }
    
    public String getSuccessHeader() {
    	return driver.findElement(header).getText();
    }
    
    public String getSuccessCompleteText() {
    	return driver.findElement(completeText).getText();
    }
    
    public void clickBackHome() {
    	driver.findElement(btnBackHome).click();
    }
}
