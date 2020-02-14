package com.demoqa.restapi.exceptions.put;

public class UpdateEmployeException extends AssertionError{

	public static final String UPDATE_EMPLOYE_ERROR = "No se pudieron actualizar los datos del empleado";
	
	public UpdateEmployeException(String message, Throwable cause) {
		super(message,cause);
	}

}
