package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_NUMERO_ADULTOS;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.LST_FILTRO_CANTIDAD;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;

public class FiltroCantidadAdultos implements Task {

    private String cantidadAdultos;

    FiltroCantidadAdultos(String cantidadAdultos){
        this.cantidadAdultos=cantidadAdultos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_NUMERO_ADULTOS.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_NUMERO_ADULTOS));
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_FILTRO_CANTIDAD.of(cantidadAdultos,"2").resolveFor(actor).getWrappedElement());
        actor.attemptsTo(Click.on(LST_FILTRO_CANTIDAD.of(cantidadAdultos,"2")));
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),LST_NUMERO_ADULTOS.resolveFor(actor).getWrappedElement());
    }
}
