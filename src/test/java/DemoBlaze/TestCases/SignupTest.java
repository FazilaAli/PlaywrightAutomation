package DemoBlaze.TestCases;

import DemoBlaze.Base.BaseTest;
import DemoBlaze.PageObjects.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void testUserSignup() {

        // Navigate to Desired URL
        page.navigate("https://www.demoblaze.com/");

        String email = signup.generateRandomEmail();
        String password = signup.generateRandomPassword();

        // Set up dialog handler BEFORE clicking Sign up
        page.onceDialog(dialog -> {
            String message = dialog.message();
            System.out.println("Dialog says: " + message);

            Assert.assertEquals(message, "Sign up successful.", "Signup popup did not match!");
            dialog.accept();
        });

        signup.clickSignupLink();
        page.waitForSelector("#sign-username");

        signup.enterUsername(email);
        signup.enterPassword(password);
        signup.clickSignupButton();

        // Small wait to ensure dialog is handled
        page.waitForTimeout(2000);
    }

}

