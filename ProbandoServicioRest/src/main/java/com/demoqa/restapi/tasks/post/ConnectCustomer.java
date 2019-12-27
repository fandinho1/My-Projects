package com.demoqa.restapi.tasks.post;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConnectCustomer implements Task {

	private static final String URL_SERVICE = "http://restapi.demoqa.com/customer";

	public ConnectCustomer(String inicializador) {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RestAssured.baseURI = URL_SERVICE;
		RequestSpecification httpRequest = RestAssured.given();
		actor.remember("httpRequestSave",httpRequest);
	}

}
