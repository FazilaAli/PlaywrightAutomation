package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.DemoBlaze;
import pageobjects.SauceDemo;
import pages.AddProducts;
import pages.Checkout;
import pages.Login;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    // Declare Page Objects here
    protected DemoBlaze dm;
    protected SauceDemo sd;
    protected AddProducts ap;
    protected Checkout ch;
    protected Login log;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        // Initialize reusable Page Objects
        dm = new DemoBlaze(page);
        sd = new SauceDemo(page);
        ap = new AddProducts(page);
        ch = new Checkout(page);
        log = new Login(page);
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
