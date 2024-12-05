package org.testcompany;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredHelloWorld {
    public static void main(String[] args) {
    //get request

    //fetch URL

    RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
            .when().get().then().log().all().statusCode(201);

        Response resp = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get();

        String response = resp.getBody().asString();

       // RestAssured.given().baseUri().

        System.out.println("******" + response);


    }
}
