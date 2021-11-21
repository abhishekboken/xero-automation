package com.xero.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.xero.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class XeroHomePage extends CommonPageUtil<XeroHomePage> {

    public static String XERO_HOME_PAGE = "https://www.xero.com/nz/";

    @FindBy(css = "a[href='https://login.xero.com/identity/user/login']")
    private WebElement loginButton;

    /**
     * Click on the login button
     */
    public void clickLoginButton() {
        clickByJavaScript(loginButton);
    }

    @Override
    protected void load() {
        getDriver().get(XERO_HOME_PAGE);
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the Xero login page: " + url, XERO_HOME_PAGE, url);
    }

}

