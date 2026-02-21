package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import pageobjects.SauceDemo;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Checkout extends BaseTest {

    public Checkout(Page page) {
        this.page = page;
        sd = new SauceDemo(page);
    }

    // Reusable method to Checkout
    public void verifyCheckout() {

        // Click Cart Icon
        sd.assertBackPack();

        // Add Backpack to cart
        sd.clickCartIcon();

        // Add Jacket to Cart
        sd.clickRemoveJacket();

        // Click Checkout
        sd.clickCheckout();
    }

    public void verifyCheckoutInformation() {

        // Enter Firstname
        sd.setfirstname("John");

        // Enter Lastname
        sd.setlastname("Doe");

        // Enter Zipcode
        sd.setzipcode("0980737");

        // Enter Click Continue
        sd.clickContinue();

        // Assert Checkout Summary

        // "Sauce Labs Backpack"
        page.locator("//div[contains(text(),'Sauce Labs Backpack')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Sauce Labs Backpack')]")).isVisible();

        // "$29.99" (1st occurrence)
        page.locator("(//div[normalize-space(string(.)) = '$29.99'])[1]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("(//div[normalize-space(string(.)) = '$29.99'])[1]")).isVisible();

        // "Payment Information:"
        page.locator("//div[contains(text(),'Payment Information:')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Payment Information:')]")).isVisible();

        // "Shipping Information:"
        page.locator("//div[contains(text(),'Shipping Information:')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Shipping Information:')]")).isVisible();

        // "Free Pony Express Delivery!"
        page.locator("//div[contains(text(),'Free Pony Express Delivery!')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Free Pony Express Delivery!')]")).isVisible();

        // "Price Total"
        page.locator("//div[contains(text(),'Price Total')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Price Total')]")).isVisible();

        // "Item total: $29.99" (2nd occurrence of "$29.99")
        page.locator("(//div[normalize-space(string(.)) = 'Item total: $29.99'])").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("(//div[normalize-space(string(.)) = 'Item total: $29.99'])")).isVisible();

        // "Tax: $2.40"
        page.locator("//div[normalize-space(string(.)) = 'Tax: $2.40']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[normalize-space(string(.)) = 'Tax: $2.40']")).isVisible();

        // "Total: $32.39"
        page.locator("//div[normalize-space(string(.)) = 'Total: $32.39']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[normalize-space(string(.)) = 'Total: $32.39']")).isVisible();
        
        System.out.println("Checkout Summary is asserted");

        // Enter Click Finish
        sd.clickFinish();

    }
}
