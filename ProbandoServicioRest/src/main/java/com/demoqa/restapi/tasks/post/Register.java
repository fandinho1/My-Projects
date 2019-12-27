package com.demoqa.restapi.tasks.post;

import com.demoqa.restapi.models.Consumer;
import com.demoqa.restapi.utils.ReadJson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task{
	
	private Consumer consumer;
	
	public Register(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		RequestSpecification httpRequest = actor.recall("httpRequestSave");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(ReadJson.getJsonObjectForConsumer(consumer));
        Response response = httpRequest.post("/register");
        actor.remember("responseSave", response);
	}

	public static Performable inConsumerPage(Consumer consumer) {
		return instrumented(Register.class, consumer);
	}

}
