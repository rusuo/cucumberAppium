package com.saucelabs.appium;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "target/examples", tags = {"~@ignore", "~@pending"}, format = {"html:target/cucumber-report"})

public class RunTests {
}
