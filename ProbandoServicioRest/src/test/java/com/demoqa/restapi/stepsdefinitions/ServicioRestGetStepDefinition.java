package com.demoqa.restapi.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.demoqa.restapi.exceptions.get.ConsultCityException;
import com.demoqa.restapi.questions.get.CityResponse;
import com.demoqa.restapi.questions.get.CityResponseStatusCode;
import com.demoqa.restapi.questions.get.CityResponseStatusLine;
import com.demoqa.restapi.tasks.Connect;
import com.demoqa.restapi.tasks.get.SearchCity;

import static org.hamcrest.core.Is.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ServicioRestGetStepDefinition {

	@Given("^that Luis wants to consult a city$")
	public void thatSusanWantsToConsultACity() throws Exception {
		theActorCalled("Luis").wasAbleTo(Connect.toTheCityPage());
	}

	@When("^she consult city (.*) in the service$")
	public void sheConsultCityInTheService(String city) throws Exception {
		theActorInTheSpotlight().attemptsTo(SearchCity.inTheService(city));
	}

	@Then("^the response of the service shows the city (.*)$")
	public void theResponseOfTheServiceShowsTheCity(String city) throws Exception {
		theActorInTheSpotlight().should(
				seeThat(CityResponse.obtained(), is(city)).orComplainWith(ConsultCityException.class,
						ConsultCityException.CITY_NOT_EQUALS),
				seeThat(CityResponseStatusCode.isCorrect()).orComplainWith(ConsultCityException.class,
						ConsultCityException.STATUS_CODE_INCORRECT),
				seeThat(CityResponseStatusLine.isCorrect()).orComplainWith(ConsultCityException.class,
						ConsultCityException.STATUS_LINE_INCORRECT));
	}

}
