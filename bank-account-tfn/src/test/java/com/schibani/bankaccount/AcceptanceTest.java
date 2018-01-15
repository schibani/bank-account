package com.schibani.bankaccount;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty", "html:target/cucumber_acceptance",
		"json:target/cucumber_acceptance.json"})
public class AcceptanceTest {
}
