package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void testUserSignup() {

        // Navigate to Desired URL
        page.navigate("https://www.demoblaze.com/");

        String email = dm.generateRandomEmail();
        String password = dm.generateRandomPassword();

        // Set up dialog handler BEFORE clicking Sign up
        page.onceDialog(dialog -> {
            String message = dialog.message();
            System.out.println("Dialog says: " + message);

            Assert.assertEquals(message, "Sign up successful.", "Signup popup did not match!");
            dialog.accept();
        });

        dm.clickSignupLink();
        page.waitForSelector("#sign-username");

        dm.enterUsername2(email);
        dm.enterPassword2(password);
        dm.clickSignupButton();

        // Small wait to ensure dialog is handled
        page.waitForTimeout(2000);
    }

}

