package com.automation.actions;

import com.automation.base.DriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.stepdefinitions.Hooks;
import com.automation.utilities.ConfigReader;

public class TestActions {
	static ConfigReader config = new ConfigReader();
	
	public static HomePage login(String username, String password) {

        LoginPage login = new LoginPage(DriverManager.getDriver());

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        return new HomePage(DriverManager.getDriver());
	}
	public static HomePage loginAsStandardUser() {
        return login(config.getProperty("username"), config.getProperty("password"));
    }
}
