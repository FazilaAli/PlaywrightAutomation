package DemoBlaze.PageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPage {

    private Page page;

    // Locators (as strings)
    private String linkLogin = "//*[@id='login2']";
    private String inputUsername = "//*[@id='loginusername']";
    private String inputPassword = "//*[@id='loginpassword']";
    private String btnLogin = "//button[text()='Log in']";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Actions
    public void clickLoginLink() {
        page.locator(linkLogin).waitFor();
        page.locator(linkLogin).click();
        System.out.println("Login link clicked.");
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
}
