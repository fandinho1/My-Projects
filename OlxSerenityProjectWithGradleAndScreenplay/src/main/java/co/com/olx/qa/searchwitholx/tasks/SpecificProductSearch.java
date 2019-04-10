package co.com.olx.qa.searchwitholx.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.olx.qa.searchwitholx.utils.ProductSearch.searchExactProductEachPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.Is.is;

import org.openqa.selenium.TimeoutException;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.exceptions.ProductNotFound;
import co.com.olx.qa.searchwitholx.questions.TheInternet;
import co.com.olx.qa.searchwitholx.questions.TheProductSearched;

import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElementFacade;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author LUCHO
 */
public class SpecificProductSearch implements Task {

	private String product;

	/**
	 * This constructor initializes the product attribute
	 * 
	 * @param product - the name product
	 */
	public SpecificProductSearch(String product) {
		this.product = product;
	}

	@Override
	@Step("{0} click on the product")
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		try {
			WebElementFacade element = searchExactProductEachPage(actor, product);
			highlightWebElementFacade(BrowseTheWeb.as(actor).getDriver(), element);
			actor.attemptsTo(Click.on(element));
		} catch (TimeoutException ex) {
			actor.should(seeThat(TheProductSearched.isFound(), is(true)).orComplainWith(ProductNotFound.class,
					ProductNotFound.PRODUCT_NOT_FOUND));
		}
	}

	/**
	 * This method return one object type SpecificProductSearch that in the
	 * execution time initialize the attribute product with the specificSearch in
	 * the datatable from feature and call the task implemented in this class that
	 * search the product in each page results and clicks on the product if it is
	 * found
	 * 
	 * @param product - the title product to search
	 * @return a object type SpecificProductSearch that in the execution time call
	 *         the task implemented
	 */
	public static SpecificProductSearch inSearchResults(String product) {
		return instrumented(SpecificProductSearch.class, product);
	}
}
