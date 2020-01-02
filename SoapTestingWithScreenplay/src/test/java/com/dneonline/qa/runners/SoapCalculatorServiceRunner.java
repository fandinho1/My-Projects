package com.dneonline.qa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/features/soap_calculator_service.feature",
        glue = { "com.dneonline.qa.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
)
public class SoapCalculatorServiceRunner {
}
