package com.demoqa.restapi.tasks.get;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;

public class ConnectCity implements Task {
	
	private static final String URL_SERVICE="http://restapi.demoqa.com/utilities/weather/city";

	public ConnectCity(String inicializador) {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RestAssured.baseURI = URL_SERVICE;
		RequestSpecification httpRequest = RestAssured.given();
		Serenity.setSessionVariable("httpRequestSave").to(httpRequest);
	}

}
