package com.myportfolio.pageobject;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    // Locators
    private String usernameInput = "#user-name";
    private String passwordInput = "#password";
    private String loginButton = "#login-button";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Actions
    public void setUsername(String username) {
        page.locator(usernameInput).waitFor();
        page.locator(usernameInput).fill(username);
    }

    public void setPassword(String password) {
        page.locator(passwordInput).waitFor();
        page.locator(passwordInput).fill(password);
    }

    public void clickLogin() {
        page.locator(loginButton).waitFor();
        page.locator(loginButton).click();
    }
    

}
