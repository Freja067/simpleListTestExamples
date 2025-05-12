package ut.ex;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("ut/ex")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ut.ex")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME, value = "pretty, html:build/reports/tests/cucumber-reports/cucumber.html, json:build/reports/tests/cucumber-reports/cucumber.json, message:build/reports/tests/cucumber-reports/cucumber.ndjson")
public class RunCucumberTest {}
// This class is used to run Cucumber tests with JUnit 5.