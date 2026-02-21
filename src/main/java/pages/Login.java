package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import pageobjects.SauceDemo;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Login extends BaseTest {

    public Login(Page page) {
        this.page = page;
        sd = new SauceDemo(page);
    }

    // Reusable method to login user
    public void verifyLogin(String username, String password) {

        // Set Username
        sd.setUsername(username);

        // Set Password
        sd.setPassword(password);

        // Click Login Button
        sd.clickLogin();

        // Assert Successful Login by "Products"
        page.locator("//span[contains(text(),'Products')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//span[contains(text(),'Products')]")).isVisible();
        System.out.println("Login Successful");
    }
}
