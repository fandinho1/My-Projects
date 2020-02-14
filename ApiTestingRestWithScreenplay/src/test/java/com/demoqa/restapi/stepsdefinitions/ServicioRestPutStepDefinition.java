package com.demoqa.restapi.stepsdefinitions;

import java.util.List;

import com.demoqa.restapi.exceptions.put.UpdateEmployeException;
import com.demoqa.restapi.models.Employe;
import com.demoqa.restapi.utils.ReadJson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicioRestPutStepDefinition {

	private static final String URL_SERVICE = "http://dummy.restapiexample.com/api/v1";

	@Given("^Luis wants to update a user in the page dummy$")
	public void luisWantsToUpdateAUserInThePageDummy() {
		theActorCalled("Luis").whoCan(CallAnApi.at(URL_SERVICE));
	}

	@When("^he must enter the information to update (.*)$")
	public void heMustEnterTheInformationToUpdate(int idEmpleado, List<Employe> employe) {
		theActorInTheSpotlight().attemptsTo(Put.to("/update/"+idEmpleado).
				with(request->request.header("Content-Type", "application/json").
						body(ReadJson.getJsonObjectForEmploye(employe.get(0)))));
	}

	@Then("^he will see the status code of the page is (.*)$")
	public void heWillSeeTheStatusCodeOfThePageIs(int code) {
		theActorInTheSpotlight().should(seeThatResponse(response->response.statusCode(code))
				.orComplainWith(UpdateEmployeException.class, UpdateEmployeException.UPDATE_EMPLOYE_ERROR));
	}
}
