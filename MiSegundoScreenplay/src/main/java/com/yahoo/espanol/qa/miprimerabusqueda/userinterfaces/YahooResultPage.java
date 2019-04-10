package com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class YahooResultPage extends PageObject {
	public static final Target SEARCH_BAR = Target.the("The search bar").located(By.name("p"));
}
