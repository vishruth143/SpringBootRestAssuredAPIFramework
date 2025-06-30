package com.ea.SpringBootRestAssuredAPIFramework.runner;

import com.ea.SpringBootRestAssuredAPIFramework.utils.RetryFailedTestCases;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/java/com/ea/SpringBootRestAssuredAPIFramework/features"},
        glue = "com.ea.SpringBootRestAssuredAPIFramework.steps",
        plugin = {
            "pretty",                                          // ✅ Console readable format
            "json:target/cucumber-reports/cucumber.json",      // ✅ JSON for advanced reporting if needed
            "html:target/cucumber-reports/cucumber.html",      // ✅  HTML report
            "junit:target/cucumber-reports/cucumber.xml"       // ✅ Optional: JUnit format
        },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
        // ✅ Enable parallel execution of scenarios
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @Test(dataProvider = "scenarios", retryAnalyzer = RetryFailedTestCases.class)
        public void runScenario(PickleWrapper pickle, FeatureWrapper feature) {
                String scenarioName = pickle.getPickle().getName();
                RetryFailedTestCases.setCurrentScenarioName(scenarioName);  // 👈 track it per test
                System.out.println("Running scenario: " + scenarioName);
                super.runScenario(pickle, feature);
        }
}
