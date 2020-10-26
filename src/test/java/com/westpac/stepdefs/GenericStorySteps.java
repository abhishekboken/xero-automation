package com.westpac.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.westpac.core.DriverFactory.getDriver;
import static com.westpac.core.DriverFactory.teardown;

public class GenericStorySteps {

    @Given("user refreshes the page to clear projection criteria")
    public void userRefreshesThePageToClearProjectionCriteria() {
        getDriver().navigate().refresh();
    }

    @Then("user closes the browser")
    public void closeTheBrowser() {
        teardown();
    }
}
