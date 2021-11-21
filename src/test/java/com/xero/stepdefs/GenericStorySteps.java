package com.xero.stepdefs;

import com.xero.core.DataProvider;
import com.xero.pageobjects.XeroHomePage;
import com.xero.pageobjects.XeroLoginPage;
import com.xero.pageobjects.XeroTwoFactorAuthenticate;
import io.cucumber.java.en.Given;


public class GenericStorySteps {
    @Given("user login to Xero production with security questions")
    public void userLoginWithSecurityQuestions() {
        XeroHomePage xeroHomePage = new XeroHomePage();
        xeroHomePage.get();
        xeroHomePage.clickLoginButton();

        XeroLoginPage xeroLoginPage = new XeroLoginPage();
        xeroLoginPage.get();
        xeroLoginPage.inputEmail(DataProvider.property.getProperty("Email"));
        xeroLoginPage.inputPassword(DataProvider.property.getProperty("Password"));
        xeroLoginPage.clickSubmit();


        XeroTwoFactorAuthenticate xeroTwoFactorAuthenticate = new XeroTwoFactorAuthenticate();
        xeroTwoFactorAuthenticate.clickAnotherAuthentication();
        xeroTwoFactorAuthenticate.clickSecurityQuestions();

        // Inputs the security answers required to login
        String firstAnswer = DataProvider.property.getProperty("FirstSecurityQuestion");
        String secondAnswer = DataProvider.property.getProperty("SecondSecurityQuestion");
        String thirdAnswer = DataProvider.property.getProperty("ThirdSecurityQuestion");
        xeroTwoFactorAuthenticate.inputSecurityFirstAnswers(firstAnswer, secondAnswer, thirdAnswer);
        xeroTwoFactorAuthenticate.inputSecuritySecondAnswers(firstAnswer, secondAnswer, thirdAnswer);
        xeroTwoFactorAuthenticate.clickConfirm();
    }
}
