package com.yahoo.espanol.qa.miprimerabusqueda.stepsdefinitions;

import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import com.yahoo.espanol.qa.miprimerabusqueda.questions.TheResult;
import com.yahoo.espanol.qa.miprimerabusqueda.tasks.LookUpSomething;
import com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces.YahooHomePage;
import com.yahoo.espanol.qa.miprimerabusqueda.exceptions.PhraseNotFound;
import com.yahoo.espanol.qa.miprimerabusqueda.models.Phrase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

public class SearchWithYahooStepDefinition {
	YahooHomePage yahooHomePage;
	
	@Managed
	private WebDriver hisBrowser;
	private Actor goku = Actor.named("GokuFase3");
	
	@Before
	public void actorCanBrowseTheWeb() {
		goku.can(BrowseTheWeb.with(hisBrowser));
	}
		
	@Given("^Goku is in the site yahoo$")
	public void gokuIsInTheSiteYahoo() {
		goku.wasAbleTo(Open.browserOn().the(yahooHomePage));
	}
	
	@When("^He search the word$")
	public void heSearchTheWord(List<Phrase>phrase) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
		goku.attemptsTo(LookUpSomething.composedOfTheWords(phrase.get(0)));
	}

	@Then("^He verify that the word \"([^\"]*)\" is in the results$")
	public void heVerifyThatTheWordIsInTheResults(String expectedResult) {
		goku.should(seeThat(TheResult.searched(), is(expectedResult)).
				orComplainWith(PhraseNotFound.class, PhraseNotFound.PHRASE_NOT_FOUND));
	}

}
