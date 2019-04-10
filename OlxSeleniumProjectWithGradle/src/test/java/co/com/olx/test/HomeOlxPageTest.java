package co.com.olx.test;

import static co.com.olx.utilities.BasicBrowserConstants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.olx.test.HomeOlxPage;

public class HomeOlxPageTest extends BaseTest {
	private HomeOlxPage objectHomeOlxPage;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		objectHomeOlxPage = new HomeOlxPage(driver, wait);
	}
	
	@Test
	public void goBarSearchTest() {
		assertEquals("¿Qué estás buscando?", objectHomeOlxPage.goToSearchBar().getAttribute("placeholder"));
	}
	
	@Test
	public void goHomeTest() {
		driver.get("https://www.olx.com.co/vehiculos-motos-cat-362");
		objectHomeOlxPage.goToHome();
		assertEquals(URL_PAGE, driver.getCurrentUrl());
	}
}
