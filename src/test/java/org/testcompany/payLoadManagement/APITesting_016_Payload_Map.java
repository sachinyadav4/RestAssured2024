package org.testcompany.payLoadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITesting_016_Payload_Map {

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

        //json -> Hashmap

        //we see two set of curly braces so kind of two objects
        //using LinkedHashMap to keep the order intact
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "sachin");
        jsonBodyUsingMap.put("lastname", "yadav");
        jsonBodyUsingMap.put("totalprice", 222);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2024-01-01");
        bookingDatesMap.put("checkout","2024-01-01");

        //Now add bookingDate map to the first map .

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);

        jsonBodyUsingMap.put("additionalneeds","Lunch");

        System.out.println(jsonBodyUsingMap);

        //maps printed like below:
        /*
        {
        firstname=sachin,
        lastname=yadav,
        totalprice=222,
        depositpaid=true,
            bookingdates={
                           checkin=2024-01-01,
                           checkout=2024-01-01
                          },
        additionalneeds=Lunch}

         */
        //Map can be converted to json using gson/jackson api

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        //Get Validate-able response to validate the response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        System.out.println("Your booking id is: " + bookingId);



    }

}
