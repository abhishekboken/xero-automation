package com.westpac.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.westpac.core.DriverFactory;

public class BrowserHooks {
    private WebDriver driver;
    public static final Logger LOGGER = LoggerFactory.getLogger(BrowserHooks.class);

    @Before
    public void initialize() {
        DriverFactory driverFactory = new DriverFactory(driver);
        driverFactory.setup();
        this.driver = driverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.westpac.co.nz/");
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "TestFailure");
            } catch (Exception e) {
                e.printStackTrace();
            }
            DriverFactory driverFactory = new DriverFactory(driver);
            driverFactory.teardown();
        }
    }
}

