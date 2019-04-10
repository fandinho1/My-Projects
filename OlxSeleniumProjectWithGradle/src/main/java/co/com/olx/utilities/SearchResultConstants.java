package co.com.olx.utilities;

import org.openqa.selenium.By;

public class SearchResultConstants {
	public static final By TXT_MINPRICE_XPATH = By.xpath("//div[@class='filter range pricerange']//input[@placeholder='Min']");	
	public static final By TXT_MAXPRICE_XPATH = By.xpath("//div[@class='filter range pricerange']//input[@placeholder='Max']");	
	public static final By BTN_SUBMIT_PRICE_XPATH = By.xpath("//div[@class='filter range pricerange']//button[@type='submit']");
	public static final By BTN_NEXT_PAGE_RESULT_XPATH = By.xpath("//a[@class='pagination-button next']");

}
