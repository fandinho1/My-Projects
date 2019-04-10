package co.com.olx.qa.searchwitholx.utils;

import org.openqa.selenium.TimeoutException;

import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.questions.TheInternet;

import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.BUTTON_NEXT_PAGE_RESULT;
import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.QUANTITY_PAGE_RESULT;
import static co.com.olx.qa.searchwitholx.userinterfaces.SearchResultsPage.RESULT_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ProductSearch extends PageObject {
	
	/**
	 * This method search a product as a actor in first page from search results and return the webElementFacade 
	 * from the product if it is found
	 * @param actor - actor that navigate the page
	 * @param titleProduct - product to search
	 * @return a WebElementFacade with the product searched
	 */
	public static WebElementFacade searchExactProduct(Actor actor, String titleProduct) {
		try {
			return BrowseTheWeb.as(actor).findBy("//div[@class='items-info']//a[@title='" + titleProduct + "']")
					.waitUntilClickable();
		} catch (TimeoutException ex) {
			throw new TimeoutException();
		}
	}

	/**
	 * This method search a product as a actor in each page from search results and return the webElementFacade 
	 * from the product if it is found
	 * @param actor - actor that navigate the page
	 * @param titleProduct - product to search
	 * @return a WebElementFacade with the product searched
	 */
	public static WebElementFacade searchExactProductEachPage(Actor actor, String titleProduct) {
		BrowseTheWeb.as(actor).getDriver().get(BrowseTheWeb.as(actor).getDriver().getCurrentUrl());

		List<WebElementFacade> quantityElements = BrowseTheWeb.as(actor).findAll(QUANTITY_PAGE_RESULT);
		int intTotalsPages = quantityElements.size() - 2;

		if (intTotalsPages < 0) {
			searchExactProduct(actor, titleProduct);
		} else {
			for (int counterPages = 1; counterPages < quantityElements.size(); counterPages++) {
				try {
					return BrowseTheWeb.as(actor).findBy("//div[@class='items-info']//a[@title='" + titleProduct + "']")
							.waitUntilClickable();
				} catch (TimeoutException ex) {
					if (counterPages == intTotalsPages) {
						throw new TimeoutException();
					} else {
						actor.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
								NotInternetConnection.NOT_CONNECTION));
						BrowseTheWeb.as(actor).findBy(BUTTON_NEXT_PAGE_RESULT).waitUntilClickable().click();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * This method save all product that are in first page from search results and return the webElementFacade 
	 * from the random product selected
	 * @param actor - actor that navigate the page
	 * @return a WebElementFacade with the random product selected
	 */
	public static WebElementFacade selectRandomProduct(Actor actor) {
		BrowseTheWeb.as(actor).getDriver().get(BrowseTheWeb.as(actor).getDriver().getCurrentUrl());
		List<WebElementFacade> webElementFacades = BrowseTheWeb.as(actor).findAll(RESULT_LIST);
		int randomProduct = (int) (Math.random()*webElementFacades.size());
		return webElementFacades.get(randomProduct).waitUntilClickable();
	}

}
