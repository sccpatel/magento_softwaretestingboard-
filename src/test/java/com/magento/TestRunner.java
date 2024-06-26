package com.magento;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = "com.magento.stepdefinitions",
plugin = { "pretty","html:target/reporting.html"},
monochrome = true, 
dryRun = false)
public class TestRunner {
}
