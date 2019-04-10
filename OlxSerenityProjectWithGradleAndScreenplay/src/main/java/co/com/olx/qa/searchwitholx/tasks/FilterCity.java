package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.utils.FilterUseToSearchResult.selectCity;
import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElement;
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
import net.serenitybdd.screenplay.conditions.Check;
/**
 * @author LUCHO
 */
public class FilterCity implements Task {

	private String city;

	/**
	 * This constructor initializes the city attribute
	 * @param city - the filter city
	 */
	public FilterCity(String city) {
		this.city = city;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElement element = selectCity(city).resolveFor(actor).getWrappedElement();
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), element);
		actor.attemptsTo(
				 Check.whether(selectCity(city).resolveFor(actor).waitUntilClickable().isClickable())
				 .andIfSo(Click.on(selectCity(city))));
	}

	/**¨
	 * This method return one object type FilterCity that in the execution time initialize the 
	 * attribute city with the city from SearchWithFilter in the model and call the task implemented
	 * in this class that clicks on the city filter
	 * @param searchWithFilters - object type SearchWithFilter
	 * @return a object type FilterCity that in the execution time call the task implemented
	 */
	public static FilterCity applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterCity.class,searchWithFilters.getCity());
	}

}
