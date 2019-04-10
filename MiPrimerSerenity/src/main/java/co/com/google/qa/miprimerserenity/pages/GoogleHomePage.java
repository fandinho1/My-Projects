package co.com.google.qa.miprimerserenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

//@DefaultUrl("http://www.google.com")
@DefaultUrl("https://www.bing.com/")
public class GoogleHomePage extends PageObject{
	
	@FindBy(name="q")
    private WebElementFacade searchTerms;
	
	//@FindBy(name="btnk")
	@FindBy(name="go")
    private WebElementFacade lookupButton;

    public void writeInSearchBar(String keyword) {
        //searchTerms.typeAndEnter(keyword);
    	searchTerms.type(keyword);
    }

    public void clicButtonSearch() {
        lookupButton.waitUntilClickable().click();
    }

}
