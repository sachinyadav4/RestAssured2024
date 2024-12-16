package org.testcompany.testNgExample;

import org.testng.annotations.Test;

public class APITesting_020_TestNg_invocationCount {

    @Test(invocationCount = 5)
    public void t1(){
        System.out.println("1");
    }





}
