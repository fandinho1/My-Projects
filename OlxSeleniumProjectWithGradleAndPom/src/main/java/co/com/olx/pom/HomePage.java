package co.com.olx.pom;

import static developmentutilities.BrowserUtilities.*;
import static developmentutilities.TakeEvidence.*;
import static developmentutilities.HomePageUtilities.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		HomePage.driver = driver;
		HomePage.wait = wait;
	}
	
	public static WebElement goToSearchBar() {
		WebElement element = driver.findElement(TXT_BAR_SEARCH_XPATH);	
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		return element;
	}
	
	public static void goToHome() {
		WebElement element = driver.findElement(GO_HOME_XPATH);
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}
	
	public static void clicSearchButton() {
		WebElement element = driver.findElement(BUTTON_SEARCH_XPATH);
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}

}
