package org.testcompany.put;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest_010_PUT_NonBDDStyle {

    RequestSpecification requestSpecification = RestAssured.given();

    @Description("Verify the PUT request for Restful booker API")
    @Test
    //if test fails, generate the booking Id and token again and retry
    public void test_put_nonBDDStyle(){

        String token = "c501d5e1298033b";

        String bookingID = "2674";

        String payLoadPUT = "{\n" +
                "    \"firstname\" : \"Jimm\",\n" +
                "    \"lastname\" : \"Brownn\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payLoadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);





    }
}
