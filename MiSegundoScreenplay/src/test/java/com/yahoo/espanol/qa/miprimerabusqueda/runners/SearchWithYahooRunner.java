package com.yahoo.espanol.qa.miprimerabusqueda.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   
@CucumberOptions( features="src/test/resources/features",
        glue = { "com.yahoo.espanol.qa.miprimerabusqueda.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
        )  


public class SearchWithYahooRunner {

}
