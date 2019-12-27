package com.demoqa.restapi.stepsdefinitions;

import com.demoqa.restapi.exceptions.delete.DeleteEmployeException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicioRestDeleteStepDefinition {

    private static final String URL_SERVICE = "http://dummy.restapiexample.com/api/v1";

    @Given("^Luis wants to delete an user in the page dummy with id$")
    public void luisWantsToDeleteAnUserInThePageDummyWithId() {
        theActorCalled("Luis").whoCan(CallAnApi.at(URL_SERVICE));
    }

    @When("^he must enter the id (.*) of employe to be deleted$")
    public void heMustEnterTheIdOfEmployeToBeDeleted(String idEmppleado) {
        theActorInTheSpotlight().attemptsTo(Delete.from("/delete/" + idEmppleado));
    }

    @Then("^the status code of the page will be (.*)$")
    public void theStatusCodeOfThePageWillBe(int code) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(code)).
                orComplainWith(DeleteEmployeException.class, DeleteEmployeException.DELETE_EMPLOYE_ERROR));
    }

}
