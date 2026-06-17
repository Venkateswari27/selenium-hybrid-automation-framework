package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    By finishBtn = By.id("finish");
    By cancelBtn = By.id("cancel");

    public void clickFinish() {
        click(finishBtn);
    }

    public void clickCancel() {
        click(cancelBtn);
    }
}
