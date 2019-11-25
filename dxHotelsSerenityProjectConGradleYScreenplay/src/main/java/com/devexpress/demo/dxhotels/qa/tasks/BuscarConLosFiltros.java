package com.devexpress.demo.dxhotels.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage.BTN_BUSCAR;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarConLosFiltros implements Task {

    BuscarConLosFiltros(String inicializador){

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        resaltarElemento(BrowseTheWeb.as(actor).getDriver(),BTN_BUSCAR.resolveFor(actor).getWrappedElement());
        actor.attemptsTo(
                Click.on(BTN_BUSCAR)
        );
    }

    public static Performable seleccionados(){
        return instrumented(BuscarConLosFiltros.class,"");
    }
}
