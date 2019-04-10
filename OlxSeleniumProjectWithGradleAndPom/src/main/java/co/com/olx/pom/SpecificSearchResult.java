package co.com.olx.pom;

import static developmentutilities.BrowserUtilities.*;
import static developmentutilities.TakeEvidence.*;
import static developmentutilities.SpecificSearchResultUtilities.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.com.olx.model.SpecificSearchResultModel;

public class SpecificSearchResult {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static SpecificSearchResultModel specificSearchResultModel;

	
	public SpecificSearchResult(WebDriver driver, WebDriverWait wait, SpecificSearchResultModel specificSearchResultModel) {
		SpecificSearchResult.driver = driver;
		SpecificSearchResult.wait = wait;
		SpecificSearchResult.specificSearchResultModel = specificSearchResultModel;
	}

	public static void selectDepartment() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-location='" +
								specificSearchResultModel.getDepartament() + ".olx.com.co']")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}
	public static void selectCity() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-location='" + 
								specificSearchResultModel.getCity() + ".olx.com.co']")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}

	public static void selectCategory() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'" + 
								specificSearchResultModel.getCategory() + "')]")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();
		
	}

	public static void selectSubCategory() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#']/h2[contains(text(),'"+
								specificSearchResultModel.getSubcategory()+"')]")));
		HighlightElement(driver, element);
		takeScreenshot(driver,BROWSER);
		element.click();		
	}
	
	public static void insertPriceMinMax(String minPrice, String maxPrice) throws InterruptedException {
		Thread.sleep(2000);
		WebElement elementMinPrice = wait.until(ExpectedConditions.elementToBeClickable(TXT_MINPRICE_XPATH));
		elementMinPrice.sendKeys(minPrice);
		HighlightElement(driver, elementMinPrice);
		takeScreenshot(driver,BROWSER);
		UnhighlightElement(driver, elementMinPrice);
		Thread.sleep(2000);
		
		WebElement elementMaxPrice = wait.until(ExpectedConditions.elementToBeClickable(TXT_MAXPRICE_XPATH));
		elementMaxPrice.sendKeys(maxPrice);
		HighlightElement(driver, elementMaxPrice);
		takeScreenshot(driver,BROWSER);
		UnhighlightElement(driver, elementMaxPrice);
		Thread.sleep(2000);
		
		WebElement elementButton = wait.until(ExpectedConditions.elementToBeClickable(BTN_SUBMIT_PRICE_XPATH));
		HighlightElement(driver, elementButton);
		elementButton.click();
		takeScreenshot(driver,BROWSER);
	}
	

	public static void searchExactProduct(String titleProduct) throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(titleProduct)));
			HighlightElement(driver, element);
			takeScreenshot(driver,BROWSER);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} catch (TimeoutException ex) {
			throw new TimeoutException("No se encontró el producto");
		}		
	}
	
	public static void searchExactProductEachPage(String titleProduct) throws InterruptedException {
		Thread.sleep(2000);
		driver.get(driver.getCurrentUrl());
		
		List<WebElement> quantityElements = driver.findElements(QUANTITY_PAGE_RESULT_XPATH);		
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
					Thread.sleep(3000);
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
