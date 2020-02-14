package com.demoqa.restapi.tasks.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete implements Task{
	
	private String idEmppleado;
	
	public Delete(String idEmppleado) {
		this.idEmppleado = idEmppleado;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RequestSpecification httpRequest = actor.recall("httpRequestSave");
		Response response = httpRequest.delete("/delete/"+ idEmppleado);
		actor.remember("responseSave", response);
	}
	
	public static Performable anEmploye(String withIdEmpleado) {
		return instrumented(Delete.class, withIdEmpleado);
	}

}
