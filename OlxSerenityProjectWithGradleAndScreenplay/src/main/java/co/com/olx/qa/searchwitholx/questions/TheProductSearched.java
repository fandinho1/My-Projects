package co.com.olx.qa.searchwitholx.questions;

import co.com.olx.qa.searchwitholx.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheProductSearched implements Question<Boolean>{

	public TheProductSearched() {}
	
	@Override
	public Boolean answeredBy(Actor actor) {
		return ProductPage.TITTLE_PRODUCT.resolveFor(actor).waitUntilVisible().isVisible();	
	}
	
	/**
	 * This method return one object type TheProduct that call the Question implemented that return
	 * the title product from a selected product
	 * @return object type TheProduct
	 */
	public static TheProductSearched isFound() {
		return new TheProductSearched();
	}

}
