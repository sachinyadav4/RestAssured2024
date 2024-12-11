package org.testcompany.post;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest_009_NonBDDStyle {

    RequestSpecification r = RestAssured.given();

    @Description("Verify the POST Request: Non BDD Style")
    @Test
    public void test_non_bdd_post(){

        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payLoad);
        r.when().log().all().post();
        r.then().log().all().statusCode(200);

    }
}
