package co.com.olx.qa.searchwitholx.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
/**
 * @author LUCHO
 */
public class ProductPage extends PageObject {
	public static final Target TITTLE_PRODUCT = Target.the("The title product").locatedBy("//div[@class='title']/h1");

}
