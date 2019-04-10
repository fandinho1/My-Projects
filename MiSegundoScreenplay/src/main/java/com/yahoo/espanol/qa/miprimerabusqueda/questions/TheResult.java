package com.yahoo.espanol.qa.miprimerabusqueda.questions;

import com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces.YahooResultPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheResult implements Question<String>{
	
	public TheResult() {	}

	@Override
	public String answeredBy(Actor actor) {
		return YahooResultPage.SEARCH_BAR.resolveFor(actor).waitUntilVisible().getValue();
	}
	
	public static TheResult searched() {
		return new TheResult();
	}
}
