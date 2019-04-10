package co.com.olx.qa.searchwitholx;

import static co.com.olx.pom.HomePage.*;
import static co.com.olx.pom.SpecificSearchResult.*;
import static co.com.olx.pom.ProductPage.*;
import static developmentutilities.BrowserUtilities.*;
import static developmentutilities.TakeEvidence.*;
import static developmentutilities.SearchQueryUtilities.*;
import static developmentutilities.CheckConnection.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import co.com.olx.model.SpecificSearchResultModel;
import co.com.olx.pom.HomePage;
import co.com.olx.pom.ProductPage;
import co.com.olx.pom.SpecificSearchResult;

public class SpecificSearchResultTest extends BaseTest {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		SpecificSearchResultModel specificSearchResultModel = new SpecificSearchResultModel(ANTIOQUIA, MEDELLIN,
				PARENT_CATEGORY_VIDEOJUEGOS, CONSOLAS_SUBCATEGORY_VIDEOJUEGOS);
		new SpecificSearchResult(driver, wait, specificSearchResultModel);
		new HomePage(driver, wait);
		new ProductPage(driver, wait);
	}

	@Test
	public void SearchAndFindProductTest() throws InterruptedException{
		try {
			goToSearchBar().sendKeys(SEARCH_PRODUCT);
			clicSearchButton();
			takeScreenshot(driver, BROWSER);			
			selectDepartment();			
			selectCity();			
			selectCategory();
			insertPriceMinMax(MINPRICE_PRODUCT, MAXPRICE_PRODUCT);
			searchExactProductEachPage(EXACT_PRODUCT_TO_SEARCH_1);
			assertEquals(EXACT_PRODUCT_TO_SEARCH_1.trim(), getTittleProduct().trim());
			takeScreenshot(driver, BROWSER);
		}catch (Exception ex) {
			if (connectedToInternet()) {
				throw new RuntimeException("Error arrojado por una "+ex.getClass().getSimpleName());
			} else {
				assertFalse(connectedToInternet());
				System.out.println("Se perdió la conexion a internet");
				takeScreenshot(driver, BROWSER);
			}
		}

	}

	@Test(expected = TimeoutException.class)
	public void SearchAndNotFindProductTest() throws InterruptedException {
		try {
			goToSearchBar().sendKeys(SEARCH_PRODUCT);
			clicSearchButton();
			takeScreenshot(driver, BROWSER);
			selectDepartment();
			selectCity();
			selectCategory();
			insertPriceMinMax(MINPRICE_PRODUCT, MAXPRICE_PRODUCT);
			searchExactProductEachPage(EXACT_PRODUCT_TO_SEARCH_3);
			takeScreenshot(driver, BROWSER);
		} catch (Exception ex) {
			if (connectedToInternet()) {
				if (ex.getClass().getSimpleName().equals(TimeoutException.class.getSimpleName())) {
					throw new TimeoutException();
				} else {
					throw new RuntimeException("Error arrojado por una " + ex.getClass().getSimpleName());
				}
			} else {
				assertFalse(connectedToInternet());
				System.out.println("Se perdió la conexion a internet");
				takeScreenshot(driver, BROWSER);
			}
		}
	}

}
