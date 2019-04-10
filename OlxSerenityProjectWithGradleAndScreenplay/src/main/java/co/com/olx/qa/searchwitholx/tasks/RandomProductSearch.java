package co.com.olx.qa.searchwitholx.tasks;

import static co.com.olx.qa.searchwitholx.utils.ProductSearch.selectRandomProduct;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.Is.is;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.questions.TheInternet;

import static co.com.olx.qa.searchwitholx.utils.HighlightElement.highlightWebElementFacade;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
/**
 * @author LUCHO
 */
public class RandomProductSearch implements Task{

	@Override
	@Step("{0} click on random product")
	public <T extends Actor> void performAs(T actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		
		WebElementFacade element = selectRandomProduct(actor);
		highlightWebElementFacade(BrowseTheWeb.as(actor).getDriver(), element);
		actor.attemptsTo(
				Check.whether(element.waitUntilClickable().isClickable()).andIfSo(Click.on(element))
				);
	}
	
	/**
	 * This method return one object type RandomProductSearch that in the execution time 
	 * call the task implemented in this class that clicks on the random product
	 * @return a object type RandomProductSearch that in the execution time call the task implemented
	 */
	public static RandomProductSearch inSearchResults() {
		return instrumented(RandomProductSearch.class);
	}

}
