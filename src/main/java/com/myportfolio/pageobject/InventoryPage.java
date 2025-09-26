package com.myportfolio.pageobject;

import com.microsoft.playwright.Page;

public class InventoryPage {

    private Page page;

    // Locators
    private String AddtoCartBackPack = "//div[text()='Sauce Labs Backpack']/ancestor::div[contains(@class,'inventory_item_description')]//button";
    private String AddtoCartJacket = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[contains(@class,'inventory_item_description')]//button";

    // Constructor
    public InventoryPage(Page page) {
        this.page = page;
    }

    // Actions
    public void clickAddBackPack() {
        page.locator(AddtoCartBackPack).waitFor();
        page.locator(AddtoCartBackPack).click();
        System.out.println("Backpack is added to cart.");
    }

    public void clickAddJacket() {
        page.locator(AddtoCartJacket).waitFor();
        page.locator(AddtoCartJacket).click();
        System.out.println("Jacket is added to cart.");
    }

}
