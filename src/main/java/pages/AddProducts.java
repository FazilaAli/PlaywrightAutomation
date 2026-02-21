package pages;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import pageobjects.SauceDemo;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddProducts extends BaseTest {

    public AddProducts(Page page) {
        this.page = page;
        sd = new SauceDemo(page);
    }

    // Reusable method to AddProducts
    public void verifyAddProducts() {

        // Add Backpack to cart
        sd.clickAddBackPack();

        // Add Jacket to cart
        sd.clickAddJacket();

        // Assert products are added
        page.locator("//div[@id='shopping_cart_container']//span[contains(text(),'2')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[@id='shopping_cart_container']//span[contains(text(),'2')]")).isVisible();
        System.out.println("Products are added to cart.");
    }
}
