package co.com.google.qa.miprimerserenity.stepsdefinitions;

import co.com.google.qa.miprimerserenity.steps.EndUserStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchWithGoogleStepDefinition {
	
	@Steps
	EndUserStep lucho;

	@Given("^He is in the site google$")
	public void heIsInTheSiteGoogle() {
		// Write code here that turns the phrase above into concrete actions
		lucho.is_the_home_page();

	}

	@When("^He search the word \"([^\"]*)\"$")
	public void heSearchTheWord(String word) {
		// Write code here that turns the phrase above into concrete actions
		lucho.looks_for(word);
	}

	@Then("^He verify that the word \"([^\"]*)\" is in the results$")
	public void heVerifyThatTheWordIsInTheResults(String arg1) {
		// Write code here that turns the phrase above into concrete actions

	}

}
