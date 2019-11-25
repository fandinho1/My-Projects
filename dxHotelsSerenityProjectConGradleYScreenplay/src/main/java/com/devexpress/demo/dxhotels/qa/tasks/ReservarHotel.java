package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static com.devexpress.demo.dxhotels.qa.utils.Busqueda.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ReservarHotel implements Task {

    ReservarHotel(String inicializador){}

    @Override
    public <T extends Actor> void performAs(T actor) {
        reservarHotelMasEconomico(actor);
    }

    public static Performable masEconomico(){
        return instrumented(ReservarHotel.class,"");
    }
}
