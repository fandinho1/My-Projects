package com.dneonline.qa.stepsdefinitions;

import com.dneonline.qa.exceptions.ServiceOperationException;
import com.dneonline.qa.questions.ResultObtained;
import com.dneonline.qa.tasks.RealizarUnaOperacion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.hamcrest.core.Is.is;

public class SoapCalculatorServiceStepDefinition {

    private static final String URL_SERVICE = "http://www.dneonline.com/calculator.asmx";

    @Given("^that Luis wants make an operation$")
    public void thatLuisWantsMakeAnOperation() {
        theActorCalled("Luis").whoCan(CallAnApi.at(URL_SERVICE));
    }

    @When("^he performs the (.*) of two numbers (.*) y (.*)$")
    public void hePerformsTheOperationOfTwoNumbersY(String operation, int numUno, int numDos) {
        theActorInTheSpotlight().attemptsTo(RealizarUnaOperacion.enElServicio(operation,numUno,numDos));
    }

    @Then("^he will see the result of the sum is (.*)$")
    public void heWillSeeTheResultOfTheSumIs(String expectedValue) {
        theActorInTheSpotlight().should(seeThat(ResultObtained.ofOperation(),is(expectedValue)).
                orComplainWith(ServiceOperationException.class,ServiceOperationException.OPERATION_ERROR));
    }
}
