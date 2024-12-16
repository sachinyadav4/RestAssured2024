package org.testcompany.payLoadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testcompany.payLoadManagement.easyWayPojoUsingGSON.Booking;
import org.testcompany.payLoadManagement.easyWayPojoUsingGSON.Bookingdates;
import org.testng.annotations.Test;

public class APITesting_018_Payload_Pojo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void test_postReq() {

      /*
    {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
     */

        //Poja -> json
        //For above payload, outer set of { is one class, inner set of { is another class.
        //so for above basically two classes


        Booking booking = new Booking();

        booking.setFirstname("sachin");
        booking.setLastname("yadav");
        booking.setTotalprice(222);
        booking.setDepositpaid(true);

        Bookingdates bookingDates = new Bookingdates();
        bookingDates.setCheckin("2024-01-01");
        bookingDates.setCheckout("2024-01-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Lunch");


        System.out.println(booking);


        //poja can be converted to json using gson/jackson api

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        //Get Validate-able response to validate the response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        System.out.println("Your booking id is: " + bookingId);



    }

}
