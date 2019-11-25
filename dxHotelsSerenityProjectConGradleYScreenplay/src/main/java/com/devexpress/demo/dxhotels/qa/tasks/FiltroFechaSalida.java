package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.FECHA_SALIDA;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;

public class FiltroFechaSalida implements Task {

    private String fechaSalida;

    FiltroFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),FECHA_SALIDA.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(
                Enter.theValue("").into(FECHA_SALIDA).thenHit(Keys.CLEAR),
                Enter.theValue(fechaSalida).into(FECHA_SALIDA)
        );
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),FECHA_SALIDA.resolveFor(actor).getWrappedElement());

    }
}
