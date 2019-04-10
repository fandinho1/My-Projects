package com.sophos.pom;

import static developmentutilities.BrowserUtilities.BROWSER;
import static developmentutilities.HomePageUtilities.*;
import static developmentutilities.TakeEvidence.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		HomePage.driver = driver;
		HomePage.wait=wait;
	}
	
	public static WebElement goToSearchBar() {
		WebElement element= driver.findElement(TXT_BAR_SEARCH_NAME);
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		return element;
	}
	
	public static void clicSearchButton() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SEARCH_NAME));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();	
	}
	public static void goToHomePage() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BUTTON_GO_HOME_XPATH));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();
	}
	

}
