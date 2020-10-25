package com.westpac.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.westpac.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class KiwiSaverCalculatorPage extends CommonPageUtil<KiwiSaverCalculatorPage> {

    @FindBy(xpath = "//h1")
    private WebElement heading;

    @FindBy(css = ".sw-page-content-bottom-row div section p:nth-child(6) a[href*='kiwisaver-calculator']")
    private WebElement clickToStartButton;

    public void clickStartButton() {
        waitForElementToBeClickable(clickToStartButton);
        clickToStartButton.click();
    }

    public String getHeading() {
        return heading.getText();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the westpac kiwiSaver calculator page: " + url, "https://www.westpac.co.nz/kiwisaver/calculators/", url);
    }
}


