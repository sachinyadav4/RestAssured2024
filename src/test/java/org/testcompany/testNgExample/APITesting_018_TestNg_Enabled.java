package org.testcompany.testNgExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_018_TestNg_Enabled {

    @Test
    public void t1(){
        System.out.println("1");
    }

    @Test(enabled = false)
    public void t2(){
        System.out.println("2");
    }

    @Test
    public void t3(){
        System.out.println("3");
    }



}
