package org.testcompany.assertion;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class APITesting_014_Assertions_Real {

//POST -Create -> Verify the response

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    Integer bookingId;

    @Test
    public void test_post(){
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

        //Type of assertion libraries which can be used
        //1. Validatable Response - Interface - Hamcrest rest assured (in built )
        //import org.hamcrest.matchers

        validatableResponse.body("booking.firstname", Matchers.equalTo("sachin"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("yadav"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        //2. TestNG Assertions
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "sachin");
        Assert.assertEquals(lastname, "yadav");


        // AssertJ (3rd Lib for assertions
        assertThat(bookingId).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isEqualTo("sachin").isNotNull().isNotBlank().isNotNull().isAlphabetic();



    }

}
