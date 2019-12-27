package com.demoqa.restapi.tasks.delete;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConnectDummyToDelete implements Task {
	
	private static final String URL_SERVICE = "http://dummy.restapiexample.com/api/v1";
	
	public ConnectDummyToDelete(String inicializador) {}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		RestAssured.baseURI = URL_SERVICE;
		RequestSpecification httpRequest = RestAssured.given();
		actor.remember("httpRequestSave",httpRequest);
	}

}
