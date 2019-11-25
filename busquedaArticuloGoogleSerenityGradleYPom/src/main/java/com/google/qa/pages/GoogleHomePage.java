package com.google.qa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.util.List;

@DefaultUrl("https://www.google.com")
public class GoogleHomePage extends PageObject{

    @FindBy(name="q")
    private WebElementFacade searchTerms;

    @FindBy(xpath="//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")
    private WebElementFacade searchButton;

    @FindBy(xpath="//ul[@class='erkvQe']//li")
    private List<WebElementFacade> suggestionsList;

    public void writeInSearchBar(String phrase) {
       searchTerms.type(phrase);
    }

    public void clicButtonSearch() {
        searchTerms.sendKeys(Keys.ESCAPE);
        searchButton.waitUntilClickable().click();
    }

    public void clicFirstSuggestion(){
        suggestionsList.get(0).click();
    }

}
