package com.demoqa.restapi.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.demoqa.restapi.tasks.get.ConnectCity;
import com.demoqa.restapi.tasks.post.ConnectCustomer;
import com.demoqa.restapi.tasks.put.ConnectDummy;

import net.serenitybdd.screenplay.Performable;

public class Connect {
	
	private Connect() {}
	
	public static Performable toTheCityPage() {
		return instrumented(ConnectCity.class, "");
	}
	
	public static Performable toTheCustomerPage() {
		return instrumented(ConnectCustomer.class, "");
	}
	
	public static Performable toTheDummyPage(String idEmpleado) {
		return instrumented(ConnectDummy.class, idEmpleado);
	}
	
	public static Performable toTheDummyPage() {
		return instrumented(ConnectDummy.class, "");
	}


}
