package co.com.olx.qa.searchwitholx.questions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;
/**
 * @author LUCHO
 */
public class TheSearchResult implements Question<Boolean> {

	public TheSearchResult() {}
	
	@Step("{0} verify that there are search results")
	@Override
	public Boolean answeredBy(Actor actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		return !SearchResultsPage.NO_RESULTS.resolveFor(actor).isVisible();
	}
	
	/**
	 * This method return one object type TheSearchResult that call the Question implemented that return
	 * true or false if there are search results in the page
	 * @return object type TheSearchResult
	 */
	public static TheSearchResult areDisplayed() {
		return new TheSearchResult();
	}
}
