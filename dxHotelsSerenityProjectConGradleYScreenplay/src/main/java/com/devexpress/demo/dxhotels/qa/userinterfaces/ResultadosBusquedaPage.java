package com.devexpress.demo.dxhotels.qa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ResultadosBusquedaPage extends PageObject {

    private ResultadosBusquedaPage() {
    }

    public static final Target ETIQUETA_BUSQUEDA = Target.the("etiqueta busqueda").
            locatedBy("//div[@class='attribute-name']//p[contains(text(),'{0}')]");

    public static final String XPATH_BTN_NUMERO_PAGINA = "//div[@class='pagination']//div[@class='number-page' or @class='number-page number-page-active']";

    public static final String XPATH_PRECIO_HOTEL = "//p[@class='rate-number']";

    public static final String XPATH_NOMBRE_HOTEL = "//span[@class='name-hotel']";

    public static final Target BTN_RESERVAR_HOTEL = Target.the("reservar hotel").
            locatedBy("//span[contains(text(),'{0}')]/ancestor::div[@class='hotels-data']//div[@class='dx-button-content']");

    public static final Target BTN_PAGINA_SIGUIENTE = Target.the("pagina siguiente").
            locatedBy("//div[@class='external-for-plagination']/div[@class='switch switch-right']");

    public static final Target BTN_PAGINA_SIGUIENTE_DESACTIVADO = Target.the("no hay mas paginas").
            locatedBy("//div[@class='switch switch-right switch-right-disabled']");


    public static final Target BTN_PAGINA_ANTERIOR = Target.the("pagina anterior").
            locatedBy("//div[@class='external-for-plagination']/div[@class='switch switch-left']");

    public static final String XPATH_ELEMENTO_NO_EXISTE = "//span[contains(text(),'Esto no existe')]";

}
