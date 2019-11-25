package com.google.qa.steps;

import com.google.qa.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;

public class SearchResultsStep {

    SearchResultsPage searchResultsPage;

    @Step
    public void areDisplayed() {
        searchResultsPage.resultsPageVisible();
    }

    @Step
    public void isFound(String expectedValue) {
        searchResultsPage.elementFoundInTheResults(expectedValue);
    }

    @Step
    public void chooseFirstResult() {
        searchResultsPage.chooseFirstResultFound();
    }
}
