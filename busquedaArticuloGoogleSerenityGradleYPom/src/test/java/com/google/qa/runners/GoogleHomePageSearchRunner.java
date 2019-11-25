package com.google.qa.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/feature/google_homepage_search.feature",
        glue = { "com.google.qa.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
)
public class GoogleHomePageSearchRunner {
}
