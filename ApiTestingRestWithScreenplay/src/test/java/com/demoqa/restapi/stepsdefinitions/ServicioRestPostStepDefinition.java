package com.demoqa.restapi.stepsdefinitions;

import com.demoqa.restapi.utils.ReadJson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import com.demoqa.restapi.exceptions.post.RegisterConsumerException;
import com.demoqa.restapi.models.Consumer;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ServicioRestPostStepDefinition {

    private static final String URL_SERVICE = "http://restapi.demoqa.com/customer";

    @Given("^Luis wants to register to the page customer$")
    public void luisWantsToRegisterToThePageCustomer() {
        theActorCalled("Luis").whoCan(CallAnApi.at(URL_SERVICE));
    }

    @When("^he must enter the information to register$")
    public void heMustEnterTheInformationToRegister(List<Consumer> usingDataRequired) {
        theActorInTheSpotlight().attemptsTo(Post.to("/register").
                with(request -> request.header("Content-Type", "application/json")
                        .body(ReadJson.getJsonObjectForConsumer(usingDataRequired.get(0)))));
    }

    @Then("^the status code of the page is (.*)$")
    public void theStatusCodeOfThePageIs(int code) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(code)).
                orComplainWith(RegisterConsumerException.class, RegisterConsumerException.REGISTER_USER_ERROR));
    }

}
