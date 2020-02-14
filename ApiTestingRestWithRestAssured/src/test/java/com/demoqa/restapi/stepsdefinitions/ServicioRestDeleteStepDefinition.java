package com.demoqa.restapi.stepsdefinitions;

import com.demoqa.restapi.exceptions.delete.DeleteEmployeException;
import com.demoqa.restapi.questions.delete.EmployeDeletedResponse;
import com.demoqa.restapi.tasks.Connect;
import com.demoqa.restapi.tasks.delete.Delete;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class ServicioRestDeleteStepDefinition {
	
	@Given("^Luis wants to delete an user in the page dummy with id$")
	public void luisWantsToDeleteAnUserInThePageDummyWithId() {
		theActorCalled("Luis").wasAbleTo(Connect.toTheDummyPage());
	}

	@When("^he must enter the id (.*) of employe to be deleted$")
	public void heMustEnterTheIdOfEmployeToBeDeleted(String withIdEmpleado) {
		theActorInTheSpotlight().attemptsTo(Delete.anEmploye(withIdEmpleado));
	}

	@Then("^the status code of the page will be (.*)$")
	public void theStatusCodeOfThePageWillBe(String code) {
		theActorInTheSpotlight().should(seeThat(EmployeDeletedResponse.obtained(),is(code)).
				orComplainWith(DeleteEmployeException.class, DeleteEmployeException.DELETE_EMPLOYE_ERROR));
	}

}
