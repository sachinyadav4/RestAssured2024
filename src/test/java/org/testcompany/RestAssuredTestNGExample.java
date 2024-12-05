package org.testcompany;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RestAssuredTestNGExample {

    @Test
    public void getRequest(){

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get().
                then().log().all().statusCode(201);
    }
}
