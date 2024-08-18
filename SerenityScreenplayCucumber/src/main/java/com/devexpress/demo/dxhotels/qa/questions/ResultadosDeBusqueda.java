package com.devexpress.demo.dxhotels.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.ETIQUETA_BUSQUEDA;

public class ResultadosDeBusqueda implements Question<Boolean> {

    private String ubicacion;

    ResultadosDeBusqueda(String ubicacion){
        this.ubicacion=ubicacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if(ETIQUETA_BUSQUEDA.of(ubicacion).resolveFor(actor).isVisible()){
            return true;
        } else {
            return false;
        }
    }

    public static ResultadosDeBusqueda sonEncontrados(String ubicacion) {
        return new ResultadosDeBusqueda(ubicacion);
    }
}
