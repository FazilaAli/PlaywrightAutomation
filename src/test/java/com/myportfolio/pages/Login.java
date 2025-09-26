package com.myportfolio.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.myportfolio.base.BaseTest;
import com.myportfolio.pageobject.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login extends BaseTest {
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

        // Assert Successful Login by "Products"
        page.locator("//span[contains(text(),'Products')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//span[contains(text(),'Products')]")).isVisible();
        System.out.println("Login Successful");
    }
}
