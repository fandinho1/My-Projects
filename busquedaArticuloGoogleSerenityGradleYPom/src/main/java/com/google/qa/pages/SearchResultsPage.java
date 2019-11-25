package com.google.qa.pages;

import com.google.qa.models.SearchResults;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResultsPage extends PageObject {

    @FindBy(xpath = "//div[@id='appbar']")
    private WebElementFacade resultsPage;

    @FindBy(xpath = "//div[@class='g']//h3")
    private List<WebElementFacade> resultsList;

    public void resultsPageVisible() {
        assertTrue(resultsPage.isPresent());
    }

    public void lookForTitle(String phrase) {
        boolean elementFound=false;
        String[] words = phrase.split(" ");
        for (WebElementFacade element : resultsList) {
            for (String word : words) {
                if (!element.getTextContent().contains(word)) {
                    elementFound = false;
                    break;
                } else {
                    elementFound = true;
                }
            }
            if (elementFound){
                SearchResults.setElementFound(element);
                break;
            }
        }
    }

    public void elementFoundInTheResults(String phrase){
        lookForTitle(phrase);
        assertTrue(SearchResults.getElementFound().isVisible());
    }

    public void chooseFirstResultFound(){
        SearchResults.getElementFound().click();
    }
}
