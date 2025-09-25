package com.myportfolio.pages;

import com.microsoft.playwright.Page;
import com.myportfolio.pageobject.LoginPage;

public class Login {
    private final LoginPage loginPage;

    public Login(Page page) {
        this.loginPage = new LoginPage(page);
    }

    // Reusable method to login user
    public void verifyLogin(String username, String password) {

        // Set Username
        loginPage.setUsername(username);

        // Set Password
        loginPage.setPassword(password);

        // Click Login Button
        loginPage.clickLogin();
    }
}
