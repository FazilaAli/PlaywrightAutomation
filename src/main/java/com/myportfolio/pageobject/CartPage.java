package com.myportfolio.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {

    private Page page;

    // Locators
    private String btnCartIcon = "//a[@class='shopping_cart_link']";
    private String btnRemoveJacket = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[contains(@class,'cart_item_label')]//button";
    private String btnCheckout = "//button[text()='Checkout']";

    // Reusable method to assert Backpack
    // Constructor
    public CartPage(Page page) {
        this.page = page;
    }

    // Actions
    public void clickCartIcon() {
        page.locator(btnCartIcon).waitFor();
        page.locator(btnCartIcon).click();
        System.out.println("CartIcon is clicked.");
    }
    
    public void assertBackPack() {
        // "Sauce Labs Backpack"
        page.locator("//div[contains(text(),'Sauce Labs Backpack')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[contains(text(),'Sauce Labs Backpack')]")).isVisible();

        // "$29.99"
        page.locator("//div[normalize-space(string(.)) = '$29.99']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[normalize-space(string(.)) = '$29.99']")).isVisible();

        System.out.println("Backpack is visible.");
    }

    public void clickRemoveJacket() {
        page.locator(btnRemoveJacket).waitFor();
        page.locator(btnRemoveJacket).click();
        System.out.println("Jacket is Removed from cart.");
    }

    public void clickCheckout() {
        page.locator(btnCheckout).waitFor();
        page.locator(btnCheckout).click();
        System.out.println("Checkout is clicked.");
    }

}
