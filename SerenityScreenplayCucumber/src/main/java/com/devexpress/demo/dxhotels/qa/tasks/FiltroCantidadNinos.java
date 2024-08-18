package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_NUMERO_NINOS;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_FILTRO_CANTIDAD;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;

public class FiltroCantidadNinos implements Task {

    private String cantidadNinos;

    FiltroCantidadNinos(String cantidadNinos){
        this.cantidadNinos=cantidadNinos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_NUMERO_NINOS.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_NUMERO_NINOS));
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_FILTRO_CANTIDAD.of(cantidadNinos,"3").resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_FILTRO_CANTIDAD.of(cantidadNinos,"3")));
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_NUMERO_NINOS.resolveFor(actor).getWrappedElement());
    }
}
