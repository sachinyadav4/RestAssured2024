package org.testcompany.testNgExample;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_012_TestNG {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("2");
    }

    @Test
    public void test_put(){
        System.out.println("3");
    }

}
