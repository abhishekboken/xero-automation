package com.westpac.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class DriverFactory {
    Logger log = Logger.getLogger(DriverFactory.class);

    public static WebDriver driver;
    private static final int TIMEOUT = 10;

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
    }

    public static void teardown() {
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

