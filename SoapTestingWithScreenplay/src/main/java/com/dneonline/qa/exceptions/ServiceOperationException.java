package com.dneonline.qa.exceptions;

public class ServiceOperationException extends AssertionError {
    public static final String OPERATION_ERROR = "Ocurrio un error en la operacion";

    public ServiceOperationException(String message, Throwable cause){
        super(message,cause);
    }
}
