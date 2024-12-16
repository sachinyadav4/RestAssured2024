package org.testcompany.testNgExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_014_TestNG {

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg", "qa", "preprod"})
    public void regRun(){
        System.out.println("Regression");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"smoke", "qa", "preprod"})
    public void smokeRun(){
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun2(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"dev", "stage"})
    public void sanityRun3(){
        System.out.println("Dev");
        System.out.println("Stage");
        Assert.assertTrue(true);
    }
}
