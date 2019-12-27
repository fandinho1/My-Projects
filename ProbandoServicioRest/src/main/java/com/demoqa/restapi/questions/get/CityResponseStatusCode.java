package com.demoqa.restapi.questions.get;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CityResponseStatusCode implements Question<Boolean>{
	
	private static final int STATUS_CODE_OK = 200;
	
	@Override
	public Boolean answeredBy(Actor actor) {
		// Usando el HTTP Response se puede obtener el Status, coleccion de Headers y el Body
		Response response = Serenity.sessionVariableCalled("responseSave");
		return response.getStatusCode()==STATUS_CODE_OK;
	}

	public static CityResponseStatusCode isCorrect() {
		return new CityResponseStatusCode();
	}
	
}
