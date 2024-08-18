package com.devexpress.demo.dxhotels.qa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    public static LocalDate convertirEnFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/d/yyyy");
        LocalDate date = LocalDate.parse(fecha, formato);
        return date;
    }

    public static int calcularDiasEntreFechas(String fechaInicio, String fechaFin) {
        LocalDate fecha1 = convertirEnFecha(fechaInicio);
        LocalDate fecha2 = convertirEnFecha(fechaFin);
        Calendar calendar = Calendar.getInstance();
        int dias = fecha2.getDayOfYear() - fecha1.getDayOfYear();
        return dias + 1;
    }
}
