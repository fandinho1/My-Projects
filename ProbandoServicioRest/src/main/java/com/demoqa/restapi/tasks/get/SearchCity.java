package com.demoqa.restapi.tasks.get;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;

public class SearchCity implements Task{
	
	private String city;
	
	SearchCity(String city) {
		this.city=city;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RequestSpecification httpRequest = Serenity.sessionVariableCalled("httpRequestSave");
        Response response = httpRequest.request(Method.GET, "/"+this.city);
        Serenity.setSessionVariable("responseSave").to(response);			
	}
	
	public static Performable inTheService(String city) {
		return instrumented(SearchCity.class,city);		
	}

}
