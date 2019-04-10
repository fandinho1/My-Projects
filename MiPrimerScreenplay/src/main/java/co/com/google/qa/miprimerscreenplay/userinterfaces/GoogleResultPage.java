package co.com.google.qa.miprimerscreenplay.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GoogleResultPage extends PageObject {
	public static final Target SEARCH_BAR = Target.the("The search bar").located(By.name("q"));
	public static final Target QUANTITY_RESULTS = Target.the("results list").located(By.id("resultStats"));
	public static final Target RESULTS = Target.the("There are results").
			locatedBy("//div[@id='search']//h1[contains(text(),'Resultados de búsqueda')]");

}
