package org.testcompany.integration;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class APITesting_011_TestCaseIntegration {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingId;

    public String getToken(){

        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        requestSpecification = given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payLoad);

        //when
        response = requestSpecification.when().post();

        //then
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        //extract the token
        token = response.jsonPath().getString("token");
        System.out.println(token);

        assertThat(token).isNotEmpty().isNotNull().isAlphanumeric().isNotBlank();


        return token;
    }

    public String getBookingId(){

        String payLoad_post = "{\n" +
                "    \"firstname\" : \"sachin\",\n" +
                "    \"lastname\" : \"yadav\",\n" +
                "    \"totalprice\" : 121,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-12-12\",\n" +
                "        \"checkout\" : \"2024-12-12\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payLoad_post).log().all();

        response = requestSpecification.when().post();

        //Get Validate-able response to validate the response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);

        assertThat(bookingId).isNotEmpty().isNotNull().isNotBlank();

        return bookingId;
    }


    @Test(priority = 1)
    public void test_update_request_put(){
        token = getToken();
        bookingId = getBookingId();
        System.out.println(token + ": " + bookingId);

        String payLoadPUT = "{\n" +
                "    \"firstname\" : \"Yad\",\n" +
                "    \"lastname\" : \"Sach\",\n" +
                "    \"totalprice\" : 132,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payLoadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }

    @Test(priority = 2)
    public void test_update_request_get(){
        System.out.println(": " + bookingId);
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);

        String firstname = response.jsonPath().getString("firstname");
        System.out.println(firstname + "----------");

        Assert.assertEquals(firstname,"Yad");


    }

    @Test(priority = 3)
    public void test_delete_booking(){

        System.out.println(bookingId);
        System.out.println(token);

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token).log().all();

        response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);


    }

    @Test(priority = 4)
    public void test_after_delete_request_get(){

     /*   requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        response = requestSpecification.when().log().all().get();
    //    requestSpecification.then().log().all().statusCode(404);

        System.out.println("--------------------------" + response.statusCode());
*/

        Response response =
                given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/booking/" + bookingId)
                        .when()
                        .log().all()
                        .get();

        // Validate the response
        response.then()
                .log().all()
                .statusCode(404);
    }

    @Description("")
    @Test
    public void test_testcaseIntegration(){
        //Create a token
        //Create a booking
        //Perform a put request
        //Verify that put is success by a GET request
        //Delete the request
        //Verify it does not exist with GET request

      getToken();
      getBookingId();

    }
}
