package com.demoqa.restapi.tasks.put;

import com.demoqa.restapi.models.Employe;
import com.demoqa.restapi.utils.ReadJson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Update implements Task {
	
	private Employe employe;
	
	public Update(Employe employe) {
		this.employe = employe;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RequestSpecification httpRequest = actor.recall("httpRequestSave");
		httpRequest.body(ReadJson.getJsonObjectForEmploye(employe));
		String idEmpleado = actor.recall("idEmpleado");
		Response response = httpRequest.put("/update/"+ idEmpleado);
		actor.remember("responseSave", response);
	}

	public static Performable theEmployeInformation(Employe employe) {
		return instrumented(Update.class, employe);
	}

}
