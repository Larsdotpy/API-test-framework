package com.larsdotpy.personAPI.Java_API_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DELETE {

    private final String baseUri = "http://localhost:8081";
    private final String basePath = "person-api";

    @Test
    public void deleteRequestsForMultipleIds() {
        List<Integer> ids = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            ids.add(i);
        }

        for (int id : ids) {
            String url = baseUri + "/" + basePath + "/" + id;

            Response response = RestAssured.given()
                    .delete(url);

            int statusCode = response.getStatusCode();
            Assert.assertTrue(statusCode == 200 || statusCode == 202 || statusCode == 204,
                    "Unexpected status code: " + statusCode);

            long responseTime = response.getTime();
            Assert.assertTrue(responseTime < 500,
                    "Response time is greater than 200ms. Actual response time: " + responseTime);
        }
    }
}
