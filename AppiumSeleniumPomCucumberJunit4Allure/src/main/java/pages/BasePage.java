package pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

abstract class BasePage {

	protected AppiumDriver driver;
	protected WebDriverWait webDriverWait;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

}
