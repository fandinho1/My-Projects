package co.com.olx.test;

import static co.com.olx.utilities.QueryConstants.*;
import static co.com.olx.utilities.BasicBrowserConstants.*;
import static co.com.olx.utilities.TakeEvidence.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import co.com.olx.test.HomeOlxPage;
import co.com.olx.test.SearchResult;

public class SearchResultTest extends BaseTest{
	private HomeOlxPage objectHomeOlxPage;
	private SearchResult objectSearchResult;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		objectHomeOlxPage = new HomeOlxPage(driver, wait);
		objectSearchResult = new SearchResult(driver, wait);
	}
	
	@Test
	public void SearchAndFindProductTest() throws InterruptedException {
		objectHomeOlxPage.goToSearchBar().sendKeys(SEARCH_PRODUCT);
		objectHomeOlxPage.clicSearchButton();
		takeScreenshot(driver, BROWSER);	
		Thread.sleep(3000);
		objectSearchResult.selectLocation(ANTIOQUIA);
		Thread.sleep(3000);
		objectSearchResult.selectLocation(MEDELLIN);
		Thread.sleep(3000);
		objectSearchResult.selectCategory(PARENT_CATEGORY_VIDEOJUEGOS);
		Thread.sleep(3000);
		objectSearchResult.insertPriceMinMax(MINPRICE_PRODUCT, MAXPRICE_PRODUCT);
		Thread.sleep(3000);
		objectSearchResult.searchExactProduct2(EXACT_PRODUCT_TO_SEARCH_1);
		Thread.sleep(3000);
		assertEquals(EXACT_PRODUCT_TO_SEARCH_1.trim(),driver.findElement(By.xpath("//div[@class='title']/h1")).getText().trim());
		takeScreenshot(driver, BROWSER);
	}
	
	@Test(expected=TimeoutException.class)
	public void SearchAndNotFindProductTest() throws InterruptedException {
		objectHomeOlxPage.goToSearchBar().sendKeys(SEARCH_PRODUCT);
		objectHomeOlxPage.clicSearchButton();
		takeScreenshot(driver, BROWSER);
		Thread.sleep(3000);
		objectSearchResult.selectLocation(ANTIOQUIA);
		Thread.sleep(3000);
		objectSearchResult.selectLocation(MEDELLIN);	
		Thread.sleep(3000);
		objectSearchResult.selectCategory(PARENT_CATEGORY_VIDEOJUEGOS);
		Thread.sleep(3000);
		objectSearchResult.insertPriceMinMax(MINPRICE_PRODUCT, MAXPRICE_PRODUCT);	
		Thread.sleep(3000);
		objectSearchResult.searchExactProduct2(EXACT_PRODUCT_TO_SEARCH_3);
		takeScreenshot(driver, BROWSER);
	}
}
