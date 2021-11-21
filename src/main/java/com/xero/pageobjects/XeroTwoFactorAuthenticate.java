package com.xero.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.xero.core.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class XeroTwoFactorAuthenticate extends CommonPageUtil<XeroTwoFactorAuthenticate> {

    public static String XERO_TWO_FACTOR_AUTHENTICATE_PAGE = "https://login.xero.com/identity/user/login/two-factor/";

    @FindBy(css = "[data-automationid='auth-continuebutton']")
    private WebElement anotherAuthentication;

    @FindBy(css = ".xui-contentblockitem [data-automationid='auth-authwithsecurityquestionsbutton']")
    private WebElement securityQuestions;

    @FindBy(className = "auth-firstquestion")
    private WebElement firstQuestion;

    @FindBy(className = "auth-secondquestion")
    private WebElement secondQuestion;

    @FindBy(css = ".xui-textinput [data-automationid='auth-firstanswer--input']")
    private WebElement firstAnswer;

    @FindBy(css = ".xui-textinput [data-automationid='auth-secondanswer--input']")
    private WebElement secondAnswer;

    @FindBy(css = "div [data-automationid='auth-submitanswersbutton']")
    private WebElement confirm;

    /**
     * Clicks on Another Authentication option
     */
    public void clickAnotherAuthentication() {
        anotherAuthentication.click();
    }

    /**
     * Clicks on Security Question option
     */
    public void clickSecurityQuestions() {
        securityQuestions.click();
    }

    /**
     * Inputs the answer for first security question
     *
     * @param firstAnswerInput  first security answer from properties file
     * @param secondAnswerInput second security answer from properties file
     * @param thirdAnswerInput  third security answer from properties file
     */
    public void inputSecurityFirstAnswers(String firstAnswerInput, String secondAnswerInput, String thirdAnswerInput) {
        if (firstQuestion.getText().contains("As a child")) {
            firstAnswer.sendKeys(firstAnswerInput);
        } else if (firstQuestion.getText().contains("What street")) {
            firstAnswer.sendKeys(secondAnswerInput);
        } else {
            firstAnswer.sendKeys(thirdAnswerInput);
        }
    }

    /**
     * Inputs the answer for second security question
     *
     * @param firstAnswerInput  first security answer from properties file
     * @param secondAnswerInput second security answer from properties file
     * @param thirdAnswerInput  third security answer from properties file
     */
    public void inputSecuritySecondAnswers(String firstAnswerInput, String secondAnswerInput, String thirdAnswerInput) {
        if (secondQuestion.getText().contains("As a child")) {
            secondAnswer.sendKeys(firstAnswerInput);
        } else if (secondQuestion.getText().contains("What street")) {
            secondAnswer.sendKeys(secondAnswerInput);
        } else {
            secondAnswer.sendKeys(thirdAnswerInput);
        }
    }

    /**
     * Clicks on confirm button
     */
    public void clickConfirm() {
        confirm.click();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertThat("Not on the Xero two factor authenticate page: " + url, XERO_TWO_FACTOR_AUTHENTICATE_PAGE, containsString(url));
    }
}


