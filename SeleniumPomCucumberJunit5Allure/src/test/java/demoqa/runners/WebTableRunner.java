package demoqa.runners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features/web_table.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "demoqa.stepdefinitions")
public class WebTableRunner {

}
