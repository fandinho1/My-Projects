package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_HABITACIONES;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_FILTRO_CANTIDAD;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;

public class FiltroCantidadHabitaciones implements Task {

    private String habitaciones;

    FiltroCantidadHabitaciones(String habitaciones){
        this.habitaciones=habitaciones;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_HABITACIONES.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_HABITACIONES));
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_FILTRO_CANTIDAD.of(habitaciones,"1").resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_FILTRO_CANTIDAD.of(habitaciones,"1")));
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_HABITACIONES.resolveFor(actor).getWrappedElement());
    }
}
