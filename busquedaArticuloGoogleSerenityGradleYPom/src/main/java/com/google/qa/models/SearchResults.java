package com.google.qa.models;

import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResults {
    private static WebElementFacade elementFound = null;

    public static void setElementFound(WebElementFacade element){
        elementFound=element;
    }

    public static WebElementFacade getElementFound(){
        return elementFound;
    }
}
