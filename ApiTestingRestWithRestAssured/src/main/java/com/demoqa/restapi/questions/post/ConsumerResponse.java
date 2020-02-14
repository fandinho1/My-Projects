package com.demoqa.restapi.questions.post;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConsumerResponse implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		Response response = actor.recall("responseSave");
		return ""+response.getStatusCode();
	}
	
	public static ConsumerResponse statusCode() {
		return new ConsumerResponse();
	}

}
