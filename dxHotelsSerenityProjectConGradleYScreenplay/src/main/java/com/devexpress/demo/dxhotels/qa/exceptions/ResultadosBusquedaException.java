package com.devexpress.demo.dxhotels.qa.exceptions;

public class ResultadosBusquedaException extends AssertionError {

    public static final String RESULTADOS_NO_ENCONTRADOS= "No se encontro ningun resultado en la busqueda";

    public ResultadosBusquedaException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }



}
