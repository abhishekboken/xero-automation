package com.xero.stepdefs;

import com.xero.core.DataProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Date;


import org.apache.log4j.Logger;

import static com.xero.core.DriverFactory.*;

public class BrowserHooks {
    Logger log = Logger.getLogger(BrowserHooks.class);

    @Before
    public void initialize() {
        setup();
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        DataProvider.initializePropertiesFile();
    }

    @After
    public void takeScreenshotForFailedScenarioStepAndTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "TestFailure");
                log.info("URL on test failure step: " + getDriver().getCurrentUrl());
                log.info("Test failure screenshot timestamp: " + new Date(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            teardown();
        } else {
            teardown();
        }
    }

}


