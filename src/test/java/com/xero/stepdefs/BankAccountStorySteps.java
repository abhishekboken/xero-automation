package com.xero.stepdefs;

import com.xero.core.DataProvider;
import com.xero.pageobjects.XeroBankAccountPage;
import com.xero.pageobjects.XeroGoDashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankAccountStorySteps {

    DataProvider dataProvider = new DataProvider();

    @Given("user navigates to Bank Accounts sub menu under Accounting")
    public void userLoginWithSecurityQuestions() {
        XeroGoDashboardPage xeroGoDashboardPage = new XeroGoDashboardPage();
        xeroGoDashboardPage.accountingMenuOption();
        xeroGoDashboardPage.bankAccountsSubMenuOption();
    }

    @When("user clicks on Add Bank Account")
    public void clicksOnAddBankAccount() {
        XeroBankAccountPage xeroBankAccountPage = new XeroBankAccountPage();
        xeroBankAccountPage.get();
        xeroBankAccountPage.addBankAccount();
    }

    @And("user adds the bank details for {string} account type")
    public void addBankDetails(String accountType) {
        XeroBankAccountPage xeroBankAccountPage = new XeroBankAccountPage();
        xeroBankAccountPage.selectBank();

        Random rnd = new Random();
        int bankAccount = rnd.nextInt(999999999);

        // Enters the account name and sets its value on the setter for further assertion
        String accountName = "TestBankName" + bankAccount;
        xeroBankAccountPage.inputAccountName(accountName);
        dataProvider.setAccountName(accountName);

        xeroBankAccountPage.selectAccountType(accountType);

        // Enterst the account number and sets its value in setter for further assertion
        xeroBankAccountPage.enterAccountNumber(String.valueOf(bankAccount));
        dataProvider.setAccountNumber(String.valueOf(bankAccount));

        xeroBankAccountPage.clickContinueButton();

        xeroBankAccountPage.clickHaveGotAForm();
        xeroBankAccountPage.clickUploadLater();
    }

    @Then("user can view the bank details on the Dashboard")
    public void userCanViewTheBankDetailsOnTheDashboard() {
        XeroGoDashboardPage xeroGoDashboardPage = new XeroGoDashboardPage();

        xeroGoDashboardPage.accountingMenuOption();
        xeroGoDashboardPage.bankAccountsSubMenuOption();

        XeroBankAccountPage xeroBankAccountPage = new XeroBankAccountPage();
        xeroBankAccountPage.get();

        assertThat("Account Name not displayed on Dashboard ", xeroGoDashboardPage.getElementWithSpecifiedText(dataProvider.getAccountName()).getText(),
                containsString(dataProvider.getAccountName()));
        assertThat("Account Number not displayed on Dashboard ", xeroGoDashboardPage.getElementWithSpecifiedText(dataProvider.getAccountNumber()).getText(),
                equalTo(dataProvider.getAccountNumber()));
    }
}
