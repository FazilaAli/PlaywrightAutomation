package DemoBlaze.TestCases;

import DemoBlaze.Base.BaseTest;
import Utils.JsonReader;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // Positive Test
    @Test
    public void testValidLogin() {
        // Read JSON data
        JSONObject data = JsonReader.readJSON("src/test/java/DemoBlaze/TestData/TestData.json");
        JSONObject validUser = (JSONObject) data.get("validUser");

        String username = (String) validUser.get("email");
        String password = (String) validUser.get("password");

        // Navigate to Desired URL
        page.navigate("https://www.demoblaze.com/");

        // Login Steps
        login.LoginSteps(username,password);

        // After login, you can assert user is logged in by checking "Welcome username" text
        String welcomeText = page.locator("//a[text()='Welcome testuser@yopmail.com']").textContent();
        System.out.println("Welcome text: " + welcomeText);
    }

    // Negative Test
    @Test
    public void testInvalidLogin() {
        // Read JSON data
        JSONObject data = JsonReader.readJSON("src/test/java/DemoBlaze/TestData/TestData.json");
        JSONObject validUser = (JSONObject) data.get("invalidUser");

        String username = (String) validUser.get("email");
        String password = (String) validUser.get("password");

        // Navigate to Desired URL
        page.navigate("https://www.demoblaze.com/");

        // Set up dialog handler BEFORE clicking Login
        page.onceDialog(dialog -> {
            String message = dialog.message();
            System.out.println("Dialog says: " + message);

            Assert.assertEquals(message, "User does not exist.", "Login popup did not match!");
            dialog.accept();
        });

        // Login Steps
        login.LoginSteps(username,password);

    }

    // Negative Test
    @Test
    public void testEmptyLogin() {
        // Read JSON data
        JSONObject data = JsonReader.readJSON("src/test/java/DemoBlaze/TestData/TestData.json");
        JSONObject validUser = (JSONObject) data.get("invalidUser");

        String username = (String) validUser.get("email");
        String password = (String) validUser.get("password");

        // Navigate to Desired URL
        page.navigate("https://www.demoblaze.com/");

        // Set up dialog handler BEFORE clicking Login
        page.onceDialog(dialog -> {
            String message = dialog.message();
            System.out.println("Dialog says: " + message);

            Assert.assertEquals(message, "Please fill out Username and Password.", "Login popup did not match!");
            dialog.accept();
        });

        // Login Steps
        login.LoginSteps(username,password);

    }
}
