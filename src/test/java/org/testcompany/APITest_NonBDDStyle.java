package org.testcompany;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest_NonBDDStyle {

    public static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description ("TC1 - NonBDDStyleGet_Positive Test Case")
    @Test
    public void test_NonBDDStyleGet_Positive(){


        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/560037");

        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Severity(SeverityLevel.NORMAL)
    @Description ("TC1 - NonBDDStyleGet_Negative Test Case")
    @Test
    public void test_NonBDDStyleGet_Negative(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/-1");

        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
}
