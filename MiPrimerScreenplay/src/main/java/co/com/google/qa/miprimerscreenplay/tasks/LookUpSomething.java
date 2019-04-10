package co.com.google.qa.miprimerscreenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.google.qa.miprimerscreenplay.userinterfaces.GoogleHomePage.SEARCH_BAR;
import static co.com.google.qa.miprimerscreenplay.userinterfaces.GoogleHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LookUpSomething implements Task{

	private String phrase;
	
	public LookUpSomething(String phrase) {
		this.phrase=phrase;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(phrase).into(SEARCH_BAR),
				Click.on(SEARCH_BUTTON)
				);		
	}
	
	public static LookUpSomething composedOfTheWords(String word) {
		return instrumented(LookUpSomething.class,word);
	}

}
