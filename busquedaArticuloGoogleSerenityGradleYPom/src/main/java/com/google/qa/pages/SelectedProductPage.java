package com.google.qa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertTrue;

public class SelectedProductPage extends PageObject {

    @FindBy(xpath = "//div[@id='appbar']")
    private WebElementFacade resultsPage;

    public boolean lookForTitlePage(String title) {
        boolean elementFound = false;
        String[] words = title.split(" ");
        for (String word : words) {
            String titlePage = getDriver().getTitle();
            if (!titlePage.contains(word)) {
                elementFound = false;
                break;
            } else {
                elementFound = true;
            }
        }
        return elementFound;
    }

    public void thePageIsCorrect(String title) {
        resultsPage.waitUntilNotVisible();
        assertTrue(lookForTitlePage(title));
    }

}
