package com.summersoft.ctt.yycx.util;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestListener extends TestListenerAdapter {


    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        try {
            ScreenShotOnFailure.takeScreentShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }

}

