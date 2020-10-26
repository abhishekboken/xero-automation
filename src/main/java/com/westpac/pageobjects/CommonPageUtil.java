package com.westpac.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.*;
import org.apache.log4j.Logger;
import static com.westpac.core.DriverFactory.getDriver;

public abstract class CommonPageUtil<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    Logger log = Logger.getLogger(CommonPageUtil.class);

    private static final int TIMEOUT = 5;

    public CommonPageUtil() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), TIMEOUT), this);
    }

    /**
     * Checks for the page state. Waits for a maximum of 10 seconds.
     */
    public void waitForPageLoad() {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(pageLoadCondition);
        } catch (WebDriverException | NullPointerException e) {
            log.info("Exception occurred on wait for page load");
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            log.info("Exception occurred on wait for element to be clickable");
        }
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void waitForExpectedElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            log.info("Exception occurred on wait for expected element");
        }
    }

    public void hoverToElement(WebElement element) {
        Actions hover = new Actions(getDriver());
        hover.moveToElement(element).build().perform();
    }

}
