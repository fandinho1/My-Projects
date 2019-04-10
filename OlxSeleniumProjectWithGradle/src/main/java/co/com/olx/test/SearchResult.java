package co.com.olx.test;

import static co.com.olx.utilities.BasicBrowserConstants.*;
import static co.com.olx.utilities.SearchResultConstants.*;
import static co.com.olx.utilities.TakeEvidence.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResult {
	public WebDriver driver;
	public WebDriverWait wait;

	public SearchResult(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void selectLocation(String location) {
		//driver.findElement(By.xpath("//a[@data-location='" + location + ".olx.com.co']")).click();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-location='" + location + ".olx.com.co']")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}

	public void selectCategory(String category) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'" + category + "')]")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();
		
	}

	public void selectSubCategory(String subcategory) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#']/h2[contains(text(),'"+subcategory+"')]")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}
	
	public void insertPriceMinMax(String minPrice, String maxPrice) throws InterruptedException {
		WebElement elementMinPrice = wait.until(ExpectedConditions.elementToBeClickable(TXT_MINPRICE_XPATH));
		elementMinPrice.sendKeys(minPrice);
		HighlightElement(driver, elementMinPrice);
		takeScreenshot(driver,BROWSER);
		UnhighlightElement(driver, elementMinPrice);
		Thread.sleep(3000);
		
		WebElement elementMaxPrice = wait.until(ExpectedConditions.elementToBeClickable(TXT_MAXPRICE_XPATH));
		elementMaxPrice.sendKeys(maxPrice);
		HighlightElement(driver, elementMaxPrice);
		takeScreenshot(driver,BROWSER);
		UnhighlightElement(driver, elementMaxPrice);
		Thread.sleep(3000);
		
		WebElement elementButton = wait.until(ExpectedConditions.elementToBeClickable(BTN_SUBMIT_PRICE_XPATH));
		HighlightElement(driver, elementButton);
		elementButton.click();
		takeScreenshot(driver,BROWSER);
	}
	

	public void searchExactProduct(String titleProduct) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(titleProduct)));
			HighlightElement(driver, element);
			takeScreenshot(driver,BROWSER);
			element.sendKeys(Keys.ENTER);			
		} catch (TimeoutException ex) {
			throw new TimeoutException("No se encontró el producto");
		}		
	}
	
	public void searchExactProduct2(String titleProduct) {
		driver.get(driver.getCurrentUrl());
		
		List<WebElement> quantityElements = driver.findElements(By.xpath("//ul[@class='items-paginations-numbers']/li"));		
		int intTotalsPages = quantityElements.size()-2;
		
		if (intTotalsPages < 0) {
			searchExactProduct(titleProduct);
		} else {
			for (int counterPages = 1; counterPages < quantityElements.size(); counterPages++) {
				try {
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(titleProduct)));
					HighlightElement(driver, element);					
					element.sendKeys(Keys.ENTER);
					takeScreenshot(driver,BROWSER);
					break;
				} catch (TimeoutException ex) {
					if (counterPages == intTotalsPages) {
						takeScreenshot(driver,BROWSER);
						throw new TimeoutException("No se encontró el producto");
					} else {
						WebElement element = driver.findElement(BTN_NEXT_PAGE_RESULT_XPATH);
						HighlightElement(driver, element);	
						takeScreenshot(driver,BROWSER);
						element.click();	
						takeScreenshot(driver,BROWSER);
					}
				}
			}
		}
	}

}
