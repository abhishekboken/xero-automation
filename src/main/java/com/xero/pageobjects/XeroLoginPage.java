package com.xero.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.xero.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class XeroLoginPage extends CommonPageUtil<XeroLoginPage> {

    public static String XERO_LOGIN_PAGE = "https://login.xero.com/identity/user/login";

    @FindBy(id = "xl-form-email")
    private WebElement email;

    @FindBy(id = "xl-form-password")
    private WebElement password;

    @FindBy(id = "xl-form-submit")
    private WebElement submit;

    /**
     * Enter the email address
     *
     * @param emailInput email from properties file
     */
    public void inputEmail(String emailInput) {
        email.sendKeys(emailInput);
    }

    /**
     * Enters password
     *
     * @param passwordInput password from properties file
     */
    public void inputPassword(String passwordInput) {
        password.sendKeys(passwordInput);
    }

    /**
     * Clicks on submit button
     */
    public void clickSubmit() {
        submit.click();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the Xero login page: " + url, XERO_LOGIN_PAGE, url);
    }

}
