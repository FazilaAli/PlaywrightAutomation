package com.myportfolio.base;

import com.microsoft.playwright.*;
import com.myportfolio.pageobject.CartPage;
import com.myportfolio.pages.AddProducts;
import com.myportfolio.pages.Checkout;
import com.myportfolio.pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    // Declare Page Objects here
    protected Login login;
    protected AddProducts add;
    protected Checkout checkout;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        // Initialize reusable Page Objects
        login = new Login(page);
        add = new AddProducts(page);
        checkout = new Checkout(page);
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
