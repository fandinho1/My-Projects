package co.com.olx.qa.searchwitholx.questions;
/**
 * @author LUCHO
 */
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.olx.qa.searchwitholx.utils.CheckConnection.connectedToInternet;

public class TheInternet implements Question<Boolean>{
	
	public TheInternet() {}

	
	@Override
	@Step("There must be internet connection")
	public Boolean answeredBy(Actor actor) {
		return connectedToInternet();
	}
	
	/**
	 * This method return one object type TheInternet that call the Question implemented that
	 * verify if there are internet connection or not
	 * @return object type TheInternet
	 */
	@Step("There must be internet connection")
	public static TheInternet isConnected() {
		return new TheInternet();
	}

}
