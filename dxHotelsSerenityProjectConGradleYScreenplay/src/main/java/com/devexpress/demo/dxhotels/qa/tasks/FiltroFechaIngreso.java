package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.FECHA_INGRESO;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;

public class FiltroFechaIngreso implements Task {

    private String fechaIngreso;

    FiltroFechaIngreso(String fechaIngreso){
        this.fechaIngreso=fechaIngreso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),FECHA_INGRESO.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(
                Enter.theValue(fechaIngreso).into(FECHA_INGRESO).thenHit(Keys.TAB)
        );
        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(),FECHA_INGRESO.resolveFor(actor).getWrappedElement());
    }
}
