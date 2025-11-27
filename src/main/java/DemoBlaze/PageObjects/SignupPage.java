package DemoBlaze.PageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Random;

public class SignupPage {

    private Page page;

    // Locators (Strings like SauceDemo example)
    private String linkSignup = "//*[@id='signin2']";
    private String inputUsername = "//*[@id='sign-username']";
    private String inputPassword = "//*[@id='sign-password']";
    private String btnSignup = "//button[@onclick='register()']";

    // Constructor
    public SignupPage(Page page) {
        this.page = page;
    }

    // Actions
    public void clickSignupLink() {
        page.locator(linkSignup).waitFor();
        page.locator(linkSignup).click();
        System.out.println("Signup link clicked.");
    }

    public void enterUsername(String username) {
        page.locator(inputUsername).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.locator(inputUsername).fill(username);
        System.out.println("Username entered: " + username);
    }

    public void enterPassword(String password) {
        page.locator(inputPassword).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.locator(inputPassword).fill(password);
        System.out.println("Password entered.");
    }

    public void clickSignupButton() {
        page.locator(btnSignup).waitFor();
        page.locator(btnSignup).click();
        System.out.println("Signup button clicked.");
    }

    // Utility methods
    public String generateRandomEmail() {
        Random random = new Random();
        int num = random.nextInt(100000);
        return "testuser" + num + "@yopmail.com";
    }

    public String generateRandomPassword() {
        return "Pass@" + System.currentTimeMillis();
    }
}
