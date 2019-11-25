package com.google.qa.stepsdefinitions;

import com.google.qa.steps.HomeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.google.qa.steps.SearchResultsStep;
import net.thucydides.core.annotations.Steps;

public class GoogleHomePageSearchStepDefinition {

    @Steps
    HomeStep user;
    @Steps
    SearchResultsStep searchResults;

    @Given("^The user is on the homepage$")
    public void theUserIsOnTheHomepage() {
        user.isOnHomePage();
    }

    @When("^He type (.*) into the search field$")
    public void heTypeIntoTheSearchField(String phrase) {
        user.looksFor(phrase);
    }

    @When("^He click the Google Search button$")
    public void heClickTheGoogleSearchButton() {
        user.pressTheSearchButton();
    }

    @Then("^He goes to the search results page$")
    public void heGoesToTheSearchResultsPage() {
        searchResults.areDisplayed();
    }

    @Then("^the first result is (.*)$")
    public void theFirstResultIs(String expectedValue) {
        searchResults.isFound(expectedValue);
    }

    @When("^He click on the first suggestion in the list displayed$")
    public void heClickOnTheFirstSuggestionInTheListDisplayed() {
        user.chooseFirstSuggestionInTheList();
    }
}
