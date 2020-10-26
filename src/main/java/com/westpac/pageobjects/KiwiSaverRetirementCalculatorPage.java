package com.westpac.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

import java.util.stream.StreamSupport;

import static com.westpac.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class    KiwiSaverRetirementCalculatorPage extends CommonPageUtil<KiwiSaverRetirementCalculatorPage> {
    Logger log = Logger.getLogger(KiwiSaverRetirementCalculatorPage.class);

    @FindBy(css = "iframe[src*='calculator-widgets/kiwisaver-calculator']")
    private WebElement iframe;

    @FindBy(xpath = "//label[contains(text(),'Current age')]//following::div[1]/div[2]/div/div/div/button/i")
    private WebElement currentAgeInformationIcon;

    @FindBy(xpath = "//label[contains(text(),'Current age')]//following::div[1]/div/div[2]/div")
    private WebElement currentAgeIconInformation;

    @FindBy(xpath = "//label[contains(text(),'Current age')]//following::div[8]/div[1]/input")
    private WebElement currentAgeInputField;

    @FindBy(xpath = "//label[contains(text(),'Salary')]//following::div[8]/input")
    private WebElement salaryInputField;

    @FindBy(xpath = "//label[contains(text(),'balance')]//following::div[8]/input")
    private WebElement balanceInputField;

    @FindBy(xpath = "//label[contains(text(),'Voluntary contributions')]//following::div[8]/input")
    private WebElement volContributionInputField;

    @FindBy(xpath = "//label[contains(text(),'Savings goal')]//following::div[8]/input")
    private WebElement savingsGoalInputField;

    @FindBy(xpath = "//label[contains(text(),'Employment status')]//following::div[1]//div[@class='control-well']")
    private WebElement employmentDropDown;

    @FindBy(xpath = "//label[contains(text(),'Voluntary contributions')]//following::div[12]/div[@class='control-well']")
    private WebElement frequencyDropDown;

    @FindBy(className = "control-group")
    private WebElement radioButton;

    @FindBy(xpath = "//button/span[text()='View your KiwiSaver retirement projections']")
    private WebElement retirementProjectionsButton;

    @FindBy(css = ".dropdown ul li[value='employed']")
    private WebElement employedOption;

    @FindBy(css = ".dropdown ul li[value='self-employed']")
    private WebElement selfEmployedOption;

    @FindBy(css = ".dropdown ul li[value='not-employed']")
    private WebElement notEmployedOption;

    @FindBy(css = ".dropdown ul li[value='fortnight']")
    private WebElement fortnightlyOption;

    @FindBy(css = ".dropdown ul li[value='year']")
    private WebElement annuallyOption;

    @FindBy(css = ".control-group div[value='low']")
    private WebElement defensiveOption;

    @FindBy(css = ".control-group div[value='medium']")
    private WebElement conservativeOption;

    @FindBy(css = ".control-group div[value='high']")
    private WebElement balancedOption;

    @FindBy(css = ".control-group div[value='group']")
    private WebElement growthOption;

    @FindBy(className = "result-value")
    private WebElement resultValue;

    public void clickInformationIcon(String label) {
        waitForFrameToBeAvailableAndSwitchToIt(iframe);

        // keeping switch case for future test scenarios
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
        // keeping switch case for future test scenarios
        switch (label) {
            case "Current age":
                waitForExpectedElement(currentAgeIconInformation);
                return currentAgeIconInformation.getText();
            default:
                throw new IllegalStateException("Unexpected label: " + label);
        }
    }

    public void inputCurrentAge(String age) {
        waitForFrameToBeAvailableAndSwitchToIt(iframe);
        currentAgeInputField.sendKeys(String.valueOf(age));
    }

    public void selectEmploymentStatus(String status) {
        employmentDropDown.click();
        switch (status) {
            case "Employed":
                employedOption.click();
                break;
            case "Self-employed":
                selfEmployedOption.click();
                break;
            case "Not employed":
                notEmployedOption.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
    }

    public void inputBalance(String balance){
        balanceInputField.sendKeys(balance);
    }

    public void inputVolContribute(String volContribution) {
    volContributionInputField.sendKeys(volContribution);
    }

    public void selectFrequency(String frequency) {
        frequencyDropDown.click();
        switch (frequency) {
            case "Fortnightly":
                fortnightlyOption.click();
                break;
            case "Annually":
                annuallyOption.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + frequency);
        }
    }

    public void inputSalary(String salary) {
        salaryInputField.sendKeys(salary);
    }

    public void inputSavingGoal(String goal){
        savingsGoalInputField.sendKeys(goal);
    }

    public void clickProjectionButton() {
        retirementProjectionsButton.click();
    }

    public void selectContributionRadioButton(String contribution) {
        radioButton.findElement(By.cssSelector(String.format("div[value='%s']", contribution))).click();
    }

    public void selectRiskProfileRadioButton(String profile) {
        switch (profile) {
            case "Defensive":
                defensiveOption.click();
                break;
            case "Conservative":
                conservativeOption.click();
                break;
            case "Balanced":
                balancedOption.click();
                break;
            case "Growth":
                growthOption.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + profile);
        }
    }

    public String getProjectedValue(){
        return resultValue.getText();
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

