package co.com.olx.qa.searchwitholx.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
/**
 * @author LUCHO
 */
@DefaultUrl("https://www.olx.com.co/")
public class OlxHomePage extends PageObject {
	public static final Target TXT_SEARCH_BAR = Target.the("The search bar").
			locatedBy("//input[@placeholder='¿Qué estás buscando?']");
	public static final Target BUTTON_GO_HOME = Target.the("The button to go home").
			locatedBy("//a[@title='OLX']");
	public static final Target SEARCH_BUTTON = Target.the("The search button").
			locatedBy("//button[@class='submit icons-material icon-material-search']");

}
