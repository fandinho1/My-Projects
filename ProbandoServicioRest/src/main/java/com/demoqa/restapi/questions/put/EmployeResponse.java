package com.demoqa.restapi.questions.put;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeResponse implements Question<String>{
	
	@Override
	public String answeredBy(Actor actor) {
		Response response = actor.recall("responseSave");
		return ""+response.getStatusCode();
	}

	public static EmployeResponse obtained() {
		return new EmployeResponse();
	}

}
