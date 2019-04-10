package co.com.olx.qa.searchwitholx.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   
@CucumberOptions( features="src/test/resources/features",
        glue = { "co.com.olx.qa.searchwitholx.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
        )  
public class SearchProductWithOlxRunner {

}
