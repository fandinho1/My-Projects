package com.devexpress.demo.dxhotels.qa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#home")
public class DxHotelsPage extends PageObject {

    private DxHotelsPage(){}

    public static final Target LST_UBICACION = Target.the("Ubicacion").
            locatedBy("//input[@name='location']/parent::div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']");

    public static final Target LST_HABITACIONES = Target.the("Cantidad de habitaciones").
            locatedBy("//input[@name='rooms']/parent::div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']");

    public static final Target LST_NUMERO_ADULTOS = Target.the("Cantidad de adultos").
            locatedBy("//input[@name='adults']/parent::div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']");

    public static final Target LST_NUMERO_NINOS = Target.the("Cantidad de hijos").
            locatedBy("//input[@name='children']/parent::div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']");

    public static final Target BTN_BUSCAR = Target.the("Buscar hoteles").
            locatedBy("//span[@class='dx-button-text' and contains(text(),'SEARCH')]/parent::div[@class='dx-button-content']");

    public static final Target FECHA_INGRESO = Target.the("Fecha de ingreso").
            locatedBy("//input[@name='checkIn']/parent::div[@class='dx-dropdowneditor-input-wrapper']//input[@class='dx-texteditor-input']");

    public static final Target FECHA_SALIDA = Target.the("Fecha de salida").
            locatedBy("//input[@name='checkOut']/parent::div[@class='dx-dropdowneditor-input-wrapper']//input[@class='dx-texteditor-input']");

    public static final Target LST_FILTRO_CANTIDAD= Target.the("Cantidad a seleccionar").
            locatedBy("(//div[@class='dx-item-content dx-list-item-content' and contains(.,'{0}')])[{1}]");

    public static final Target LST_CIUDAD= Target.the("ciudad").
            locatedBy("//div[@class='dx-item-content dx-list-item-content' and contains(.,'{0}')]");

}
