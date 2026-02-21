package pageobjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Random;

public class DemoBlaze {

    private final Page page;

    // Locators (as strings)
    private String linkLogin = "//*[@id='login2']";
    private String inputUsername = "//*[@id='loginusername']";
    private String inputPassword = "//*[@id='loginpassword']";
    private String btnLogin = "//button[text()='Log in']";

    private String linkSignup = "//*[@id='signin2']";
    private String inputUsername2 = "//*[@id='sign-username']";
    private String inputPassword2 = "//*[@id='sign-password']";
    private String btnSignup = "//button[@onclick='register()']";

    // Constructor
    public DemoBlaze(Page page) {
        this.page = page;
    }

    // Actions
    public void clickLoginLink() {
        page.locator(linkLogin).waitFor();
        page.locator(linkLogin).click();
        System.out.println("Login link clicked.");
    }

    public void enterUsername2(String username) {
        page.locator(inputUsername2).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.locator(inputUsername2).fill(username);
        System.out.println("Username entered: " + username);
    }

    public void enterPassword2(String password) {
        page.locator(inputPassword2).waitFor(new com.microsoft.playwright.Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.locator(inputPassword2).fill(password);
        System.out.println("Password entered.");
    }

    public void clickLoginButton() {
        // Setup dialog handler BEFORE clicking login
        page.onceDialog(dialog -> {
            System.out.println("Login Alert: " + dialog.message());
            dialog.accept();
        });

        page.locator(btnLogin).waitFor();
        page.locator(btnLogin).click();
        System.out.println("Login button clicked.");
    }

    // Reusable method: Login with username and password
    public void LoginSteps(String username, String password) {
        clickLoginLink();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
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
