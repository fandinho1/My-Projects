package com.google.qa.stepsdefinitions;

import com.google.qa.steps.SearchResultsStep;
import com.google.qa.steps.SelectedProductStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GoogleChooseResultSearchStepDefinition {

    @Steps
    SearchResultsStep user;
    @Steps
    SelectedProductStep selectedLink;

    @When("^He click on the first result link$")
    public void heClickOnTheFirstResultLink() {
        user.chooseFirstResult();
    }

    @Then("^He will go to the (.*)$")
    public void heGoesTo(String expectedPage) {
        selectedLink.isThe(expectedPage);
    }
}
