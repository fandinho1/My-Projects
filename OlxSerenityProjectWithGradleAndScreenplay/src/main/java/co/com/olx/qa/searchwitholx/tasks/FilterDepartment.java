package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.utils.FilterUseToSearchResult.selectDepartment;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElement;
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
public class FilterDepartment implements Task {

	private String department;

	/**
	 * This constructor initializes the department attribute
	 * @param department - the filter department
	 */
	public FilterDepartment(String department) {
		this.department = department;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElement element = selectDepartment(department).resolveFor(actor).getWrappedElement();
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), element);
		actor.attemptsTo(
				Check.whether(selectDepartment(department).resolveFor(actor).waitUntilClickable().isClickable())
						.andIfSo(Click.on(selectDepartment(department)))
		);
	}

	/**
	 * This method return one object type FilterDepartment that in the execution time initialize the 
	 * attribute department with the department from SearchWithFilter in the model and call the task implemented
	 * in this class that clicks on the department filter
	 * @param searchWithFilters - object type SearchWithFilter
	 * @return a object type FilterDepartment that in the execution time call the task implemented
	 */
	public static FilterDepartment applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterDepartment.class, searchWithFilters.getDepartment());
	}

}
