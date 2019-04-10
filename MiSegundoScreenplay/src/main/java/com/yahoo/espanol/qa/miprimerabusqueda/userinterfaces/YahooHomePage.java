package com.yahoo.espanol.qa.miprimerabusqueda.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://espanol.yahoo.com/")
public class YahooHomePage extends PageObject{
	public static final Target SEARCH_BAR = Target.the("The search bar").located(By.name("p"));
	public static final Target SEARCH_BUTTON = Target.the("The search button").located(By.id("uh-search-button"));

}
