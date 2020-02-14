package com.demoqa.restapi.questions.get;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CityResponseStatusLine implements Question<Boolean>{
	
	private static final String HTTP_PROTOCOL = "HTTP/1.1";
	private static final int STATUS_CODE_OK = 200;
	private static final String OK = "OK";

	@Override
	public Boolean answeredBy(Actor actor) {
		Response response = Serenity.sessionVariableCalled("responseSave");
		return response.getStatusLine().equals(HTTP_PROTOCOL+" "+STATUS_CODE_OK+" "+OK);
	}

	public static CityResponseStatusLine isCorrect() {
		return new CityResponseStatusLine();
	}

}
