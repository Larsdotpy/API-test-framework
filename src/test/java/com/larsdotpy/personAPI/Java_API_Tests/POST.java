package com.larsdotpy.personAPI.Java_API_Tests;

import com.larsdotpy.personAPI.model.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertTrue;

public class POST {
    private final String baseUri = RestAssured.baseURI = "http://localhost:8081";
    private final String basePath = RestAssured.basePath = "person-api";
    private final Response response = when().get(baseUri + "/" + basePath);
    private static final String[] FIRST_NAMES = {
            "Emma", "Liam", "Olivia", "Noah", "Ava", "Sophia", "Isabella", "Mia", "Charlotte", "Amelia", "Harper",
            "Evelyn", "Abigail", "Emily", "Elizabeth", "Mila", "Ella", "Avery", "Sofia", "Camila", "Aria", "Scarlett",
            "Victoria", "Madison", "Luna", "Grace", "Chloe", "Penelope", "Layla", "Riley", "Zoey", "Nora", "Lily",
            "Eleanor", "Hannah", "Lillian", "Addison", "Aubrey", "Ellie", "Stella", "Natalie", "Zoe", "Leah", "Hazel",
            "Violet", "Aurora", "Savannah", "Audrey", "Brooklyn", "Bella", "Claire"
    };
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson",
            "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White",
            "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Young", "Hall", "Walker", "Allen", "King",
            "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Hall",
            "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Gomez", "Phillips", "Evans"
    };
    private static final String[] COUNTRIES = {
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia",
            "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
            "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei",
            "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada",
            "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica",
            "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic"
    };

    private static final Random RANDOM = new Random();

    public static String generateRandomFirstName() {
        int randomIndex = RANDOM.nextInt(FIRST_NAMES.length);
        return FIRST_NAMES[randomIndex];
    }

    public static String generateRandomLastName() {
        int randomIndex = RANDOM.nextInt(LAST_NAMES.length);
        return LAST_NAMES[randomIndex];
    }

    public static String generateRandomCountry() {
        int randomIndex = RANDOM.nextInt(COUNTRIES.length);
        return COUNTRIES[randomIndex];
    }

    public static int generateRandomAge() {
        return RANDOM.nextInt(83) + 18; // Generates a random age between 18 and 100
    }

    public static int generateRandomHeight() {
        return RANDOM.nextInt(46) + 155; // Generates a random height between 155 and 200
    }

    public static double generateRandomWeight() {
        double weight = RANDOM.nextDouble() * 50 + 70; // Generates a random weight between 70 and 120
        weight = Math.round(weight * 100.0) / 100.0; // Round to two decimal places
        return weight;
    }

    public static boolean generateRandomMarriedStatus() {
        return RANDOM.nextBoolean();
    }

    @Test
    public void successfullyCreateNewPersonAndReturnStatuscode200() {
            for (int i = 1; i <= 50; i++) {
                String personId = String.valueOf(i);
                String firstName = generateRandomFirstName();
                String lastName = generateRandomLastName();
                int age = generateRandomAge();
                int heightInCm = generateRandomHeight();
                double weightInKg = generateRandomWeight();
                String country = generateRandomCountry();
                boolean married = generateRandomMarriedStatus();

                Person person = new Person(Integer.toString(i), firstName, lastName, age, heightInCm, weightInKg,
                        country, married);

                // Send the POST request and validate the response
                given()
                        .contentType(ContentType.JSON)
                        .body(person)
                        .post(baseUri + "/" + basePath)
                        .then()
                        .statusCode(200)
                        .log().all();

                System.out.println(heightInCm);
                System.out.println(weightInKg);
            }
    }

    @Test
    public void responseTimeIsBelow200ms() {
        for (int i = 1; i <= 50; i++) {
            String personId = String.valueOf(i);
            String firstName = generateRandomFirstName();
            String lastName = generateRandomLastName();
            int age = generateRandomAge();
            int heightInCm = generateRandomHeight();
            double weightInKg = generateRandomWeight();
            String country = generateRandomCountry();
            boolean married = generateRandomMarriedStatus();

            Person person = new Person(Integer.toString(i), firstName, lastName, age, heightInCm, weightInKg,
                    country, married);

            // Start the timer
            long startTime = System.currentTimeMillis();

            // Send the POST request and validate the response
            given()
                    .contentType(ContentType.JSON)
                    .body(person)
                    .post(baseUri + "/" + basePath)
                    .then()
                    .statusCode(200)
                    .log().all();

            // End the timer
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            long responseTime = endTime - startTime;
            System.out.println("Response Time: " + responseTime + "ms");

            // Assert that the response time is less than or equal to 200ms
            assertTrue(responseTime <= 200, "Response time exceeded 200ms");
        }
    }
}
