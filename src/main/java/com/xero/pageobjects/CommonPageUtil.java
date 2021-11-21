package com.xero.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.*;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.xero.core.DriverFactory.getDriver;

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

    /**
     * Waits for element to be clickable for a maximum of 10 seconds.
     *
     * @param element locator for expected WebElement
     */
    public void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            log.info("Exception occurred on wait for element to be clickable");
        }
    }

    /**
     * Waits for the iframe to appear and then switches to it with a maximum wait of 10 seconds.
     *
     * @param element locator for the expected iframe
     */
    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * Waits for element to appear for a maximum of 10 seconds.
     *
     * @param element locator for expected WebElement
     */
    public void waitForExpectedElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            log.info("Exception occurred on wait for expected element");
        }
    }

    /**
     * Clicks on a WebElement using a javaScript event.
     *
     * @param element locator for an element to be clicked
     */
    public void clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public WebElement getElementWithSpecifiedText(String text){
        return getDriver().findElement(By.xpath("//*[normalize-space(text()) = '" + text + "']"));
    }
}
