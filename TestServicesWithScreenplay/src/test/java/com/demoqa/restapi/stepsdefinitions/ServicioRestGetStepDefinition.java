package com.demoqa.restapi.stepsdefinitions;

import com.demoqa.restapi.exceptions.get.ConsultCityException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.Is.is;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ServicioRestGetStepDefinition {

    private static final String URL_SERVICE = "http://restapi.demoqa.com/utilities/weather/city";

    @Given("^that Luis wants to consult a city$")
    public void thatSusanWantsToConsultACity() {
        theActorCalled("Luis").whoCan(CallAnApi.at(URL_SERVICE));
    }

    @When("^she consult city (.*) in the service$")
    public void sheConsultCityInTheService(String city) {
        theActorInTheSpotlight().attemptsTo(Get.resource("/{city}").
                with(request -> request.pathParam("city", city)));
    }

    @Then("^the response of the service shows the city (.*)$")
    public void theResponseOfTheServiceShowsTheCity(String city) throws Exception {
        theActorInTheSpotlight().should(
        		seeThatResponse(response -> response.body("City", is(city))).
                        orComplainWith(ConsultCityException.class, ConsultCityException.CITY_NOT_EQUALS),
                seeThatResponse(response -> response.statusCode(200)).orComplainWith(ConsultCityException.class,
                        ConsultCityException.STATUS_CODE_INCORRECT),
                seeThatResponse(response -> response.statusLine("HTTP/1.1 200 OK")).orComplainWith(ConsultCityException.class,
                        ConsultCityException.STATUS_LINE_INCORRECT));
    }
}
