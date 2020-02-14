package com.demoqa.restapi.exceptions.get;

public class ConsultCityException extends AssertionError {

	public static final String CITY_NOT_EQUALS = "The city of the server is not equals to value expected";
	public static final String STATUS_CODE_INCORRECT = "Se esperaba 200, pero el status obtenido fue otro";
	public static final String STATUS_LINE_INCORRECT = "El status line esperado no corresponde con el obtenido";

	public ConsultCityException(String message) {
		super(message);
	}

}
