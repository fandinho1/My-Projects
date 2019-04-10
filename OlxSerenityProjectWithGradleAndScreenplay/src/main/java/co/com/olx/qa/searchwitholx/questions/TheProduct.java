package co.com.olx.qa.searchwitholx.questions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
/**
 * @author LUCHO
 */
public class TheProduct implements Question<String>{
	
	public TheProduct() {}

	@Override
	public String answeredBy(Actor actor) {
		actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
		return ProductPage.TITTLE_PRODUCT.resolveFor(actor).waitUntilVisible().getText().trim();		
	}
	
	/**
	 * This method return one object type TheProduct that call the Question implemented that return
	 * the title product from a selected product
	 * @return object type TheProduct
	 */
	public static TheProduct searched() {
		return new TheProduct();
	}

}
