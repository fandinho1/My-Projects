package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.utils.FilterUseToSearchResult.selectSubCategory;
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
public class FilterSubCategory implements Task {

	private String subcategory;

	/**
	 * This constructor initializes the subCategory attribute
	 * @param subCategory - the filter subCategory
	 */
	public FilterSubCategory(String subCategory) {
		this.subcategory = subCategory;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElement element = selectSubCategory(subcategory).resolveFor(actor).getWrappedElement();
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), element);
		actor.attemptsTo(
				Check.whether(selectSubCategory(subcategory).resolveFor(actor).waitUntilClickable().isClickable())
					.andIfSo(Click.on(selectSubCategory(subcategory)))	
		);
	}

	/**
	 * This method return one object type FilterSubCategory that in the execution time initialize the 
	 * attribute subCategory with the subCategory from SearchWithFilter in the model and call the task implemented
	 * in this class that clicks on the subCategory filter
	 * @param searchWithFilters - object type SearchWithFilter
	 * @return a object type FilterSubCategory that in the execution time call the task implemented
	 */
	public static FilterSubCategory applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterSubCategory.class, searchWithFilters.getSubCategory());
	}

}
