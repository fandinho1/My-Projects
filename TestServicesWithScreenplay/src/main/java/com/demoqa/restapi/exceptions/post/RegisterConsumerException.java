package com.demoqa.restapi.exceptions.post;

public class RegisterConsumerException extends AssertionError {

	public static final String REGISTER_USER_ERROR = "El usuario no pudo ser registrado";
	
	public RegisterConsumerException(String message, Throwable cause) {
		super(message, cause);
	}

}
