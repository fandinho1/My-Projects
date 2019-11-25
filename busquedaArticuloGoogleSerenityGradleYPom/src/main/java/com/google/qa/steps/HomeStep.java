package com.google.qa.steps;

import com.google.qa.pages.GoogleHomePage;
import net.thucydides.core.annotations.Step;

public class HomeStep {

    GoogleHomePage googleHomePage;

    @Step
    public void isOnHomePage() {
        this.googleHomePage.open();
    }

    @Step
    public void looksFor(String phrase) {
        googleHomePage.writeInSearchBar(phrase);
    }

    @Step
    public void pressTheSearchButton() {
        googleHomePage.clicButtonSearch();
    }

    @Step
    public void chooseFirstSuggestionInTheList() {
        googleHomePage.clicFirstSuggestion();
    }
}
