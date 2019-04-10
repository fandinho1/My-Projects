package co.com.google.qa.miprimerserenity.steps;

import co.com.google.qa.miprimerserenity.pages.GoogleHomePage;
import net.thucydides.core.annotations.Step;

public class EndUserStep {
	
	GoogleHomePage googlePage;
	
	@Step
    public void is_the_home_page() {
        googlePage.open();
    }	
	
    @Step
    public void enters(String keyword) {
        googlePage.writeInSearchBar(keyword);
    }

    @Step
    public void startsSearch() {
    	googlePage.clicButtonSearch();    
    }    

    @Step
    public void looks_for(String term) {
        enters(term);
        startsSearch();    
    }

}
