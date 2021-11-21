package com.xero.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.xero.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class XeroGoDashboardPage extends CommonPageUtil<XeroGoDashboardPage> {

    public static String XERO_DASHBOARD_PAGE = "https://go.xero.com/dashboard/default.aspx";

    @FindBy(css = ".xnav-tab [data-event-action='Clicked NAVIGATION: accounting']")
    private WebElement accountingMenu;

    @FindBy(css = ".xnav-tab [data-event-action='Clicked NAVIGATION_SUBMENU: bank-accounts']")
    private WebElement bankAccountsSubMenu;

    /**
     * Clicks on Accounting option from the menu
     */
    public void accountingMenuOption() {
        accountingMenu.click();
    }

    /**
     * Clicks on Bank Account sub-menu option under Accounting
     */
    public void bankAccountsSubMenuOption() {
        waitForElementToBeClickable(bankAccountsSubMenu);
        bankAccountsSubMenu.click();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the Xero dashboard page: " + url, XERO_DASHBOARD_PAGE, url);
    }
}
