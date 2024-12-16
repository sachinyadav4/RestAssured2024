package org.testcompany.testNgExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_017_TestNg_Parameter {



    @Parameters("browser")
    @Test
    void demo1(String value) {
        System.out.println("Browser is " + value);
        //open browser and select abc

     if(value.equalsIgnoreCase("chrome")) {
         System.out.println("Start testing on ");
     }

        if(value.equalsIgnoreCase("firefox")) {
            System.out.println("Start testing on Firefox");
        }
    }

}
