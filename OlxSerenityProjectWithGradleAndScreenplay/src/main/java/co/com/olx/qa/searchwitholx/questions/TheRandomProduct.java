package co.com.olx.qa.searchwitholx.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.userinterfaces.ProductPage;

public class TheRandomProduct implements Question<Boolean>{

	public TheRandomProduct() {}

	@Step("The product should be loaded")
	@Override
	public Boolean answeredBy(Actor actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		return ProductPage.TITTLE_PRODUCT.resolveFor(actor).isVisible();
	} 
	
	/**
	 * This method return one object type TheRandomProduct that call the Question implemented that return
	 * true or false if the title product is current visible
	 * @return object type TheRandomProduct
	 */
	public static TheRandomProduct isSelectedSuccessfully() {
		return new TheRandomProduct();
	}

}
