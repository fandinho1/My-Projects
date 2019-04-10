package com.yahoo.espanol.qa.miprimerabusqueda.tasks;

import static com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces.YahooHomePage.SEARCH_BAR;
import static com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces.YahooHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.yahoo.espanol.qa.miprimerabusqueda.models.Phrase;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LookUpSomething implements Task{

	private String word;
	
	public LookUpSomething(String word) {
		this.word = word;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(word).into(SEARCH_BAR),
				Click.on(SEARCH_BUTTON)
				);
	}
	
	public static LookUpSomething composedOfTheWords(Phrase phrase) {
		return instrumented(LookUpSomething.class,phrase.getCadenaUno()+" "+phrase.getCadenaDos());
	}

}
