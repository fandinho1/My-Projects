package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_CIUDAD;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_UBICACION;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;

public class FiltroUbicacion implements Task {

    private String ubicacion;

    FiltroUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_UBICACION.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_UBICACION));
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_CIUDAD.of(ubicacion).resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_CIUDAD.of(ubicacion)));
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_UBICACION.resolveFor(actor).getWrappedElement());
    }
}
