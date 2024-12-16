package org.testcompany.testNgExample;


import org.testng.annotations.Test;

public class APITesting_013_TestNG {

    @Test(priority = 1)
    public void t1(){
        System.out.println("1");
    }

    @Test(priority = 3)
    public void t2(){
        System.out.println("2");
    }

    @Test(priority = 2)
    public void t3(){
        System.out.println("3");
    }

}
