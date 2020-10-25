package com.westpac.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.westpac.pageobjects.KiwiSaverCalculatorPage;
import com.westpac.pageobjects.KiwiSaverRetirementCalculatorPage;
import com.westpac.pageobjects.WestpacHomePage;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KiwiSaverStorySteps {

    @Given("user navigates to {string} page")
    public void user_navigates_to_kiwi_saver_retirement_calculator_page(String pageHeading) {
        WestpacHomePage onWestpacHomePage = new WestpacHomePage();
        onWestpacHomePage.get();
        onWestpacHomePage.clickKiwiSaverCalculatorLink();

        KiwiSaverCalculatorPage kiwiSaverCalculatorPage = new KiwiSaverCalculatorPage();
        kiwiSaverCalculatorPage.get();
        kiwiSaverCalculatorPage.clickStartButton();
        assertThat("Heading mismatch on " + pageHeading + " page", kiwiSaverCalculatorPage.getHeading(), equalTo(pageHeading));
    }

    @When("user clicks information icon besides {string}")
    public void userClicksInformationIconBesidesCurrentAge(String label) {
        KiwiSaverRetirementCalculatorPage kiwiSaverRetirementCalculatorPage = new KiwiSaverRetirementCalculatorPage();
        kiwiSaverRetirementCalculatorPage.get();
        kiwiSaverRetirementCalculatorPage.clickInformationIcon(label);
    }

    @Then("follwing message is displayed below the {string} field")
    public void messageIsDisplayedBelowTheCurrentAgeField(String label, String message) {
        KiwiSaverRetirementCalculatorPage kiwiSaverRetirementCalculatorPage = new KiwiSaverRetirementCalculatorPage();
        kiwiSaverRetirementCalculatorPage.get();
        assertThat("Information icon message mismatch for " + label, kiwiSaverRetirementCalculatorPage.getIconInformation(label), equalTo(message));
    }

}
