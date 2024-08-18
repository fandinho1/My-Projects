package com.devexpress.demo.dxhotels.qa.stepdefinitions;

import com.devexpress.demo.dxhotels.qa.exceptions.ResultadosBusquedaException;
import com.devexpress.demo.dxhotels.qa.models.FiltrosDeBusqueda;
import com.devexpress.demo.dxhotels.qa.questions.ResultadosDeBusqueda;
import com.devexpress.demo.dxhotels.qa.tasks.BuscarConLosFiltros;
import com.devexpress.demo.dxhotels.qa.tasks.Filtrar;
import com.devexpress.demo.dxhotels.qa.userinterfaces.DxHotelsPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuscarHotelStepDefinition {

    private DxHotelsPage dxHotelsPage;

    @Dado("^que el usuario esta en la pagina principal de DxHotels$")
    public void queElUsuarioEstaEnLaPaginaPrincipalDeDxHotels() {
        theActorCalled("usuario").wasAbleTo(Open.browserOn().the(dxHotelsPage));
    }

    @Cuando("^el busca un hotel usando todos los filtros$")
    public void elBuscaUnHotel(List<FiltrosDeBusqueda> conElDatoEspecificado) {
        theActorInTheSpotlight().attemptsTo(
                Filtrar.porUbicacion(conElDatoEspecificado.get(0)),
                Filtrar.porFechaDeIngreso(conElDatoEspecificado.get(0)),
                Filtrar.porFechaDeSalida(conElDatoEspecificado.get(0)),
                Filtrar.porCantidadDeHabitaciones(conElDatoEspecificado.get(0)),
                Filtrar.porCantidadDeAdultos(conElDatoEspecificado.get(0)),
                Filtrar.porCantidadDeNinos(conElDatoEspecificado.get(0)),
                BuscarConLosFiltros.seleccionados()
        );
    }

    @Entonces("^el deberia ver los resultados de busqueda de (.*)$")
    public void elDeberiaVerLosResultadosDeBusqueda(String ubicacion) {
        theActorInTheSpotlight().should(
                seeThat(ResultadosDeBusqueda.sonEncontrados(ubicacion)).
                        orComplainWith(ResultadosBusquedaException.class, ResultadosBusquedaException.RESULTADOS_NO_ENCONTRADOS));
    }

}
