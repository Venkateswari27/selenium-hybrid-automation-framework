package com.automation.context;

import com.automation.pages.HomePage;

public class TestContext {
	 public static HomePage homePage;
	 
	 public static void setHomePage(HomePage home)
	 {
		 homePage = home;
	 }
	 public static HomePage getHomePage() 
     {
        return homePage;
     }
	 public static void clear() 
	 {
		 homePage = null;
	 }

}
