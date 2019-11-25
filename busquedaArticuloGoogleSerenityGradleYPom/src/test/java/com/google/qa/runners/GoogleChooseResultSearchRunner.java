package com.google.qa.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/feature/google_choose_resultsearch.feature",
        glue = { "com.google.qa.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
)
public class GoogleChooseResultSearchRunner {
}
