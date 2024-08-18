package com.devexpress.demo.dxhotels.qa.stepdefinitions;

import com.devexpress.demo.dxhotels.qa.exceptions.PrecioHotelException;
import com.devexpress.demo.dxhotels.qa.models.FiltrosDeBusqueda;
import com.devexpress.demo.dxhotels.qa.questions.PrecioReservaHotel;
import com.devexpress.demo.dxhotels.qa.tasks.ReservarHotel;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EscogerHotelStepDefinition {

    @Cuando("^el escoge el hotel mas economico$")
    public void elEscogeElHotelMasEconomico() {
        theActorInTheSpotlight().attemptsTo(
                ReservarHotel.masEconomico()
        );
    }

    @Entonces("^el deberia ver que el precio es correcto$")
    public void elDeberiaVerQueElPrecioEsCorrecto(List<FiltrosDeBusqueda> conLasFechasIndicadas) {
        theActorInTheSpotlight().should(
                seeThat(PrecioReservaHotel.esCorrecto(conLasFechasIndicadas.get(0))).
                        orComplainWith(PrecioHotelException.class,PrecioHotelException.PRECIO_INCORRECTO));
    }
}
