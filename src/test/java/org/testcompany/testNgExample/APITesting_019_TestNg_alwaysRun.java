package org.testcompany.testNgExample;

import org.testng.annotations.Test;

public class APITesting_019_TestNg_alwaysRun {

    @Test
    public void t1(){
        System.out.println("1");
    }

    @Test(alwaysRun = true)
    public void t2(){
        System.out.println("2");
    }

    @Test
    public void t3(){
        System.out.println("3");
    }



}
