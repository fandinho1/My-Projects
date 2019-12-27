package com.demoqa.restapi.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/features/servicio_rest_put.feature",
        glue = { "com.demoqa.restapi.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
)
public class ServicioRestPutRunner {

}
