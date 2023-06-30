package com.larsdotpy.personAPI.Java_API_Tests;



import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.when;


public class GET {



    @Test
    public void whenUserInfoIsRetrieved_Then200StatuscodeIsReceived() {

        RestAssured.baseURI = "http://localhost:8081";
        RestAssured.basePath = "person-api";
        when().get().then().assertThat().statusCode(200).log().all();

    }





}
