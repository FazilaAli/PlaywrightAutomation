package SauceDemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import SauceDemo.base.BaseTest;
import SauceDemo.PageObjects.InventoryPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddProducts extends BaseTest {
    private final InventoryPage InventoryPage;

    public AddProducts(Page page) {
        this.page = page;
        this.InventoryPage = new InventoryPage(page);
    }

    // Reusable method to AddProducts
    public void verifyAddProducts() {

        // Add Backpack to cart
        InventoryPage.clickAddBackPack();

        // Add Jacket to cart
        InventoryPage.clickAddJacket();

        // Assert products are added
        page.locator("//div[@id='shopping_cart_container']//span[contains(text(),'2')]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(page.locator("//div[@id='shopping_cart_container']//span[contains(text(),'2')]")).isVisible();
        System.out.println("Products are added to cart.");
    }
}
