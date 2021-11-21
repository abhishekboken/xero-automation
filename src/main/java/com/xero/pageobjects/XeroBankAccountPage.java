package com.xero.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.xero.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class XeroBankAccountPage extends CommonPageUtil<XeroBankAccountPage> {

    public static String XERO_BANK_ACCOUNTS_PAGE = "https://go.xero.com/Bank/BankAccounts.aspx";

    @FindBy(css = "[data-automationid='Add Bank Account-button']")
    private WebElement addBankAccountButton;

    @FindBy(linkText = "ANZ (NZ)")
    private WebElement anzBank;

    @FindBy(id = "accountname-1025-inputEl")
    private WebElement accountName;

    @FindBy(id = "accounttype-1027-inputEl")
    private WebElement accountType;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Loan']")
    private WebElement loanOption;

    @FindBy(id = "accountnumber-1056-inputEl")
    private WebElement accountNumber;

    @FindBy(css = "a[data-automationid='continueButton']")
    private WebElement continueButton;

    @FindBy(css = "[data-automationid='connectbank-buttonIHaveAForm']")
    private WebElement gotAFormButton;

    @FindBy(css = "[data-automationid='uploadForm-uploadLaterButton']")
    private WebElement uploadLaterButton;

    /**
     * Click on Add Bank Account button.
     */
    public void addBankAccount() {
        waitForElementToBeClickable(addBankAccountButton);
        addBankAccountButton.click();
    }

    /**
     * Selects ANZ bank from the banks listed
     */
    public void selectBank() {
        waitForElementToBeClickable(anzBank);
        anzBank.click();
    }

    /**
     * Enters the account name in account details section
     *
     * @param accountNameInput test account Name
     */
    public void inputAccountName(String accountNameInput) {
        waitForElementToBeClickable(accountName);
        accountName.sendKeys(accountNameInput);
    }

    /**
     * Selects the account type from the list of options
     *
     * @param accountTypeInput account type
     */
    public void selectAccountType(String accountTypeInput) {
        accountType.click();
        waitForElementToBeClickable(loanOption);
        getElementWithSpecifiedText(accountTypeInput).click();
    }

    /**
     * Enters the account number in account details section
     *
     * @param accountNumberInput test account number
     */
    public void enterAccountNumber(String accountNumberInput) {
        accountNumber.sendKeys(accountNumberInput);
    }

    /**
     * Clicks on the continue button
     */
    public void clickContinueButton() {
        continueButton.click();
    }

    /**
     * Clicks on I've got a form button
     */
    public void clickHaveGotAForm() {
        waitForElementToBeClickable(gotAFormButton);
        gotAFormButton.click();
    }

    /**
     * Clicks on upload later button
     */
    public void clickUploadLater() {
        waitForElementToBeClickable(uploadLaterButton);
        uploadLaterButton.click();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the Xero bank accounts page: " + url, XERO_BANK_ACCOUNTS_PAGE, url);
    }
}

