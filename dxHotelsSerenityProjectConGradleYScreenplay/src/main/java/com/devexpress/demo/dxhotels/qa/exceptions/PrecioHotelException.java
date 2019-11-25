package com.devexpress.demo.dxhotels.qa.exceptions;

public class PrecioHotelException extends AssertionError {

    public static final String PRECIO_INCORRECTO = "El precio total no es correcto: Formula = Nro dias * Precio dia";

    public PrecioHotelException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }
}
