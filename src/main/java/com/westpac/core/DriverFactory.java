package com.westpac.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public DriverFactory(WebDriver driver) {
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void teardown() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

