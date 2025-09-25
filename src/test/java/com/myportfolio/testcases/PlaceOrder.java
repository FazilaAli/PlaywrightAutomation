package com.myportfolio.testcases;

import com.myportfolio.base.BaseTest;
import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.testng.annotations.*;


public class PlaceOrder extends BaseTest {

    @Test
    @Description("Verify user can login successfully")
    @Epic("Authentication")
    @Feature("Login")
    @Story("Valid login credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyUserCanPlaceOrder() {

        // Navigate to Desired URL
        page.navigate("https://www.saucedemo.com/");

        // Login flow (using object from BaseTest)
        login.verifyLogin("standard_user", "secret_sauce");
    }
}
