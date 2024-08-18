package com.devexpress.demo.dxhotels.qa.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.XPATH_BTN_NUMERO_PAGINA;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.XPATH_NOMBRE_HOTEL;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.XPATH_PRECIO_HOTEL;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.BTN_PAGINA_SIGUIENTE;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.BTN_RESERVAR_HOTEL;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.BTN_PAGINA_ANTERIOR;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.XPATH_ELEMENTO_NO_EXISTE;
import static com.devexpress.demo.dxhotels.qa.userinterfaces.ResultadosBusquedaPage.BTN_PAGINA_SIGUIENTE_DESACTIVADO;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.desresaltarElemento;
import static com.devexpress.demo.dxhotels.qa.utils.ElementoWebUtil.resaltarElemento;
import static net.serenitybdd.core.pages.WebElementExpectations.elementIsNotPresent;

public class Busqueda {

    private static String hotelMasEconomico;
    private static int valorHotelMasEconomico;
    private static WebElementFacade elementoNoExiste;

    private Busqueda() {
    }

    public static String getHotelMasEconomico() {
        return hotelMasEconomico;
    }

    public static void setHotelMasEconomico(String hotelMasEconomico) {
        Busqueda.hotelMasEconomico = hotelMasEconomico;
    }

    public static int getValorHotelMasEconomico() {
        return valorHotelMasEconomico;
    }

    public static void setValorHotelMasEconomico(int valorHotelMasEconomico) {
        Busqueda.valorHotelMasEconomico = valorHotelMasEconomico;
    }

    public static void buscarHotelMasEconomicoPorPagina(Actor actor) {
        int contadorPaginas = 0;
        List<WebElementFacade> listaPaginas = BrowseTheWeb.as(actor).findAll(XPATH_BTN_NUMERO_PAGINA);
        List<WebElementFacade> listaPrecios = BrowseTheWeb.as(actor).findAll(XPATH_PRECIO_HOTEL);
        List<WebElementFacade> listaHoteles = BrowseTheWeb.as(actor).findAll(XPATH_NOMBRE_HOTEL);
        setValorHotelMasEconomico(Integer.parseInt(listaPrecios.get(0).getText().replaceAll("[$]", "")));
        setHotelMasEconomico(listaHoteles.get(0).getText());
        if (listaPaginas.get(0).isVisible()) {
            while (contadorPaginas < listaPaginas.size()) {
                contadorPaginas++;
                buscarHotelMasEconomico(actor, getValorHotelMasEconomico());
                if (contadorPaginas < listaPaginas.size()) {
                    resaltarElemento(BrowseTheWeb.as(actor).getDriver(), BTN_PAGINA_SIGUIENTE.resolveFor(actor).getWrappedElement());
                    actor.attemptsTo(Click.on(BTN_PAGINA_SIGUIENTE));
                    if (contadorPaginas < listaPaginas.size() - 1) {
                        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(), BTN_PAGINA_SIGUIENTE.resolveFor(actor).getWrappedElement());
                    } else {
                        desresaltarElemento(BrowseTheWeb.as(actor).getDriver(), BTN_PAGINA_SIGUIENTE_DESACTIVADO.resolveFor(actor).getWrappedElement());
                    }
                    BTN_PAGINA_SIGUIENTE.resolveFor(actor).waitForCondition().until(elementIsNotPresent(elementoNoExiste));
                }
            }
        } else {
            buscarHotelMasEconomico(actor, getValorHotelMasEconomico());
        }
    }

    public static void buscarHotelMasEconomico(Actor actor, int valorEconomicoActual) {
        List<WebElementFacade> listaPrecios = BrowseTheWeb.as(actor).findAll(XPATH_PRECIO_HOTEL);
        List<WebElementFacade> listaHoteles = BrowseTheWeb.as(actor).findAll(XPATH_NOMBRE_HOTEL);
        elementoNoExiste = BrowseTheWeb.as(actor).findBy(XPATH_ELEMENTO_NO_EXISTE);
        for (int i = 0; i < listaHoteles.size(); i++) {
            int precio = Integer.parseInt(listaPrecios.get(i).getText().replaceAll("[$]", ""));
            if (precio < valorEconomicoActual) {
                setValorHotelMasEconomico(precio);
                valorEconomicoActual = precio;
                setHotelMasEconomico(listaHoteles.get(i).getText());
            }
        }
    }

    public static void reservarHotelMasEconomico(Actor actor) {
        buscarHotelMasEconomicoPorPagina(actor);
        boolean encontrado = false;
        while (!encontrado) {
            if (BTN_RESERVAR_HOTEL.of(getHotelMasEconomico()).resolveFor(actor).isPresent()) {
                resaltarElemento(BrowseTheWeb.as(actor).getDriver(), BTN_RESERVAR_HOTEL.of(getHotelMasEconomico()).resolveFor(actor).getWrappedElement());
                actor.attemptsTo(Click.on(BTN_RESERVAR_HOTEL.of(getHotelMasEconomico())));
                encontrado = true;
            } else {
                resaltarElemento(BrowseTheWeb.as(actor).getDriver(), BTN_PAGINA_ANTERIOR.resolveFor(actor).getWrappedElement());
                actor.attemptsTo(Click.on(BTN_PAGINA_ANTERIOR));
                BTN_PAGINA_ANTERIOR.resolveFor(actor).waitForCondition().until(elementIsNotPresent(elementoNoExiste));
            }
        }
    }
}
