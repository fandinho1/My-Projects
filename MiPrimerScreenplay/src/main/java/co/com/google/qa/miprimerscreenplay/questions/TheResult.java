package co.com.google.qa.miprimerscreenplay.questions;

import co.com.google.qa.miprimerscreenplay.userinterfaces.GoogleResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("Verify the result")
public class TheResult implements Question<String>{

	public TheResult() {}
	
	@Override
	public String answeredBy(Actor actor) {
		return GoogleResultPage.SEARCH_BAR.resolveFor(actor).waitUntilClickable().getValue();
	}
	/*
	public static boolean thereAreResults(Actor actor) {
		return GoogleResultPage.RESULTS.resolveFor(actor).isPresent();
	}
	*/
	public static TheResult searched() {
		return new TheResult();
	}
}
