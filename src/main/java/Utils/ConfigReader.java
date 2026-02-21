package Utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ConfigReader {

    public static void init() {
        // Set base URI for all tests
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public static Headers defaultHeaders() {
        return new Headers(
                new Header("Content-Type", "application/json")
        );
    }
}