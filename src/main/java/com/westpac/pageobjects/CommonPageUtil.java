package com.westpac.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.westpac.core.DriverFactory;

public class CommonPageUtil extends DriverFactory {

    private static final int TIMEOUT = 5;
    public static final Logger LOGGER = LoggerFactory.getLogger(CommonPageUtil.class);

    public CommonPageUtil() {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    /**
     * Checks for the page state. Waits for a maximum of 10 seconds.
     */
    public void waitForPageLoad() {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(pageLoadCondition);
        } catch (WebDriverException | NullPointerException e) {
            LOGGER.info("Exception occurred on wait for page load");
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            LOGGER.info("Exception occurred on wait for element to be clickable");
        }
    }

    public void waitForExpectedElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            LOGGER.info("Exception occurred on wait for expected element");
        }
    }
}
