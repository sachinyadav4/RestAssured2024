package org.testcompany;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_005_BDDStyleGet {

    @Test
    public void Get_Req_PinCode_Positive(){

        String pin_code = "560037";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pin_code)
                .when()
                    .log()
                    .all()
                    .get()
                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }

    @Test
    public void Get_Req_PinCode_Negative(){

        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
