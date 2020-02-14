package com.demoqa.restapi.exceptions.delete;

public class DeleteEmployeException extends AssertionError{

	public static final String DELETE_EMPLOYE_ERROR = "No se pudo eliminar el empleado";
	
	public DeleteEmployeException(String message, Throwable cause) {
		super(message,cause);
	}

}
