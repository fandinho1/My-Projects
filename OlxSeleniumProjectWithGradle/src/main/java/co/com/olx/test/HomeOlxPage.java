package co.com.olx.test;

import static co.com.olx.utilities.BasicBrowserConstants.*;
import static co.com.olx.utilities.HomeOlxPageConstants.*;
import static co.com.olx.utilities.TakeEvidence.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeOlxPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public HomeOlxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement goToSearchBar() {
		WebElement element = driver.findElement(TXT_BAR_SEARCH_XPATH);	
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		return element;
	}
	
	public void goToHome() {
		WebElement element = driver.findElement(GO_HOME_XPATH);
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}
	
	public void clicSearchButton() {
		WebElement element = driver.findElement(BUTTON_SEARCH_XPATH);
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}

}
