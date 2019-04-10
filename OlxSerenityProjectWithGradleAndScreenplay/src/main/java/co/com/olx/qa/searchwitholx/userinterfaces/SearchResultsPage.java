package co.com.olx.qa.searchwitholx.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
/**
 * @author LUCHO
 */
public class SearchResultsPage extends PageObject{
	public static final Target TXT_MINPRICE= Target.the("The min price").
			locatedBy("//div[@class='filter range pricerange']//input[@placeholder='Min']");
	public static final Target TXT_MAXPRICE = Target.the("The max price").
			locatedBy("//div[@class='filter range pricerange']//input[@placeholder='Max']");
	public static final Target BUTTON_SUBMIT_PRICE = Target.the("Button submit price").
			locatedBy("//div[@class='filter range pricerange']//button[@type='submit']");
	public static final Target NO_RESULTS = Target.the("There are results").
			locatedBy("//div[@class='noresults']");
	public static final String BUTTON_NEXT_PAGE_RESULT = "//a[@class='pagination-button next']";
	public static final String QUANTITY_PAGE_RESULT = "//ul[@class='items-paginations-numbers']/li";
	public static final String RESULT_LIST = "//div[@class='items-info']//a[@title]";
}
