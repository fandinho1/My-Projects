package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.userinterfaces.OlxHomePage.TXT_SEARCH_BAR;
import static co.com.olx.qa.searchwitholx.userinterfaces.OlxHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.Is.is;

import org.openqa.selenium.WebElement;

import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElement;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.models.SearchGeneral;
import co.com.olx.qa.searchwitholx.questions.TheInternet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
/**
 * @author LUCHO
 */
public class GeneralProductSearch implements Task {

	private String product;

	/**
	 * This constructor initializes the product attribute
	 * @param product - the name product
	 */
	public GeneralProductSearch(String product) {
		this.product = product;
	}

	@Override
	@Step("{0} search the product")
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElement element = SEARCH_BUTTON.resolveFor(actor).getWrappedElement();
		
		actor.attemptsTo(Enter.theValue(product).into(TXT_SEARCH_BAR));
		highlightWebElement(BrowseTheWeb.as(actor).getDriver(), element);
		actor.attemptsTo(Click.on(SEARCH_BUTTON));
	}

	/**
	 * This method return one object type GeneralProductSearch that in the execution time initialize the 
	 * attribute product with the product from SearchGeneral in the model and call the task implemented
	 * in this class that enter the product in bar search and clicks on the search button
	 * @param searchGeneral - object type SearchWithFilter
	 * @return a object type FilterSubCategory that in the execution time call the task implemented
	 */
	public static GeneralProductSearch byGeneralSearch(SearchGeneral searchGeneral) {
		return instrumented(GeneralProductSearch.class, searchGeneral.getProduct());
	}

}
