package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");


	public void enterUsername(String username) 
	{
        //driver.findElement(txtUsername).sendKeys(username);
		type(txtUsername, username);
    }

    public void enterPassword(String password) 
    {
        type(txtPassword, password);
    }

    public void clickLogin() 
    {
        click(btnLogin);
    }
    public void login(String username, String password)
    {
    	
    	enterUsername(username);
    	enterPassword(password);
    	clickLogin();
    }
    public boolean isLoginButtonDisplayed()
    {
    	return isDisplayed(btnLogin);
    }
    public String getErrorMessage()
    {
        return getText(errorMessage);
    }
}
