package com.westpac.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;
import static com.westpac.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class KiwiSaverRetirementCalculatorPage extends CommonPageUtil<KiwiSaverRetirementCalculatorPage> {
    Logger log = Logger.getLogger(KiwiSaverRetirementCalculatorPage.class);

    @FindBy(css = "iframe[src*='calculator-widgets/kiwisaver-calculator']")
    private WebElement iframe;

    @FindBy(xpath = "//label[contains(text(),'Current age')]//following::div[1]/div[2]/div/div/div/button/i")
    private WebElement currentAgeInformationIcon;

    @FindBy(xpath = "//label[contains(text(),'Current age')]//following::div[1]/div/div[2]/div")
    private WebElement currentAgeIconInformation;

    public void clickInformationIcon(String label) {
        waitForFrameToBeAvailableAndSwitchToIt(iframe);

        // keeping switch case for further tests
        switch (label) {
            case "Current age":
                waitForElementToBeClickable(currentAgeInformationIcon);
                currentAgeInformationIcon.click();
                break;
            default:
                throw new IllegalStateException("Unexpected label: " + label);
        }
    }

    public String getIconInformation(String label) {
        // keeping switch case for further tests
        switch (label) {
            case "Current age":
                waitForExpectedElement(currentAgeIconInformation);
                return currentAgeIconInformation.getText();
            default:
                throw new IllegalStateException("Unexpected label: " + label);
        }
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForPageLoad();
        String url = getDriver().getCurrentUrl();
        assertEquals("Not on the westpac kiwiSaver retirement  calculator page: " + url, "https://www.westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/", url);
    }
}

