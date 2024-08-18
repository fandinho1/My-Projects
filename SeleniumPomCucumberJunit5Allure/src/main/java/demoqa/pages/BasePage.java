package demoqa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
	
	protected WebDriver webDriver;
	protected WebDriverWait webDriverWait;
	
	public BasePage(WebDriver webDriver) {
		this.webDriver=webDriver;
		webDriverWait= new WebDriverWait(webDriver, Duration.ofSeconds(10));
	}

}
