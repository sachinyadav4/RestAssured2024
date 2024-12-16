package org.testcompany.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_013_Assertions {

    //TestNG Assertions
    //Hard Assertion vs Soft assertion

   /* @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Assert.assertTrue(false);
        System.out.println("End of the program");
    } */

    @Test
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        System.out.println("End of the program");
    }
}
