package co.com.olx.pom;

import static developmentutilities.ProductPageUtilities.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		ProductPage.driver = driver;
		ProductPage.wait = wait;
	}
	
	public static String getTittleProduct() {
		return driver.findElement(TITTLE_PRODUCT).getText();
	}

}
