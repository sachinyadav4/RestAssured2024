package org.testcompany.testNgExample;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class APITesting_016_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1(){
        System.out.println("Method1");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Closing all connections");
        Assert.assertTrue(true);
    }
}
