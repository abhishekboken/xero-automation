package com.westpac.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.westpac.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class WestpacHomePage extends CommonPageUtil<WestpacHomePage> {

    @FindBy(id = "ubermenu-section-link-kiwisaver-ps")
    private WebElement kiwiSaverLink;

    @FindBy(id = "ubermenu-item-cta-kiwisaver-calculators-ps")
    private WebElement kiwiSaverCalculatorsLink;

    public void clickKiwiSaverCalculatorLink() {
        hoverToElement(kiwiSaverLink);
        waitForElementToBeClickable(kiwiSaverCalculatorsLink);
        kiwiSaverCalculatorsLink.click();
    }

    @Override
    protected void load() {
        getDriver().get("https://www.westpac.co.nz");
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the westpac home page: " + url, "https://www.westpac.co.nz/", url);
    }
}
