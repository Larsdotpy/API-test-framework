package com.larsdotpy.personAPI.Java_API_Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class GET {


    private final String baseUri = RestAssured.baseURI = "http://localhost:8081";
    private final String basePath = RestAssured.basePath = "person-api";
    private final Response response = when().get(baseUri + "/" + basePath);


    @Test
    public void whenUserInfoIsRetrieved_Then200StatuscodeIsReceived() {
        when().get(baseUri + "/" + basePath).then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void contentTypeHeaderIsEqualToApplicationJson(){
        String actualContentType = response.getHeader("Content-Type");
        Assert.assertEquals(actualContentType, ContentType.JSON.toString(), "Content-Type header is not equal " +
                "to application/json");
    }

    @Test
    public void validateResponseMatchesJsonSchema(){
        given()
                .baseUri(baseUri)
                .basePath(basePath)
                .contentType("application/json")
                .when().get().then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schema.json"));
    }

    @Test
    public void validateResponseContainsMarriedValue(){
        JsonPath jsonPath = response.jsonPath();
        boolean containsMarried = jsonPath.getList("married").contains(true);
        Assert.assertTrue(containsMarried, "Response does not contains the value 'married'");
    }
}
