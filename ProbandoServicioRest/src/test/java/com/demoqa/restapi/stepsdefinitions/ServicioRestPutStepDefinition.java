package com.demoqa.restapi.stepsdefinitions;

import java.util.List;

import com.demoqa.restapi.exceptions.put.UpdateEmployeException;
import com.demoqa.restapi.models.Employe;
import com.demoqa.restapi.questions.put.EmployeResponse;
import com.demoqa.restapi.tasks.Connect;
import com.demoqa.restapi.tasks.put.Update;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class ServicioRestPutStepDefinition {

	@Given("^Luis wants to update a user in the page dummy with id (.*)$")
	public void luisWantsToUpdateAUserInThePageDummy(String idEmpleado) {
		theActorCalled("Luis").wasAbleTo(Connect.toTheDummyPage(idEmpleado));
	}

	@When("^he must enter the information to update$")
	public void heMustEnterTheInformationToUpdate(List<Employe> withSpecifiedData) {
		theActorInTheSpotlight().attemptsTo(Update.theEmployeInformation(withSpecifiedData.get(0)));
	}

	@Then("^he will see the status code of the page is (.*)$")
	public void heWillSeeTheStatusCodeOfThePageIs(String code) {
		theActorInTheSpotlight().should(seeThat(EmployeResponse.obtained(), is(code))
				.orComplainWith(UpdateEmployeException.class, UpdateEmployeException.UPDATE_EMPLOYE_ERROR));
	}
}
