package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.utils.FilterUseToSearchResult.selectCategory;
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
public class FilterCategory implements Task {

	private String category;

	/**
	 * This constructor initializes the category attribute
	 * @param category - the filter category
	 */
	public FilterCategory(String category) {
		this.category = category;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).getDriver().get(BrowseTheWeb.as(actor).getDriver().getCurrentUrl());
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElement element = selectCategory(category).resolveFor(actor).getWrappedElement();
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), element);		
		actor.attemptsTo(
				Check.whether(selectCategory(category).resolveFor(actor).waitUntilClickable().isClickable())
					.andIfSo(Click.on(selectCategory(category)))
			);
	}

	/**
	 * This method return one object type FilterCategory that in the execution time initialize the 
	 * attribute category with the category from SearchWithFilter in the model and call the task implemented
	 * in this class that clicks on the category filter
	 * @param searchWithFilters - object type SearchWithFilter
	 * @return a object type FilterCategory that in the execution time call the task implemented
	 */
	public static FilterCategory applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterCategory.class, searchWithFilters.getCategory());
	}
}
