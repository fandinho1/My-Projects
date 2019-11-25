package com.devexpress.demo.dxhotels.qa.tasks;

import com.devexpress.demo.dxhotels.qa.models.FiltrosDeBusqueda;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Filtrar {

    private Filtrar(){}

    public static Performable porUbicacion(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroUbicacion.class, filtrosDeBusqueda.getLocation());
    }

    public static Performable porFechaDeIngreso(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroFechaIngreso.class, filtrosDeBusqueda.getCheckIn());
    }

    public static Performable porFechaDeSalida(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroFechaSalida.class, filtrosDeBusqueda.getCheckOut());
    }

    public static Performable porCantidadDeHabitaciones(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroCantidadHabitaciones.class, filtrosDeBusqueda.getRooms());
    }

    public static Performable porCantidadDeAdultos(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroCantidadAdultos.class, filtrosDeBusqueda.getAdults());
    }

    public static Performable porCantidadDeNinos(FiltrosDeBusqueda filtrosDeBusqueda) {
        return instrumented(FiltroCantidadNinos.class, filtrosDeBusqueda.getChildren());
    }

}
