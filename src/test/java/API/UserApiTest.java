package API;

import Utils.ConfigReader;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest {

    @BeforeClass
    public static void setup() {
        ConfigReader.init();  // Initialize base URI
    }

    // --------------------
    // DataProvider for POST/PUT requests
    // --------------------
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"Fazila", "QA Engineer"},
                {"Ali", "Developer"},
                {"Sara", "Tester"}
        };
    }

    // --------------------
    // GET Users (Positive)
    // --------------------
    @Test
    public void testGetUsers() {
        given()
                .headers(ConfigReader.defaultHeaders())
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(2000L))  // Response time < 2000ms
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue());
    }

    // --------------------
    // GET Single User (Negative)
    // --------------------
    @Test
    public void testGetSingleUserNotFound() {
        given()
                .headers(ConfigReader.defaultHeaders())
                .log().all()
                .when()
                .get("/users/23")
                .then()
                .log().all()
                .statusCode(404)
                .time(lessThan(2000L));
    }

    // --------------------
    // POST Create User (Positive) - Data-driven
    // --------------------
    @Test(dataProvider = "userData")
    public void testCreateUser(String name, String job) {
        String requestBody = String.format("{\"name\":\"%s\",\"job\":\"%s\"}", name, job);

        given()
                .headers(ConfigReader.defaultHeaders())
                .body(requestBody)
                .log().all()
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201)
                .time(lessThan(2000L))
                .body("name", equalTo(name))
                .body("job", equalTo(job))
                .body("id", notNullValue());
    }

    // --------------------
    // POST Create User (Negative)
    // --------------------
    @Test
    public void testCreateUserWithoutBody() {
        given()
                .headers(ConfigReader.defaultHeaders())
                .log().all()
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201)
                .time(lessThan(2000L));
    }

    // --------------------
    // PUT Update User (Positive) - Data-driven
    // --------------------
    @Test(dataProvider = "userData")
    public void testUpdateUser(String name, String job) {
        String requestBody = String.format("{\"name\":\"%s Updated\",\"job\":\"%s Senior\"}", name, job);

        given()
                .headers(ConfigReader.defaultHeaders())
                .body(requestBody)
                .log().all()
                .when()
                .put("/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(2000L))
                .body("name", equalTo(name + " Updated"))
                .body("job", equalTo(job + " Senior"))
                // JSON Schema validation (optional)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }

    // --------------------
    // DELETE User (Positive)
    // --------------------
    @Test
    public void testDeleteUser() {
        given()
                .headers(ConfigReader.defaultHeaders())
                .log().all()
                .when()
                .delete("/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(2000L));
    }
}