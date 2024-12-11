package org.testcompany.post;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITest_008_Post_Req {

    @Description("Verify the POST Request BDD Style")
    @Test
    public void test_post_BDDStyle(){

        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all()
                    .body(payLoad)
                .when()
                    .log().all()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);


    }
}
