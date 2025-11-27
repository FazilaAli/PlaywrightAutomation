package SauceDemo.testcases;

import com.microsoft.playwright.options.WaitForSelectorState;
import SauceDemo.base.BaseTest;
import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class PlaceOrder extends BaseTest {

    // End-to-End Test
    @Test
    public void verifyUserCanPlaceOrder() {

        // Navigate to Desired URL
        page.navigate("https://www.saucedemo.com/");

        // Login flow
        login.verifyLogin("standard_user", "secret_sauce");

        // Add Products
        add.verifyAddProducts();

        // Checkout
        checkout.verifyCheckout();
        checkout.verifyCheckoutInformation();

        // Assert Order Placed Successful
        page.locator("//h2[text()='Thank you for your order!']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//h2[text()='Thank you for your order!']")).isVisible();
        System.out.println("Order Placed Successfully");

    }
}
