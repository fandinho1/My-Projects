package com.demoqa.restapi.tasks.put;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConnectDummy implements Task{
	
	private static final String URL_SERVICE = "http://dummy.restapiexample.com/api/v1";
	
	private String idEmpleado;

	public ConnectDummy(String idEmpleado) {
		this.idEmpleado=idEmpleado;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RestAssured.baseURI = URL_SERVICE;
		RequestSpecification httpRequest = RestAssured.given();
		actor.remember("httpRequestSave",httpRequest);
		actor.remember("idEmpleado", idEmpleado);
	}
}
