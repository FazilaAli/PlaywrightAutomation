package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceDemo {

    private final Page page;

    // Locators
    private String btnCartIcon = "//a[@class='shopping_cart_link']";
    private String btnRemoveJacket = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[contains(@class,'cart_item_label')]//button";
    private String btnCheckout = "//button[text()='Checkout']";

    private String firstnameInput = "//input[@placeholder=\"First Name\"]";
    private String lastnameInput = "//input[@placeholder=\"Last Name\"]";
    private String zipcodeInput = "//input[@placeholder=\"Zip/Postal Code\"]";
    private String btnContinue = "//input[@id='continue']";
    private String btnFinish = "//button[@id='finish']";

    private String AddtoCartBackPack = "//div[text()='Sauce Labs Backpack']/ancestor::div[contains(@class,'inventory_item_description')]//button";
    private String AddtoCartJacket = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[contains(@class,'inventory_item_description')]//button";

    private String usernameInput = "#user-name";
    private String passwordInput = "#password";
    private String loginButton = "#login-button";

    // Constructor
    public SauceDemo(Page page) {
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

    public void setfirstname(String firstname) {
        page.locator(firstnameInput).waitFor();
        page.locator(firstnameInput).fill(firstname);
        System.out.println("First name is entered.");
    }

    // Set Last name
    public void setlastname(String lastname) {
        page.locator(lastnameInput).waitFor();
        page.locator(lastnameInput).fill(lastname);
        System.out.println("Last name is entered.");
    }

    // Set Zipcode
    public void setzipcode(String zipcode) {
        page.locator(zipcodeInput).waitFor();
        page.locator(zipcodeInput).fill(zipcode);
        System.out.println("Zipcode is entered.");
    }

    public void clickContinue() {
        page.locator(btnContinue).waitFor();
        page.locator(btnContinue).click();
        System.out.println("Continue is clicked.");
    }

    public void clickFinish() {
        page.locator(btnFinish).waitFor();
        page.locator(btnFinish).click();
        System.out.println("Finish is clicked.");
    }

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

    public void setUsername(String username) {
        page.locator(usernameInput).waitFor();
        page.locator(usernameInput).fill(username);
        System.out.println("Username is entered.");
    }

    public void setPassword(String password) {
        page.locator(passwordInput).waitFor();
        page.locator(passwordInput).fill(password);
        System.out.println("Password is entered.");
    }

    public void clickLogin() {
        page.locator(loginButton).waitFor();
        page.locator(loginButton).click();
        System.out.println("Login button is clicked.");
    }

}
