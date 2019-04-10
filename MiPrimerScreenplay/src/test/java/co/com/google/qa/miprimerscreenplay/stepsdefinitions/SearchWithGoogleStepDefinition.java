package co.com.google.qa.miprimerscreenplay.stepsdefinitions;

import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import co.com.google.qa.miprimerscreenplay.questions.TheResult;
import co.com.google.qa.miprimerscreenplay.tasks.LookUpSomething;
import co.com.google.qa.miprimerscreenplay.userinterfaces.GoogleHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

public class SearchWithGoogleStepDefinition {

	GoogleHomePage googleHomePage;
	
	@Managed
	private WebDriver hisBrowser;
	private Actor lucho = Actor.named("Lucho");

	@Before
	public void actorCanBrowseTheWeb() {
		lucho.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^Lucho is in the site google$")
	public void heIsInTheSiteGoogle() {
		lucho.wasAbleTo(Open.browserOn().the(googleHomePage));
	}

	@When("^He search the word \"([^\"]*)\"$")
	public void heSearchTheWord(String word) {
		lucho.attemptsTo(LookUpSomething.composedOfTheWords(word));
	}

	@Then("^He verify that the word \"([^\"]*)\" is in the results$")
	public void heVerifyThatTheWordIsInTheResults(String expectedValue) {
		lucho.should(seeThat(TheResult.searched(),is(expectedValue)));
	}

}
