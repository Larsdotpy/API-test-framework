package com.larsdotpy.personAPI.Java_API_Tests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PUT {

    private final String baseUri = "http://localhost:8081";
    private final String basePath = "person-api";

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/plain", Parser.TEXT); // Register custom parser for "text/plain"
    }

    @Test
    public void testPersonUpdate() {
        // Loop through the 50 people
        for (int i = 1; i <= 50; i++) {

            given()
                    .baseUri(baseUri)
                    .basePath(basePath)
                    .header("Content-Type", "application/json")
                    .body("{ \"personId\": " + i + ", \"firstName\": \"updated firstName\", \"lastName\": \"updated lastName\", \"age\": 1000, \"heightInCm\": 1000, \"weightInKg\": 1000.0, \"country\": \"updated country\", \"married\": true }")
                    .put()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(equalTo("Person successfully updated.")); // Assert plain text response
        }
    }
}
