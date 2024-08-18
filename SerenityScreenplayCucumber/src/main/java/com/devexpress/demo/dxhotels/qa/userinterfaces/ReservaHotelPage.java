package com.devexpress.demo.dxhotels.qa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ReservaHotelPage extends PageObject {

    private ReservaHotelPage() {
    }

    public static final Target TXT_TOTAL_A_PAGAR = Target.the("total a pagar").
            locatedBy("//p[contains(text(),'TOTAL TO PAY NOW')]");

    public static final Target VALOR_A_PAGAR = Target.the("valor total a pagar").
            locatedBy("//h4[@class='total-price']");
}
