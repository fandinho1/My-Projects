package com.demoqa.restapi.questions.delete;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeDeletedResponse implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		Response response = actor.recall("responseSave");
		//System.out.println(response.asString());
		return ""+response.getStatusCode();
	}

	public static EmployeDeletedResponse obtained() {
		return new EmployeDeletedResponse();
	}

	
	
}
