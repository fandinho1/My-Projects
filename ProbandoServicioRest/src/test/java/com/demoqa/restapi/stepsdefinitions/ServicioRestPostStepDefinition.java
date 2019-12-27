package com.demoqa.restapi.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import com.demoqa.restapi.exceptions.post.RegisterConsumerException;
import com.demoqa.restapi.models.Consumer;
import com.demoqa.restapi.questions.post.ConsumerResponse;
import com.demoqa.restapi.tasks.Connect;
import com.demoqa.restapi.tasks.post.Register;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class ServicioRestPostStepDefinition {

	@Given("^Luis wants to register to the page customer$")
	public void luisWantsToRegisterToThePageCustomer() {
		theActorCalled("Luis").wasAbleTo(Connect.toTheCustomerPage());
	}

	@When("^he must enter the information to register$")
	public void heMustEnterTheInformationToRegister(List<Consumer> usingDataRequired) {
		theActorInTheSpotlight().attemptsTo(Register.inConsumerPage(usingDataRequired.get(0)));
	}

	@Then("^the status code of the page is (.*)$")
	public void theStatusCodeOfThePageIs(String code) {
		theActorInTheSpotlight().should(seeThat(ConsumerResponse.statusCode(), is(code))
				.orComplainWith(RegisterConsumerException.class, RegisterConsumerException.REGISTER_USER_ERROR));
	}

}
