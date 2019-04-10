package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.BUTTON_SUBMIT_PRICE;
import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.TXT_MAXPRICE;
import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.TXT_MINPRICE;
import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElement;
import static co.com.olx.qa.searchwitholx.utils.HighlightElement.unhighlightWebElement;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.Is.is;

import org.openqa.selenium.WebElement;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.models.SearchWithFilter;
import co.com.olx.qa.searchwitholx.questions.TheInternet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
/**
 * @author LUCHO
 */
public class FilterPrice implements Task {

	private String minPrice;
	private String maxPrice;

	/**
	 * This constructor initializes the minPrice and maxPrice attributes
	 * @param minPrice - the minPrice category
	 * @param maxPrice - the maxPrice category
	 */
	public FilterPrice(String minPrice,	String maxPrice) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		BrowseTheWeb.as(actor).getDriver().get(BrowseTheWeb.as(actor).getDriver().getCurrentUrl());
		
		WebElement elementMinPrice = TXT_MINPRICE.resolveFor(actor).getWrappedElement();
		WebElement elementMaxPrice = TXT_MAXPRICE.resolveFor(actor).getWrappedElement();
		WebElement elementSubmitPrice = BUTTON_SUBMIT_PRICE.resolveFor(actor).getWrappedElement();
		
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), elementMinPrice);		
		actor.attemptsTo(
				Check.whether(TXT_MINPRICE.resolveFor(actor).waitUntilClickable().isClickable()).andIfSo(
						Enter.theValue(minPrice).into(TXT_MINPRICE))	
			);
		
		
		unhighlightWebElement(BrowseTheWeb.as(actor).getDriver(), elementMinPrice);		
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), elementMaxPrice);		
		actor.attemptsTo(
				Check.whether(TXT_MAXPRICE.resolveFor(actor).waitUntilClickable().isClickable()).andIfSo(
						Enter.theValue(maxPrice).into(TXT_MAXPRICE))	
				);
		
		unhighlightWebElement(BrowseTheWeb.as(actor).getDriver(), elementMaxPrice);	
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), elementSubmitPrice);
		actor.attemptsTo(
				Check.whether(BUTTON_SUBMIT_PRICE.resolveFor(actor).waitUntilClickable().isClickable())
					.andIfSo(Click.on(BUTTON_SUBMIT_PRICE))			
				);
	}

	/**
	 * This method return one object type FiltePrice that in the execution time initialize the minPrice and 
	 * maxPrice attributes with the minPrice and maxPrice from SearchWithFilter in the model and call the 
	 * task implemented in this class that enter a value in minPrice filter, a value in maxPrice filter and 
	 * clicks on the button submit price
	 * @param searchWithFilters - object type SearchWithFilter
	 * @return a object type FilterPrice that in the execution time call the task implemented
	 */
	public static FilterPrice applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterPrice.class, searchWithFilters.getMinPrice(),	searchWithFilters.getMaxPrice());
	}

}
