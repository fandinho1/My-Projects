package com.devexpress.demo.dxhotels.qa.questions;

import com.devexpress.demo.dxhotels.qa.models.FiltrosDeBusqueda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.ReservaHotelPage.TXT_TOTAL_A_PAGAR;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ReservaHotelPage.VALOR_A_PAGAR;
import static com.devexpress.demo.dxhotels.qa.utils.Busqueda.getValorHotelMasEconomico;
import static com.devexpress.demo.dxhotels.qa.utils.Fecha.calcularDiasEntreFechas;

public class PrecioReservaHotel implements Question<Boolean> {

    FiltrosDeBusqueda filtrosDeBusqueda;

    PrecioReservaHotel(FiltrosDeBusqueda filtrosDeBusqueda){
        this.filtrosDeBusqueda=filtrosDeBusqueda;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        TXT_TOTAL_A_PAGAR.resolveFor(actor).waitUntilVisible();
        double valorWeb = Double.parseDouble(VALOR_A_PAGAR.resolveFor(actor).getText().trim().replaceAll("[$]",""));
        double precioPorDia = getValorHotelMasEconomico();
        int totalDias= calcularDiasEntreFechas(filtrosDeBusqueda.getCheckIn(),filtrosDeBusqueda.getCheckOut());
        double valorExacto = precioPorDia * totalDias;
        return valorWeb==valorExacto;
    }

    public static PrecioReservaHotel esCorrecto(FiltrosDeBusqueda filtrosDeBusqueda){
        return new PrecioReservaHotel(filtrosDeBusqueda);
    }
}
