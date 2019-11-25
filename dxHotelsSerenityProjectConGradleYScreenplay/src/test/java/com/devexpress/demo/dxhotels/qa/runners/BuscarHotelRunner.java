package com.devexpress.demo.dxhotels.qa.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features="src/test/resources/features/buscar_hotel.feature",
        glue = { "com.devexpress.demo.dxhotels.qa.stepdefinitions" },
        snippets =  SnippetType.CAMELCASE
)
public class BuscarHotelRunner {
}
