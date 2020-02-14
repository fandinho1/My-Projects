package com.demoqa.restapi.questions.get;

import com.demoqa.restapi.utils.ReadJson;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CityResponse implements Question<String>{
	
	public CityResponse() {
	}
	
	@Override
	public String answeredBy(Actor actor) {
		Response response = Serenity.sessionVariableCalled("responseSave");
		/*
		 * Se puede obtener el json con la siguiente linea de codigo:
		 * JsonPath jsonPathEvaluator = response.jsonPath();
		 */
        String responseBody = response.getBody().asString();
        return ReadJson.getCityModel(responseBody).getCity();
	}

	public static CityResponse obtained() {
		return new CityResponse();
	}
}
