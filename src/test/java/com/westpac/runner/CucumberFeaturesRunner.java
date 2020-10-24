package com.westpac.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber/cucumber.html", "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features/kiwiSaverTestCases.feature",
        glue = {"com.westpac.stepdefs"})
public class CucumberFeaturesRunner {
}