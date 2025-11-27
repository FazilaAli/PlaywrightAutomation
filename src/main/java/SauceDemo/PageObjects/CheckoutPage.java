package SauceDemo.PageObjects;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutPage {

    private Page page;

    // Locators
    private String firstnameInput = "//input[@placeholder=\"First Name\"]";
    private String lastnameInput = "//input[@placeholder=\"Last Name\"]";
    private String zipcodeInput = "//input[@placeholder=\"Zip/Postal Code\"]";
    private String btnContinue = "//input[@id='continue']";
    private String btnFinish = "//button[@id='finish']";

    
    // Constructor
    public CheckoutPage(Page page) {
        this.page = page;
    }

    // Actions
    // Set First name
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

}
