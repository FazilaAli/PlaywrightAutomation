package com.myportfolio.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.myportfolio.base.BaseTest;
import com.myportfolio.pageobject.CartPage;
import com.myportfolio.pageobject.CheckoutPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Checkout extends BaseTest {
    private final CartPage CartPage;
    private final CheckoutPage CheckoutPage;

    public Checkout(Page page) {
        this.page = page;
        this.CartPage = new CartPage(page);
        this.CheckoutPage = new CheckoutPage(page);
    }

    // Reusable method to Checkout
    public void verifyCheckout() {

        // Click Cart Icon
        CartPage.assertBackPack();

        // Add Backpack to cart
        CartPage.clickCartIcon();

        // Add Jacket to Cart
        CartPage.clickRemoveJacket();

        // Click Checkout
        CartPage.clickCheckout();
    }

    public void verifyCheckoutInformation() {

        // Enter Firstname
        CheckoutPage.setfirstname("John");

        // Enter Lastname
        CheckoutPage.setlastname("Doe");

        // Enter Zipcode
        CheckoutPage.setzipcode("0980737");

        // Enter Click Continue
        CheckoutPage.clickContinue();

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
        CheckoutPage.clickFinish();

    }
}
