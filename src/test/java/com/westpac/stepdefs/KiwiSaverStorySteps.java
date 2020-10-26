package com.westpac.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.westpac.pageobjects.KiwiSaverCalculatorPage;
import com.westpac.pageobjects.KiwiSaverRetirementCalculatorPage;
import com.westpac.pageobjects.WestpacHomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class KiwiSaverStorySteps {

    @Given("user navigates to {string} page")
    public void user_navigates_to_kiwi_saver_retirement_calculator_page(String pageHeading) {
        WestpacHomePage westpacHomePage = new WestpacHomePage();
        westpacHomePage.get();
        westpacHomePage.clickKiwiSaverCalculatorLink();

        KiwiSaverCalculatorPage kiwiSaverCalculatorPage = new KiwiSaverCalculatorPage();
        kiwiSaverCalculatorPage.get();
        kiwiSaverCalculatorPage.clickStartButton();
    }

    @When("user clicks information icon besides {string}")
    public void userClicksInformationIconBesidesCurrentAge(String label) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.get();
        kiwiRetireCalc.clickInformationIcon(label);
    }

    @Then("following message is displayed below the {string} field")
    public void messageIsDisplayedBelowTheCurrentAgeField(String label, String message) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.get();
        assertThat("Information icon message mismatch for " + label, kiwiRetireCalc.getIconInformation(label), equalTo(message));
    }

    @Given("user whose current age is {string}")
    public void userCurrentAge(String age) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.get();
        kiwiRetireCalc.inputCurrentAge(age);
    }

    @And("has employment status {string}")
    public void employmentStatus(String status) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.selectEmploymentStatus(status);
    }

    @And("has a Salary of {string} per annum")
    public void salaryPerAnnum(String salary) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.inputSalary(salary);
    }

    @When("contributes to KiwiSaver @{string}%")
    public void contributesToKiwiSaver(String contributes) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.selectContributionRadioButton(contributes);
    }

    @When("chooses a {string} risk profile")
    public void chooseAProfileRisk(String profile) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.selectRiskProfileRadioButton(profile);
    }

    @Then("can calculate his projected balances at retirement.")
    public void canCalculateHisProjectedBalancesAtRetirement() {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.clickProjectionButton();
        assertThat("Projected retirement balance not present", kiwiRetireCalc.getProjectedValue(), notNullValue());
    }

    @And("current KiwiSaver balance is ${string}")
    public void currentKiwiSaverBalance(String balance) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.inputBalance(balance);
    }

    @When("voluntary contributes ${string} {string}")
    public void voluntaryContributesFrequency(String volContribution, String frequency) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.inputVolContribute(volContribution);
        kiwiRetireCalc.selectFrequency(frequency);
    }

    @And("has saving goals requirement of ${string}")
    public void savingGoalsRequirement(String goal) {
        KiwiSaverRetirementCalculatorPage kiwiRetireCalc = new KiwiSaverRetirementCalculatorPage();
        kiwiRetireCalc.inputSavingGoal(goal);
    }
}
